package com.qualitystream.tutorial;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_Automated {

	private WebDriver driver;

	By registerMessage =By.tagName("font");
	// --------PAGE REGISTER--------
	By locatorRegister = By.linkText("REGISTER");
	By locatorImgRegister = By.xpath("//img[@src='images/mast_register.gif']");
	By locatorSubmid = By.name("submit");

	// Contact Information
	By locatorFirstName = By.name("firstName");
	By locatorLasteName = By.name("lastName");
	By locatorPhone = By.name("phone");
	By locatorEmail = By.id("userName");

	// Mailing Information
	By locatorAddress = By.name("address1");
	By locatorCity = By.name("city");
	By locatorState = By.name("state");
	By locatorPostalCode = By.name("postalCode");

	// User Information
	By locatorUserName = By.id("email");
	By locatorPassword = By.name("password");
	By locatorConfirmPassword = By.name("confirmPassword");

	// --------PAGE SIGN-ON--------
	By locatorSignOn = By.linkText("SIGN-ON");
	By locatorUserNameSignOn = By.name("userName");
	By locatorPasswordSignOn = By.name("password");
	By locatorSubmitSignOn = By.name("submit");
	By locatorImgSignOn = By.xpath("//img[@src='images/mast_signon.gif']");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver_chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(locatorRegister).click();
		Thread.sleep(2000);
		if (driver.findElement(locatorImgRegister).isDisplayed()) {
			driver.findElement(locatorFirstName).sendKeys("Alejandro");
			driver.findElement(locatorLasteName).sendKeys("Dom");
			driver.findElement(locatorPhone).sendKeys("778845");
			driver.findElement(locatorEmail).sendKeys("domia@asdasd.com");
			driver.findElement(locatorAddress).sendKeys("address");
			driver.findElement(locatorCity).sendKeys("city");
			driver.findElement(locatorState).sendKeys("state");
			driver.findElement(locatorPostalCode).sendKeys("45124");
			driver.findElement(locatorUserName).sendKeys("alex");
			driver.findElement(locatorPassword).sendKeys("asasas");
			driver.findElement(locatorConfirmPassword).sendKeys("asasas");
			driver.findElement(locatorSubmid).click();
		} else {
			System.out.println("Lo sentimos");
		}
		List<WebElement> fonts = driver.findElements(registerMessage);
		assertEquals("Note: Your user name is alex.", fonts.get(5).getText());
	}

	@Test
	public void signOn() throws InterruptedException {
		driver.findElement(locatorSignOn).click();
		Thread.sleep(2000);
		if (driver.findElement(locatorUserNameSignOn).isDisplayed()) {
			driver.findElement(locatorUserNameSignOn).sendKeys("alex");
			driver.findElement(locatorPasswordSignOn).sendKeys("asasas");
			driver.findElement(locatorSubmitSignOn).click();
		} else {
			System.out.println("Lo sentimos");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Thank you for Loggin.", fonts.get(3).getText());
	}

	@After
	public void tearDown() throws Exception {
		// driver.close();
		//driver.quit();
	}
}
