package SwagLabsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePOM {

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By locatorIsDisplayedForAccess = By.className("login_logo");
	By locatorUserName = By.id("user-name");
	By locatorPassword = By.id("password");
	By locatorButtonLogin = By.id("login-button");
	By locatorTextValidAccess = By.className("title");

	public void loginAccess() {
		if (isDisplayed(locatorIsDisplayedForAccess)) {
			//type("standard_user", locatorUserName);
			type("standard_user", locatorUserName);
			type("secret_sauce", locatorPassword);
			click(locatorButtonLogin);
		} else {
			System.out.println("Lo sentimos, no loggueado");
		}
	}

	public boolean exitLogin() {
		return isDisplayed(locatorTextValidAccess);
		
	}
}
