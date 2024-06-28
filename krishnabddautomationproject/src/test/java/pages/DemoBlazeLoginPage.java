package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeLoginPage {
	//Driver and it's initilazation
	RemoteWebDriver driver;
		
	public DemoBlazeLoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	//Locators
	By inputUsername=By.id("loginusername");
	By inputPassword=By.id("loginpassword");
	By buttonLogin=By.xpath("//button[text()='Log in']");
	By linkLogout=By.xpath("//a[@id='logout2']");
	
	public void setUserName(String username) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
		driver.findElement(inputUsername).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(inputPassword).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(buttonLogin).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isAlertPresent() {
		boolean flag=false;
		try {
			driver.switchTo().alert().accept();
			flag=true;
			
		}
		catch(Exception e) {
			flag=false;
		}
		return flag;
	}
	
	public void login(String username,String password) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
		driver.findElement(inputUsername).sendKeys(username);
		driver.findElement(inputPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnLogoutLink() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
		driver.findElement(linkLogout).click();
	}

}
