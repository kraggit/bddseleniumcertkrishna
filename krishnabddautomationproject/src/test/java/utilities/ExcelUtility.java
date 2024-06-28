package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] readFromExcelFile(String filePath,String sheetName) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(filePath);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		//System.out.println("Row count:="+rowCount);
		//System.out.println("Column count:="+columnCount);
		Object[][] testData=new Object[rowCount][columnCount];
		//		XSSFRow row=sheet.getRow(0);
		//		XSSFCell cell=row.getCell(1);
		//		String firstCellValue=cell.getStringCellValue();
		//		System.out.println(firstCellValue);
		//		
		//		System.out.println("Rows:="+rowCount);
		//		int columnCount=row.getLastCellNum();
		//		System.out.println("Column count:="+columnCount);
		//		System.out.println("________________________________");
		for(int i=1;i<=rowCount;i++) {
			XSSFRow myRow=sheet.getRow(i);
			int myColumnCount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<myColumnCount;j++) {
				String value=myRow.getCell(j).getStringCellValue();
				testData[i-1][j]=value;
				//System.out.println(value);
			}
		}


		workbook.close();
		return testData;
	}

	public static void main(String[] args) throws IOException {
//		File file=new File("testdata/mytestdata.xlsx");
//		if(file.exists()) {
//			
//		}
		Object[][] testData=readFromExcelFile("testdata/mytestdata.xlsx", "LoginData");
		for(int i=0;i<testData.length;i++) {
			for(int j=0;j<testData[i].length;j++) {
				System.out.println(testData[i][j]);
			}
		}
	}

}
