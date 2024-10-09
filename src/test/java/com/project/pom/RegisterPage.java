package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// --------PAGE REGISTER--------
		By locatorRegister = By.linkText("REGISTER");
		By locatorImgRegister = By.xpath("//img[@src='images/mast_register.gif']");
		By locatorSubmid = By.name("submit");

		
		// Contact Information
		By locatorFirstName = By.name("firstName");
		By locatorLasteName = By.name("lastName");
		By locatorPhone = By.name("phone");
		By locatorEmail = By.id("userName");

		// Mailing Information
		By locatorAddress = By.name("address1");
		By locatorCity = By.name("city");
		By locatorState = By.name("state");
		By locatorPostalCode = By.name("postalCode");

		// User Information
		By locatorUserName = By.id("email");
		By locatorPassword = By.name("password");
		By locatorConfirmPassword = By.name("confirmPassword");
		
		By registerMessage =By.tagName("font");
		
		public void registerUser() throws InterruptedException {
			click(locatorRegister);
			Thread.sleep(2000);
			if (isDisplayed(locatorImgRegister)) {
				type("Mario", locatorFirstName);
				type("Dominguez", locatorLasteName);
				type("74184", locatorPhone);
				type("Test@gmail.com", locatorEmail);
			type("Avenida 19", locatorAddress);
			type("Morelos", locatorCity);
			type("Morelos", locatorState);
			type("21458", locatorPostalCode);
			type("Mario1", locatorUserName);
			type("123445", locatorPassword);
			type("123445", locatorConfirmPassword);
			
			click(locatorSubmid);
			}else {
				System.out.println("Lo sentimos, no se encuentra IMG");
			}
		}
		
		public String registerMessage() {
			List<WebElement> font= findElements(registerMessage);
			return getText(font.get(5));
		}
}
