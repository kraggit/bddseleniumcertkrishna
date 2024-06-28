package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataprovider.KrishnaTestData;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeLoginPage;
import utilities.BrowserUtil;
import utilities.ExcelUtility;

public class DemoblazeWithExcelDataProivder {

	@Test(dataProvider = "loginTestData",dataProviderClass = KrishnaTestData.class)
	public void test(String userName,String password,String IsItValidLogin) throws IOException {
		RemoteWebDriver driver=BrowserUtil.getDriver();
		driver.get("https://www.demoblaze.com/index.html");
		DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		homePage.clickOnLoginLink();
		DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		loginPage.login(userName, password);
		if(IsItValidLogin.equalsIgnoreCase("yes")) {
			boolean flag=homePage.isLogoutLinkDisplayed();
			Assert.assertEquals(flag, true,"Verify Logout link is dispalyed for successful login");
		}
		else {
			Alert alert=driver.switchTo().alert();
			String message=alert.getText();
			Assert.assertEquals(message, "Wrong password.");
			alert.dismiss();
		}
		driver.quit();
	}

}
