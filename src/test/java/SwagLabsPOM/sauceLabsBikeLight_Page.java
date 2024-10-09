package SwagLabsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sauceLabsBikeLight_Page extends basePOM {

	public sauceLabsBikeLight_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By locatorSauceLabsBikeLight = By.id("item_0_title_link");
	By locatorAddToCarSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	By locatorRemoveSauceLabsBikeLight = By.id("remove-sauce-labs-bike-light");
	
	//Comprar "Checkout: Your Information"
	By locatorButtonCar = By.className("shopping_cart_link");
	By locatorButtonCheckout = By.id("checkout");
	By locatorFirstName = By.id("first-name");
	By locatorLastName = By.id("last-name");
	By locatorCodePostal = By.id("postal-code");
	By locatorButtonContinue = By.id("continue");
	By locatorButtonCancel = By.id("cancel");
	
	
	
	
	public void addToCarSauceLabsBikeLight_Main() {
		if (isDisplayed(locatorSauceLabsBikeLight)) {
			click(locatorAddToCarSauceLabsBikeLight);
		}else {
			System.out.println("Lo sentimos texto no encontrado");
		}
	}
	
	public void removeSauceLabsBikeLight_Main() {
		if (isDisplayed(locatorRemoveSauceLabsBikeLight)) {
			click(locatorRemoveSauceLabsBikeLight);
		}else {
			System.out.println("ERROR GG");
		}
	}
	
	
}
