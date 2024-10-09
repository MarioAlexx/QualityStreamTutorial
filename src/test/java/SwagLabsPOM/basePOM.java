package SwagLabsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class basePOM {
	private WebDriver driver;

	public basePOM(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	
	public void click(By locator) {
		 driver.findElement(locator).click();
		}
	
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchContextException  e) {
			return false;
			// TODO: handle exception
		}
	}
	public void type(String inputText, By locator) {
		 driver.findElement(locator).sendKeys(inputText);
	}
	public void visitUrl(String url) {
		driver.get(url);
	}
}
