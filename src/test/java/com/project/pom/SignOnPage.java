package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignOnPage extends Base {

	public SignOnPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// --------PAGE SIGN-ON--------
		By locatorSignOn = By.linkText("SIGN-ON");
		By locatorImgSignOn = By.xpath("//img[@src='images/mast_signon.gif']");
		By locatorUserNameSignOn = By.name("userName");
		By locatorPasswordSignOn = By.name("password");
		By locatorSubmitSignOn = By.name("submit");
		By locatorRegisterMessage = By.tagName("font");

		public void signOn() {
			click(locatorSignOn);
			if (isDisplayed(locatorImgSignOn)) {
				type("Mario1", locatorUserNameSignOn);
				type("123445", locatorPasswordSignOn);
				click(locatorSubmitSignOn);	
			}else {
				System.out.println("Lo sentimos, no se encuentra");
			}
		}
		
		
		public String loginExitWithFond() {
			List<WebElement> font = findElements(locatorRegisterMessage);
			return  getText(font.get(3));
			
		}
		public boolean LoginExit() {
			return isDisplayed(locatorRegisterMessage);
		}
		
}
