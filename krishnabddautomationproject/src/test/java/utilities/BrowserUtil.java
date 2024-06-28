package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtil {
	
	public static void quitDriver(RemoteWebDriver driver) {
		driver.quit();
	}
	
	public static RemoteWebDriver getDriver() {
		
		String browser=System.getProperty("browser");
		System.out.println("Browser value:="+browser);
		if(browser==null) {
			Logger logger=LoggerUtil.getLogger("BrowserUtil.getDriver()");
			logger.debug("Browser value is null. Hence launching Firefox as default browser");
			browser="chrome";
		}
		
		RemoteWebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

}
