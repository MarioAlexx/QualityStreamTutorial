package SwagLabsPOM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class sauceLabsBikeLight_Test {

	sauceLabsBikeLight_Page sauceLabsBikeLight;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = loginTest.driver;
		sauceLabsBikeLight = new sauceLabsBikeLight_Page(driver);
		// driver=sauceLabsBikeLight.chromeDriverConnection();
		// sauceLabsBikeLight.visitUrl("https://www.saucedemo.com/");
	}

	@Test
	public void test() {
	//	sauceLabsBikeLight.addToCarSauceLabsBikeLight_Main();
		// sauceLabsBikeLight.removeSauceLabsBikeLight_Main();
	}

	@After
	public void tearDown() throws Exception {
	}
}
