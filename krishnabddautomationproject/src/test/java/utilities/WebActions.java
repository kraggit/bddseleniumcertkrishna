package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class WebActions {
	
	public static void openUrl(RemoteWebDriver driver,String Url) {
		//Logger log=LoggerUtil.getLogger("BrowserUitl.getDriver()");
		//log.debug("Start - You are in the method WebActions.openUrl()");
		driver.navigate().to(Url);
		Reporter.log("Launching the browser using the URL:="+Url,true);
		//log.debug("End - You are in the method WebActions.openUrl()");
	}
	
	public static void setText(RemoteWebDriver driver,By locator,String data) {
		driver.findElement(locator).sendKeys(data);
		Reporter.log("Setting the text of the element:="+locator.toString()+" with data:="+data,true);
	}
	
	public static void click(RemoteWebDriver driver,By locator) {
		driver.findElement(locator).click();
		Reporter.log("Clicking on the element with locator:="+locator.toString(),true);
	}
	
	public static String getTitle(RemoteWebDriver driver) {
		String title=driver.getTitle();
		Reporter.log("Browser's title:="+title);
		return driver.getTitle();
	}
	
	public static void closeBrowser(RemoteWebDriver driver) {
		driver.quit();
		Reporter.log("Closed the browser");
	}

}
