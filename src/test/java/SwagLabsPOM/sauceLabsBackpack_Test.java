package SwagLabsPOM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class sauceLabsBackpack_Test {

	 sauceLabsBackpack_Page sauceLabsBackpack;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = loginTest.driver;
		sauceLabsBackpack = new sauceLabsBackpack_Page(driver);
		// driver = sauceLabsBackpack.chromeDriverConnection();
		// sauceLabsBackpack.visitUrl("https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void test() {
	
		//sauceLabsBackpack.addToCarSauceLabsBackpack_Main();
		//sauceLabsBackpack.removeToCarSauceLabsBackpack_Main();
		sauceLabsBackpack.addToCarSauceLabsBackpack_SecondPage();
	}

	@After
	public void tearDown() throws Exception {

	}
}
