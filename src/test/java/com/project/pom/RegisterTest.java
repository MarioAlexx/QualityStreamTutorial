package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTest  {

	private WebDriver driver;
	
	
	//Se crea un objeto de tipo RegisterPage para usar sus métodos
	RegisterPage registerPage;
	
	
	@Before
	public void setUp() throws Exception {
		registerPage =new RegisterPage(driver);
		driver =registerPage.chromeDriverConnection();
		registerPage.visit("https://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void test() throws InterruptedException {
		registerPage.registerUser(); 
		assertEquals(registerPage.registerMessage(), "Note: Your user name is Mario1.");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
