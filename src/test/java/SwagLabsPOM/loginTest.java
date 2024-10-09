package SwagLabsPOM;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class loginTest {

	public static WebDriver driver;

	loginPage loginP;

	@Before
	public void setUp() throws Exception {
		loginP = new loginPage(driver);
		driver = loginP.chromeDriverConnection();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))
;		loginP.visitUrl("https://www.saucedemo.com/");
		
	}

	@Test
	public void test() {
		loginP.loginAccess();
		assertTrue(loginP.exitLogin());
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

}
