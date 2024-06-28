package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import pages.factory.*;

public class DemoblazeUsingPageFactory {
	
	@Test
	public void loginTest() throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		DemoblazePageFactory demo=new DemoblazePageFactory(driver);
		demo.clickHomePageLoginButton();
		demo.login("krishcert", "project");
		Thread.sleep(5000);
		driver.quit();
	}

}
