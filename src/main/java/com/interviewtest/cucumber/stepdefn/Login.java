package com.interviewtest.cucumber.stepdefn;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.interviewtest.cucumber.webpages.HomePage;
import com.interviewtest.cucumber.webpages.LoginPage;
import com.interviewtest.cucumber.webpages.Product;
import com.interviewtest.cucumber.webpages.SigninPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	static Logger logger = Logger.getLogger(Login.class);
	WebDriver driver;
	Product p;
	Base base = new Base();

	public Login() {
		p = new Product();
	}

	@Given("^User is at the \"([^\"]*)\" of the application$")
	public void user_is_at_the_of_the_application(String url) throws Throwable {
		url = "http://www.amazon.com";
		driver = base.getWebDriver(url);
	}

	@When("^User login with the following \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_login_with_the_following_and(String usr, String pwd) throws Throwable {
		SigninPage sp = new SigninPage(driver);
		sp.signin();

	}

	@Then("^User should be able to login with correct\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_login_with_correct_username_and_password(String usr, String pwd)
			throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.login(usr, pwd);
	}

	@Then("^User should not be able to login with invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_not_be_able_to_login_with_invalid_username_and_password(String usr, String pwd)
			throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.loginInvalid(usr, pwd);
	}

	@Then("^Search for \"([^\"]*)\" and Select the first phone$")
	public void search_for_and_Add_the_product_to_the_cart(String phone) throws Throwable {
		HomePage hp = new HomePage(driver);
		phone = "iphone x 64 gb";
		p.setProduct(hp.selectFirstPhone(phone));
	}

	@Then("^validate product details in the product page$")
	public void validate_product_details_in_the_product_page() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.validateProductdetails(p.getProduct());
	}

	@Then("^validate product details in the basket page$")
	public void validate_product_details_in_the_basket_page() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.addProductToCart(p.getProduct());
	}

		
	@After
    public void afterScenario(){
        driver.quit();
    }
}
