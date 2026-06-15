package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSauceDemoPage extends BasePage{
	
	private By txtUsuario = By.id("user-name");
	
	private By txtSenha = By.id("password");
	
	private By btnClicar = By.id("login-button");
	
	public LoginSauceDemoPage() {
		super();
	}
	
	public WebElement mensagemErroLogin() {
		return esperarElementoVisivel(By.cssSelector(".error-message-container.error"));
	}
	
	public LoginSauceDemoPage preencherDadosLogin(String usuario, String senha) {
		digitar(txtUsuario, usuario);
		digitar(txtSenha, senha);
		return this;
	}

	public LoginSauceDemoPage clicarBotaoLogin() {
		clicar(btnClicar);
		return this;
	}
	
	/*public void validarErroLoginInvalido(String mensagem) {
		String erroObtido = mensagemErroLogin().getText();
		assertTextosiguais(mensagem, erroObtido);
	}*/

	public void navegar(String string) {
		acessarSite(string);
		
	}

}
