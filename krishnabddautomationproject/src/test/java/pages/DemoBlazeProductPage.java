package pages;

import java.time.Duration;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeProductPage {
	//Driver and it's initialization
	RemoteWebDriver driver;
	
	public DemoBlazeProductPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	//Element Locators
	
	By addToCartButton=By.xpath("//a[text()='Add to cart']");
	By cartLink=By.id("cartur");
	By buttonPlaceOrder=By.xpath("//button[text()='Place Order']");
	By placeOrderModal=By.id("orderModalLabel");
	
	By inputName=By.id("name");
	By inputCountry=By.id("country");
	By inputCity=By.id("city");
	By inputCreditCard=By.id("card");
	By inputMonth=By.id("month");
	By inputYear=By.id("year");
	By buttonPurchase=By.xpath("//button[text()='Purchase']");
	By confirmationTick=By.xpath("//div['sweet-alert.showSweetAlert.visible']//span[@class='sa-line sa-tip animateSuccessTip']");
	By confirmationOKButton=By.xpath("//div['sweet-alert.showSweetAlert.visible']//button[@class='confirm btn btn-lg btn-primary']");
	
	
	
	//Page functionality
	
	
	public boolean isproductPageDisplayed() {
		return driver.findElement(addToCartButton).isDisplayed();
	}
	
	public void clickAddToCartButton() throws InterruptedException {
		driver.findElement(addToCartButton).click();
		Alert myalert=driver.switchTo().alert();
		String message=myalert.getText();
		System.out.println("Alert Message:="+message);
		myalert.dismiss();//OK button
		Thread.sleep(5000);
	}
	
	public void clickCartLink() {
		driver.findElement(cartLink).click();

	}
	
	public boolean isProductsCartPageDisplayed() {
		return driver.findElement(buttonPlaceOrder).isDisplayed();
	}
	
	public void clickPlaceOrderbutton() {
		driver.findElement(buttonPlaceOrder).click();
	}
	
	public boolean isPlaceOrderModalDisplayed() {
		return driver.findElement(placeOrderModal).isDisplayed();
		
	}
	
	public boolean isConfirmationTickDisplayed() {
		return driver.findElement(confirmationTick).isDisplayed();
	}
	
		
	public void purchase(String name,String country, String city, String creditcard, String month, String year) throws InterruptedException {
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
		driver.findElement(inputName).sendKeys(name);
		driver.findElement(inputCountry).sendKeys(country);
		driver.findElement(inputCity).sendKeys(city);
		driver.findElement(inputCreditCard).sendKeys(creditcard);
		driver.findElement(inputMonth).sendKeys(month);
		driver.findElement(inputYear).sendKeys(year);					
		driver.findElement(buttonPurchase).click();
		
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//public boolean isConfirmationdisplayed() {
		//return driver.findElement(placeOrderModal).isDisplayed();
		
	//}
	
	public void confirmationOK() {
	driver.findElement(confirmationOKButton).click();
	System.out.println("Successfully purchased the product");
	
	}
		
	
	}

