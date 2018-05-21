package com.interviewtest.cucumber.stepdefn;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	final static Logger logger = Logger.getLogger(Base.class);
	WebDriver driver;

	public WebDriver getWebDriver(String url) throws Throwable {
		logger.debug("Base: Opening the Chrome browser " + url);
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\Usha\\Visa_interview\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logger.debug("Base: Browser opened successfully");
			driver.get(url);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a/span[contains(text(),'Hello. Sign in')]"));
			logger.debug("Sign In page of url is launched");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
