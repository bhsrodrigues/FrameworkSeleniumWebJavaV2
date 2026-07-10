package framework.hooks;

import framework.driverfactory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before(order = 0)
	public void antesDoCenario(Scenario scenario) throws Exception{
		
		if (!DriverManager.driverAtivo()) {
				DriverManager.iniciarDriver();
		}
	}
	
	@After(order = 0)
	public void depoisDoCenario(Scenario scenario) {
		
		if (DriverManager.driverAtivo()) {
			DriverManager.finalizarDrive();
		}
	}
	
	
	@AfterAll()
	public void depoisDeTudo() {
		if (DriverManager.driverAtivo()) {
			DriverManager.finalizarDrive();
		}
	}
}
