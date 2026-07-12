package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class HomeAdoPetPage extends BasePage {

	private By linkFacaCadastro = By.xpath("//*[@data-test='register-button']");
	private By linkFazerLogin = By.xpath("//*[@data-test='login-button']"); 
	private By btnLogout = By.cssSelector(".menu__content > button");
	
	public HomeAdoPetPage() {
		super();
	}
	
}
