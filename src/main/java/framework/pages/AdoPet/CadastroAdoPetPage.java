package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class CadastroAdoPetPage extends BasePage{

	private By txtCampoNome = By.xpath("//*[@data-test='input-name']");
	private By txtCampoEmail = By.xpath("//*[@data-test='input-email']");
	private By txtCampoSenha = By.xpath("[//*[@data-test='input-password']");
	private By txtConfirmeSenha = By.xpath("//*[@data-test='input-confirm-password']");
	private By btnCadastrar = By.xpath("//*[@data-test='submt-button']");
	
	public CadastroAdoPetPage() {
		super();
	}

}
