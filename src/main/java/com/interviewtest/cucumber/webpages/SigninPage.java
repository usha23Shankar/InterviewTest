package com.interviewtest.cucumber.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		// Page decoration [initialize elements of this page
		// with driver]
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a/span[contains(text(),'Hello. Sign in')]")
	private WebElement signinButton;

	public void signin() {
		signinButton.click();
	}
}
