package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class KrishnaTestData {
	
	@DataProvider(name = "loginTestData")
	public Object[][] getMyLoginData() {
		Object[][] testData=null;
		try {
			testData = ExcelUtility.readFromExcelFile("testdata/mytestdata2.xls", "LoginData");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testData;
	}

}
