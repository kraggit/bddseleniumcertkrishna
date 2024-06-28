package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DemoBlazeHomePage;
import pages.DemoBlazeLoginPage;
import utilities.BrowserUtil;
import utilities.ExcelUtility;

public class DemoblazeWithExcelReading {
	
	@Test
	public void test() throws IOException {
		RemoteWebDriver driver=BrowserUtil.getDriver();
		driver.get("https://www.demoblaze.com/index.html");
		
		
		Object[][] testData=ExcelUtility.readFromExcelFile("testdata/mytestdata.xlsx", "LoginData");
		
		for(int i=0;i<testData.length;i++) {
			driver.navigate().to("https://www.demoblaze.com/index.html");
			DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
			homePage.clickOnLoginLink();
			DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
			loginPage.login(testData[i][0].toString(), testData[i][1].toString());
			String IsItValidLogin=testData[i][2].toString();
			if(IsItValidLogin.equalsIgnoreCase("yes")) {
				boolean flag=homePage.isLogoutLinkDisplayed();
				Assert.assertEquals(flag, true,"Verify Logout link is dispalyed for successful login");
				loginPage.clickOnLogoutLink();
				//System.out.println("Verify Logout link is clicked for successful login");
			}
			else {
				Alert alert=driver.switchTo().alert();
				String message=alert.getText();
				Assert.assertEquals(message, "Wrong password.");
				alert.dismiss();
			}
		}
		
	}

}
