package com.proyect.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage extends Base {
	//XPath de Texto exitoso
	By successfulText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
	
	//Imagen de Texto encontrado para loguear
	By imgLocatorLogin = By.xpath("//img[@src='images/hdr_findflight.gif']");
	By userNameLogin = By.cssSelector("input[name='userName']");
	By passwordLogin = By.cssSelector("input[name='password']");
	By submitLogin = By.name("submit");
	
	
	public SingInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public void singIn() {
		if (isDisplayed(imgLocatorLogin)) {
			type("Mario Alex", userNameLogin);
			type("Marioalejandr0", passwordLogin);
			click(submitLogin);
		} else {
			System.out.println("No encontrado");
		}
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(successfulText);
	}
}
