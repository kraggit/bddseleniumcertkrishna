package step.definition;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeLoginPage;
import utilities.BrowserUtil;
import utilities.WebActions;
import pages.DemoBlazeProductPage;

public class LoginSteps {
	RemoteWebDriver driver;

	@Given("User opens the browser")
	public void user_opens_the_browser() {
		driver=BrowserUtil.getDriver();
	}

	@When("User navigated to the Login page")
	public void user_navigated_to_the_login_page() {
		WebActions.openUrl(driver, "https://www.demoblaze.com/index.html");
		DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		boolean flag=homePage.isLoginLinkLinkDisplayed();
		Assert.assertTrue(flag, "Verify Login link is displayed");
	}

	@When("User enters user name as {string} and password as {string}")
	public void user_enters_user_name_as_and_password_as(String username, String password) {
		DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		homePage.clickOnLoginLink();
		DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		loginPage.clickLoginButton();
	}

	@Then("the home page is displayed")
	public void the_home_page_is_displayed() {
		DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		//boolean flag=homePage.isLogoutLinkDisplayed();
		//Assert.assertTrue(flag, "Verify logout link displayed in the home page");
		boolean flag1=homePage.isWelcomeMessageDisplayed();
		Assert.assertTrue(flag1, "Verify welcome message displayed in the home page");
	}

	@Then("error message is displayed")
	public void the_home_page_with_error() {
		DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		boolean flag=loginPage.isAlertPresent();
		Assert.assertTrue(flag, "Verify Alert with error message");
	}
	
	@And("user clicks on product1 link")
	public void clicks_on_product1_link() {
		DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		homePage.clickOnProduct1();
	}
	
	@And("product page is displayed")
	public void product_page_is_displayed() {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		boolean flag=productPage.isproductPageDisplayed();
		Assert.assertTrue(flag, "Verify logout link displayed in the home page");
	}
	
	@And("user clicks on Add to cart button")
	public void user_clicks_on_Add_to_cart_button() throws InterruptedException {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.clickAddToCartButton();
	}
	
	@And("user clicks on Cart link")
	public void user_clicks_on_Cart_link() {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.clickCartLink();
	}
	
	@And("Products page is displayed with added product")
	public void Products_page_is_displayed_with_added_product() {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.isProductsCartPageDisplayed();
	}
	
	@And("user clicks on Place order button")
	public void user_clicks_on_Place_order_button() {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.clickPlaceOrderbutton();
	}

	@And("Place Order modal window is displayed")
	public void Place_Order_modal_window_is_displayed() {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.isPlaceOrderModalDisplayed();
	}
	
	@And("user purchases with details entered")
	public void user_purchases_with_details_entered() throws InterruptedException {
		DemoBlazeProductPage productPage=new DemoBlazeProductPage(driver);
		productPage.purchase("Krishna", "US", "San Francisco", "9877665544332144", "05","2025");
		productPage.isConfirmationTickDisplayed();
		productPage.confirmationOK();
	}
	
	
	@And("close the browser")
	public void closeBrowser() {
		driver.quit();
	}


}
