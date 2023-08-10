package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	// Contact Information
	By registerLocator = By.linkText("REGISTER");
	By imgLocatorRegister = By.xpath("//img[@src='images/mast_register.gif']");
	By firstNameLocator = By.name("firstName");
	By lastNameLocator = By.name("lastName");
	By phoneLocator = By.name("phone");
	By userNameEmail = By.id("userName");

	// Mailing Information
	By address1Locator = By.name("address1");
	By cityLocator = By.name("city");
	By stateLocator = By.name("state");
	By postalCodeLocator = By.name("postalCode");

	// User Information
	By emailLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By submitLocator = By.name("submit");

	// Login
	By imgLocatorLogin = By.xpath("//img[@src='images/hdr_findflight.gif']");
	By userNameLogin = By.cssSelector("input[name='userName']");
	By passwordLogin = By.cssSelector("input[name='password']");
	By submitLogin = By.name("submit");

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");

	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLocator).click();
		Thread.sleep(2000);

		if (driver.findElement(imgLocatorRegister).isDisplayed()) {

			driver.findElement(firstNameLocator).sendKeys("Mario Alejandro");
			driver.findElement(lastNameLocator).sendKeys("Dominguez");
			driver.findElement(phoneLocator).sendKeys("7778451324");
			driver.findElement(userNameEmail).sendKeys("dominguezlinaresmarioalejandro@gmail.com");
			driver.findElement(address1Locator).sendKeys("Nuatilus 11");
			driver.findElement(cityLocator).sendKeys("Morelos");
			driver.findElement(stateLocator).sendKeys("Cuernavaca");
			driver.findElement(postalCodeLocator).sendKeys("54214");
			driver.findElement(emailLocator).sendKeys("Mario Alex");
			driver.findElement(passwordLocator).sendKeys("Marioalejandr0");
			driver.findElement(confirmPasswordLocator).sendKeys("Marioalejandr0");

			driver.findElement(submitLocator).click();
		} else {
			System.out.println("No se encuentra en el sistema.");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is Mario Alex.", fonts.get(5).getText());
	}

	@Test
	public void loginAccess() throws InterruptedException {

		if (driver.findElement(imgLocatorLogin).isDisplayed()) {
			driver.findElement(userNameLogin).sendKeys("Mario Alex");
			driver.findElement(passwordLogin).sendKeys("Marioalejandr0");

			driver.findElement(submitLogin).click();
			Thread.sleep(2000);
		} else {
			System.out.println("No encontrado");
		}
		List<WebElement> fontsAccess = driver.findElements(By.tagName("font"));
		assertEquals("Thank you for Loggin.", fontsAccess.get(3).getText());
	}

	@After
	public void tearDown() {

		driver.close();
	}
}
