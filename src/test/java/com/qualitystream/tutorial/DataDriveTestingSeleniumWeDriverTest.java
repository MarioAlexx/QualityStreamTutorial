package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriveTestingSeleniumWeDriverTest {

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchLocator = By.id("search_query_top");
	private By submitLocator = By.name("submit_search");
	private By resoultTextLocator = By.cssSelector("span.heading-counter");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void test() throws IOException {
		String filepath = "./src/test/resources/excelTest/TestSelenium.xlsx";

		// Termino que vamos a buscar (primer elementod e la primera fila
		String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);

		driver.findElement(searchLocator).clear();

		driver.findElement(searchLocator).sendKeys(searchText);
		driver.findElement(submitLocator).click();

		// La siguiente línea vamos a guardar la cantidad de los elementos encontrados
		// en la página
		String resoultTex = driver.findElement(resoultTextLocator).getText();

		// Esta línea es para ver que esta pasando por medío de la consola, mostrara lo
		// que la pagina devuelve
		System.out.println("los resultados de la pagina son:" + resoultTex);

		// Esta líea devuelve lo que esta escrito en el excel antes de escribir
		readFile.readExcel(filepath, "Hoja1");

		// La siguiente línea escribira en el excel el resultado obtenido en la fila 1 y
		// la columna 2
		writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resoultTex);

		// Es la misma que la 51, pero ahora corrobora que realmente se escribio el
		// valor en la página
		readFile.readExcel(filepath, "Hoja1");
		
	}

	@After
	public void tearDown() throws Exception {
	}

}
