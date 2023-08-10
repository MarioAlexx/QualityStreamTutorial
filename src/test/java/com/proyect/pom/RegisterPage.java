package com.proyect.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base {

	By registerLocator = By.linkText("REGISTER");
	By imgLocatorRegister = By.xpath("//img[@src='images/mast_register.gif']");
	By firstNameLocator = By.name("firstName");
	By lastNameLocator = By.name("lastName");
	By phoneLocator = By.name("phone");
	By userNameEmail = By.id("userName");

	//Mailing Information
	By address1Locator = By.name("address1");
	By cityLocator = By.name("city");
	By stateLocator = By.name("state");
	By postalCodeLocator = By.name("postalCode");

	//User Information
	By emailLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By submitLocator = By.name("submit");
	

	By registerMessage = By.tagName("font"); 
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
	 click(registerLocator); 
	Thread.sleep(2000);
	if (isDisplayed(imgLocatorRegister)) {
		type("Mario Alejandro", firstNameLocator);
		type("Dominguez", lastNameLocator);
		type("77774545488", phoneLocator);
		type("dominguez@gmail.com", userNameEmail);
		
		type("Napal 145", address1Locator);
		type("Morelos", cityLocator);
		type("Morelos", stateLocator);
		type("62541", postalCodeLocator);
		
		
		
		type("Mario Alex", emailLocator);
		type("", address1Locator);
		type("Marioalejandr0", passwordLocator);
		type("Marioalejandr0", confirmPasswordLocator);
		click(submitLocator);
	} else {
		System.out.println("Register pages not found");
	}
}

public String registeredMessage() {
	List<WebElement> fonts = findElements(registerMessage);
	return getText(fonts.get(5));
}

}
