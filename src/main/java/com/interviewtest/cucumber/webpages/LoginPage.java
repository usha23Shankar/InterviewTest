package com.interviewtest.cucumber.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	static Logger logger = Logger.getLogger(LoginPage.class);

	@FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	private WebElement signinText;

	// Identify elements using @FindBy
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signingInButton;

	@FindBy(xpath = "//div[@class='a-alert-content']")
	private WebElement alert;
	// Actions and verification methods
	// Accepts data required to perform action/verification

	public void emailInput(String email) {
		logger.debug("Entering the Email SignIn page ");
		emailTextbox.sendKeys(email);
		continueButton.click();

	}

	public void pwdInput(String pwd) {
		logger.debug("Entering the password SignIn page ");
		passwordTextbox.sendKeys(pwd);
		signingInButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='nav-logo-base nav-sprite']")));
		logger.debug("Home page of Amazon is launched");

	}

	public void pwdInvalid(String pwd) {
		logger.debug("Entering the password SignIn page ");
		passwordTextbox.sendKeys(pwd);
		signingInButton.click();
		if (alert.isEnabled()) {
			if ((alert.getText().equalsIgnoreCase("Your password is incorrect"))) {
				logger.debug("Password entered is invalid");
			}
		}
	}

	public void login(String un, String pw) {

		String actualText = signinText.getText();
		if (actualText.equals("Sign in")) {

			emailInput(un);
			if ((alert.getText().equalsIgnoreCase("We cannot find an account with that email address"))) {

				logger.debug("Email entered is invalid");
			} else {
				pwdInput(pw);
			}
		}
	}

	public void loginInvalid(String un, String pw) {

		String actualText = signinText.getText();
		if (actualText.equals("Sign in")) {

			emailInput(un);
			if ((alert.getText().equalsIgnoreCase("We cannot find an account with that email address"))) {
				logger.debug("Email entered is invalid");
			} else {
				pwdInvalid(pw);
			}
		}
	}
}
