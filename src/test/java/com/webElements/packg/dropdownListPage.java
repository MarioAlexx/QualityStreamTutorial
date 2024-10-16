package com.webElements.packg;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class dropdownListPage extends Base {

	public dropdownListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locator de pág Mercury
	By locatorPassCount = By.name("passCount");
	By locatorFromPort = By.name("fromPort");
	By locatorFlights = By.linkText("Flights");
	
	//Locator de pág https://react-bootstrap.github.io/docs/components/dropdowns
	By locatorDropdown = By.id("dropdown-basic");
	//Se crea un cssSelector personalizado para ingresar a la opción 2 ya que es un href con diferentes opciones
	By locatorOption2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href='#/action-2']");
	
	//Locator de inicio de sesión
	By locatorSignOn = By.linkText("SIGN-ON");
	By locatorImgSignOn = By.xpath("//img[@src='images/mast_signon.gif']");
	By locatorUserNameSignOn = By.name("userName");
	By locatorPasswordSignOn = By.name("password");
	By locatorSubmitSignOn = By.name("submit");

	public void signOn() {
		click(locatorSignOn);
		if (isDisplayed(locatorImgSignOn)) {
			type("Mario1", locatorUserNameSignOn);
			type("123445", locatorPasswordSignOn);
			click(locatorSubmitSignOn);
		} else {
			System.out.println("Lo sentimos, no se encuentra");
		}
	}

	public String selectDropdwonList_Passengers() {

		if (isDisplayed(locatorFlights)) {
			click(locatorFlights);

			// Se crea el elemento WEB del DropdownList
			WebElement dropdownList = findElement(locatorPassCount);
			/*
			 * Se crea una lista en donde se van a guardar todas las opciones del elemento
			 * (El dropdownList es de donde se seleccionaron los pasajeros
			 */
			List<WebElement> option = dropdownList.findElements(By.tagName("option"));
			// Vamos a ir iterando atravez de las opciones
			for (int i = 0; i < option.size(); i++) {
				// El el siguiente IF vamos a ir comparando si el texto de la opción que estamos
				// analizando en la posición i es igual a 4
				if (getText(option.get(i)).equals("2")) {
					click(option.get(i));
				}
			}

			// Se declara una variable de tipo String y se inicializa con una adena vacía
			String selectedOption = "";
			// Vamos a iterar sobre la misma lista
			for (int i = 0; i < option.size(); i++) {
				if (option.get(i).isSelected()) {
					// Se guarda en la variable selectedOption el texto de la opción
					selectedOption = getText(option.get(i));
				}
			}
			return selectedOption;
		} else {
			// System.out.println("No se muestra");
		}
		return "";

	}

	public String selectDropdownList_DepartinFrom() {
		if (isDisplayed(locatorFlights)) {
			click(locatorFlights);

			// Vamos a crear un objeto de tipo Select
			Select selectList = new Select(findElement(locatorFromPort));
			selectList.selectByVisibleText("Paris");
			// Devuelve el texto de la opción que esta seleccionada
			return getText(selectList.getFirstSelectedOption());
		}
		return "";
	}
	
	/*Se crea un método void y no String ya que no se esta obteniendo un valor, se esta direcciónando a la dirección del elemento 
	seleccionado*/
	public void selectReadDropdownList() throws InterruptedException {
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
*/
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(locatorDropdown);

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        */




		// Create instance of Javascript executor

		JavascriptExecutor je = (JavascriptExecutor) driver;

		//Identify the WebElement which will appear after scrolling down

		WebElement element = driver.findElement(By.id("dropdown-basic"));

		// now execute query which actually will scroll until that element is not appeared on page.

		je.executeScript("arguments[0].scrollIntoView(true);",element);
          

         
    
		//click(locatorDropdown);
		Thread.sleep(90000);
		//click(locatorOption2);
	}

}
