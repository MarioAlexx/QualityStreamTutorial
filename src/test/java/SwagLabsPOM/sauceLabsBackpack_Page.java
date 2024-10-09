package SwagLabsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sauceLabsBackpack_Page extends basePOM {

	public sauceLabsBackpack_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ADD SauceLabsBackpack Main Page---------------

	By locatorTextIsDisplayedSauceLabsBackpack = By.id("item_4_title_link");
	By locatorAddToCarSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");

	// REMOVE Main Page
	By locatorRemoveSauceLabsBackpack = By.id("remove-sauce-labs-backpack");

	By locatorSauceLabsBackpackLinkText = By.id("item_4_title_link");
	By locatorSauceLabsBackpack_SecondPage = By.className("inventory_details_img_container");
	
	//Realizar compra
	
	By locatorCarrito = By.id("shopping_cart_container");
	By locatorCheckout =By.id("checkout");
	By locatorFirstName = By.id("first-name");
	By locatorLastName =By.id("last-name");
	By locatorPostalCode = By.id("postal-code");
	By locatorCntinue = By.id("continue");
	
	
	public void addToCarSauceLabsBackpack_Main() {

		
		if (isDisplayed(locatorTextIsDisplayedSauceLabsBackpack)) {
			
			click(locatorAddToCarSauceLabsBackpack);
		} else {
			System.out.println("Lo sentimos, logo no encontrado");
		}
	}

	public void removeToCarSauceLabsBackpack_Main() {

		if (isDisplayed(locatorRemoveSauceLabsBackpack)) {
			click(locatorRemoveSauceLabsBackpack);
			System.out.println("se elimino");
		} else {
			System.out.println("Lo sentimos, el botón no esta disponible");
		}
	}

	public void addToCarSauceLabsBackpack_SecondPage() {
		if (isDisplayed(locatorSauceLabsBackpackLinkText)) {
			click(locatorSauceLabsBackpackLinkText);
		} else {
			System.out.println("Lo sentimos, no se muestra el boton 'SauceLabsBackpackL'");
		}

		if (isDisplayed(locatorSauceLabsBackpack_SecondPage)) {
			click(locatorAddToCarSauceLabsBackpack);
		} else {
			System.out.println("Lo sentimos, el botón 'Add to car' no esta disponible");
		}
	}
	
	//Realizar compra de producto
	public void makePayment() {
		
	}
}
