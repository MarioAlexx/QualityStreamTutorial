package com.webElements.packg;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class dropdownListTest {
	private WebDriver driver;
	dropdownListPage dropListPage;
	
	@Before
	public void setUp() throws Exception {
		dropListPage = new dropdownListPage(driver);
		driver = dropListPage.chromeDriverConnection();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testDropdownListClassic() {
		dropListPage.visit("https://demo.guru99.com/test/newtours/index.php");
		dropListPage.signOn();
		assertEquals(dropListPage.selectDropdwonList_Passengers(), "4");
		assertEquals(dropListPage.selectDropdownList_DepartinFrom(), "Paris");
	}

}
