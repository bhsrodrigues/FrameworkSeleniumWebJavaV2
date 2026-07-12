package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class PerfilAdoPetPage extends BasePage{
	
	private By btnIconePerfil = By.cssSelector(".header button > .header__user");
	private By btnVerPerfil = By.cssSelector(".menu__content > a.button");
	private By txtNome = By.id("#nome");
	private By txtTelefone = By.id("#telefone");
	private By txtCidade = By.id("#cidade");
	private By txtSobre = By.id("#sobre");
	private By btnSalvar = By.xpath("//*[@data-test='submit-button']");
	
	
	public PerfilAdoPetPage() {
		super();
	}

}
