package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class LoginAdoPetPage extends BasePage{
	
	private By txtEmail = By.xpath("//*[@data-test='input-loginEmail']");
	private By txtSenha = By.xpath("//*[@data-test='input-loginPassword']");
	private By btnLogin = By.xpath("//*[@data-test='submit-button']");
	private By mensagemErro = By.className("error");
	
	public LoginAdoPetPage(){
		super();
	}
	
	public void clicarBotaoLogin() {
		clicar(btnLogin);
	}
	
	public void login(String usuario, String senha) {
		digitar(txtEmail, usuario);
		digitar(txtSenha, senha);
		clicarBotaoLogin();
	}

	public String mensagemErro() {
		return esperarElementoVisivel(mensagemErro).getText();
	}
	
	
}
