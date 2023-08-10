package com.qualitystream.tutorial;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {
    By videoLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");

    // Se crea un objeto "driver"
    private WebDriver driver;

    // Anotation de JUnit (@Before, @Test, @After)

    @Before
    public void setUp() {

	// Se especifica para que reconozca el chromedriver importado
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

	// Se declara el objeto "driver" de tipo "ChromeDriver"
	driver = new ChromeDriver();

	// maximiza o abre la pantalla de chrome
	driver.manage().window().maximize();

	// Se ingresa la URL
	driver.get("https://www.google.com");
    }

    @Test
    public void testGooglePage() {

	// Busca el elemento de caja de busqueda por nombre
	WebElement searchbox = driver.findElement(By.name("q"));

	// Limpia la caja de busqueda
	searchbox.clear();

	// Lo que buscar� en la caja de busqueda
	searchbox.sendKeys("quality-stream Introducci�n a la Automatizaci�n de Pruebas de Software");

	// Envia la informaci�n que se coloco en la caja de busqueda, como si diera
	// enter
	searchbox.submit();

	// Tiempo de espera Implicit wait
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Tiempo de espera Explicit wait
	// WebDriverWait ewait = new WebDriverWait(driver, 10);
	// ewait.until(ExpectedConditions.titleContains("quality-stream"));

	// Tiempo de espera Fluent wait
	Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
			.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

	WebElement video = fwait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(videoLocator);
		}
	});

	//Se confirma si el video esta en la p�gina
	assertTrue(driver.findElement(videoLocator).isDisplayed());
	
	
	// Muestra el t�tulo de la esa pagina del resultado de la busqueda
	assertEquals("quality-stream Introducci�n a la Automatizaci�n de Pruebas de Software - Buscar con Google",
		driver.getTitle());
    }

    @After
    // M�todo de cierre
    public void tearDown() {

	// Cierra navegador
	//driver.quit();
    }
}
