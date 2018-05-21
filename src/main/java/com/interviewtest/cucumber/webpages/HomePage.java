package com.interviewtest.cucumber.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	Product product;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.product = new Product();
		PageFactory.initElements(driver, this);
	}

	static Logger logger = Logger.getLogger(HomePage.class);

	// header of the home page
	@FindBy(xpath = "//span[@class='nav-logo-base nav-sprite']")
	private WebElement helement;

	// Search Box
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchElement;

	// Search go button
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchGo;

	// first Element
	@FindBy(className = "s-access-title")
	private WebElement firstElementTitle;

	@FindBy(id = "productTitle")
	private WebElement selproduct;

	@FindBy(id = "add-to-cart-button")
	private WebElement addCart;

	@FindBy(id = "huc-v2-order-row-confirm-text")
	private WebElement confirm;

	@FindBy(id = "nav-cart")
	private WebElement cartList;

	@FindBy(className = "a-list-item")
	private WebElement shopCartList;

	public String selectFirstPhone(String phoneName) {
		String productName = null;
		if (helement.isEnabled()) {
			searchElement.sendKeys(phoneName);
			searchGo.click();
			productName = firstElementTitle.getText();
			firstElementTitle.click();
			logger.debug("First phone in the search list selected");
		}
		return productName;
	}

	public void validateProductdetails(String productName) {
		assert (selproduct.getText().equals(productName));
		logger.debug("Phone selected is same as in First phone from the search list selected");
	}

	public void addProductToCart(String productName) {
		addCart.click();
		assert (confirm.getText().equals("Added to Cart"));
		logger.debug("Phone successfully added to the basket");

		// Navigate to 'Cart' page
		cartList.click();

		// Verify phone is present on Shopping Cart list
		List<WebElement> elements = driver.findElements(By.className("a-list-item"));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(productName)) {
				assert (shopCartList.getText().equals(productName));
				break;
			}
		}

		logger.debug("Phone in cart is same as in First phone from the search list selected");

	}
}
