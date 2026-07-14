package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class CadastroAdoPetPage extends BasePage{

	private By txtNome = By.xpath("//*[@data-test='input-name']");
	private By txtEmail = By.xpath("//*[@data-test='input-email']");
	private By txtSenha = By.xpath("[//*[@data-test='input-password']");
	private By txtConfirmeSenha = By.xpath("//*[@data-test='input-confirm-password']");
	private By btnCadastrar = By.xpath("//*[@data-test='submt-button']");
	private By lblMensagemErro = By.className("error");
	private By lblMensagemSucesso = By.className("success");
	
	public CadastroAdoPetPage() {
		super();
	}
	
	public void clicarCadastrar() {
		clicar(btnCadastrar);
	}
	
	public void preencherCadastro(String nome, String email, String senha, String confirmarSenha) {
		digitar(txtNome, nome);
		digitar(txtEmail, email);
		digitar(txtSenha, senha);
		digitar(txtConfirmeSenha, confirmarSenha);
	}

	public String mensagemErro() {
		return esperarElementoVisivel(lblMensagemErro).getText();
	}

	public String mensagemCadastroSucesso() {
		return esperarElementoVisivel(lblMensagemSucesso).getText();
	}

}
