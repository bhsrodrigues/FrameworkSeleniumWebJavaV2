package framework.driverfactory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	//private static WebDriver driver;
	
	private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
	
	public static void iniciarDriver() {
		if (driverThread.get() == null) {
			driverThread.set(DriverFactory.criarDriver());
		}
		
	}
	
	public static boolean driverAtivo() {
		return driverThread.get() != null;
	}
	
	public static WebDriver getDriver() {
		try {
			/*if (driver == null) {
				iniciarDriver();
				driver = driverThread.get();
			}*/
			
			if (driverThread.get() == null) {
				iniciarDriver();
				//driver = driverThread.get();
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace());
		}
		return driverThread.get();
	}
	
	public static void finalizarDrive() {
		WebDriver driver = driverThread.get();
		if (driver != null) {
			try {
				driver.quit();
				//driver.close();
			}catch(Exception ex) {
				System.out.println(ex.fillInStackTrace());;
			}
			finally{
				driverThread.remove();
			}
		}
	}
	
}
