package com.webElements.packg;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
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



	/*@Test
	public void testDropdownListClassic() {
		dropListPage.visit("https://demo.guru99.com/test/newtours/index.php");
		dropListPage.visit("https://demo.guru99.com/test/newtours/reservation.php");
		dropListPage.signOn();
		assertEquals(dropListPage.selectDropdwonList_Passengers(), "2");
		assertEquals(dropListPage.selectDropdownList_DepartinFrom(), "Paris");
	} */
	
	@Test
	public void testReadDropdownList() throws InterruptedException {
		dropListPage.visit("https://react-bootstrap.github.io/docs/components/dropdowns/");
		dropListPage.selectReadDropdownList();
	}
	
	@After
	public void tearDown() throws Exception {
//driver.quit();
	}
}
