package framework.driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import framework.config.ConfigManager;

public class DriverFactory {

	
	public static WebDriver criarDriver() {
		
		ConfigManager config = ConfigManager.getInstance();
		String browser = config.getBrowser();
		boolean headless = config.getHeadless();
		WebDriver driver;
		
		switch(browser) {
			case "firefox":
				driver = iniciarFirefox(headless);
				break;
			case "edge":
				driver = iniciarEdge(headless);
				break;
			default:
				driver = iniciarChrome(headless);
				break;
		}
		
		configurarTempoCarregamentoPagina(driver, config);
			
		return driver;
	}
	
	private static void configurarTempoCarregamentoPagina(WebDriver driver, ConfigManager config) {
		driver.manage().timeouts().pageLoadTimeout(
				Duration.ofSeconds(config.getEsperaCarregamentoPagina()));
		
	}

	private static WebDriver iniciarChrome(boolean headless) {
		ChromeOptions options = new ChromeOptions();
		if (headless) {
			options.addArguments("--headless=new");
		}
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	private static WebDriver iniciarFirefox(boolean headless) {
		FirefoxOptions options = new FirefoxOptions();
		if (headless) {
			options.addArguments("-headless");
			}
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	private static WebDriver iniciarEdge(boolean headless) {
		EdgeOptions options = new EdgeOptions();
		if (headless) {
			options.addArguments("--headless");
		}
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
}
