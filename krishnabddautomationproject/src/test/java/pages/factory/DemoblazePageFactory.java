package pages.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoblazePageFactory {
	
	
	public DemoblazePageFactory(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//1. Locators of the page
	//2. Operations that are supported by the page
	
	//Locators that required for the test cases needs to be defined as below
	@FindBy(id="login2")
	WebElement homePageLoginButton;
	
	@FindBy(id="loginusername")
	WebElement inputUserName;
	
	@FindBy(id="loginpassword")
	WebElement inputPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginPageLoginButton;
	
	
	@FindBy(id="logout2")
	WebElement loginPageLogoutButton;
	
	public void clickHomePageLoginButton() {
		homePageLoginButton.click();
	}
	
	public void setUserName(String userName) {
		inputUserName.sendKeys(userName);
	}

	public void setPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	
	public void login(String userName,String password) {
		this.setUserName(userName);
		this.setPassword(password);
		//Additional step over here
		this.loginPageLoginButton.click();
	}
}
