package com.proyect.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SingInTest {

	private WebDriver driver;
	SingInPage singInPage;

	@Before
	public void setUp() throws Exception {
		singInPage = new SingInPage(driver);
		driver = singInPage.chromeDriverConnection();
		singInPage.visit("https://demo.guru99.com/test/newtours/index.php");
		
	}

	@Test
	public void test() throws InterruptedException {
		singInPage.singIn();
		Thread.sleep(2000);
		assertTrue(singInPage.isHomePageDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
