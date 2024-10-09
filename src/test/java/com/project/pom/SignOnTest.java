package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignOnTest {

	SignOnPage signOnPage;
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
	signOnPage = new SignOnPage(driver);
	driver = signOnPage.chromeDriverConnection();
	signOnPage.visit("https://demo.guru99.com/test/newtours/");
	}

	@Test
	public void testLoginExitWithFond() {
		signOnPage.signOn();
		assertEquals("Thank you for Loggin.", signOnPage.loginExitWithFond());
	}
	
	@Test
	public void testLoginExit() {
		signOnPage.signOn();
		assertTrue(signOnPage.LoginExit());
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
