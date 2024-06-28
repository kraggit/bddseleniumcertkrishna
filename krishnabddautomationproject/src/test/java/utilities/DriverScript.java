package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DriverScript {
	KeywordActions keywordActions;
	
	public DriverScript() {
		keywordActions=new KeywordActions();
	}
	
	public static void main(String args[]) throws Exception {
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata/KeywordDrivenData.xlsx", "Module1", "TC1");
		
	}
	
	
	public void runScript(String excelSheetPath,String sheetName,String testCaseIdValue) throws Exception {
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(excelSheetPath);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			int rowCount=sheet.getLastRowNum()+1;
			
			for(int i=1;i<=rowCount;i++) {
				XSSFRow row=sheet.getRow(i);
				String testCaseId=getCellValue(row, 0);
				if(!testCaseId.equalsIgnoreCase(testCaseIdValue)) {
					continue;
				}
				String stepDescription=getCellValue(row, 1);
				String locatorType=getCellValue(row, 2);
				String locatorValue=getCellValue(row, 3);
				String testData=getCellValue(row, 4);
				String action=getCellValue(row, 5);
				System.out.println(testCaseId+"-"+stepDescription+"-"+locatorType+"-"+locatorValue+"-"
						+testData+"-"+action);
				keywordActions.performOperation(action, locatorType, locatorValue, testData);
			}
			workbook.close();
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	private String getCellValue(XSSFRow row,int columnIndex) {
		
		if(row==null||row.getCell(columnIndex)==null) {
			return "";
		}
		else {
			return row.getCell(columnIndex).getStringCellValue();
		}
	}

}
