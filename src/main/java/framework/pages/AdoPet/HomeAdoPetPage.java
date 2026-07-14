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
	
	public void acessarSite() {
		driver.navigate().to("https://adopet-frontend-cypress.vercel.app/");
	}
	
	public String getUrlSite() {
		return getURL();
	}
	
	public void clicarLogin() {
		clicar(linkFazerLogin);
	}
	
	public void clicarFazerCadastro() {
		clicar(linkFacaCadastro);
	}
	
	public void clicarLogout() {
		clicar(btnLogout);
	}
}
