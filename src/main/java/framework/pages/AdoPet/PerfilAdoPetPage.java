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
	private By mensagemErro = By.className("error");
	private By mensagemSucesso = By.className("success");
	
	
	public PerfilAdoPetPage() {
		super();
	}
	
	public void acessarPerfil() {
		clicar(btnIconePerfil);
		clicar(btnVerPerfil);
	}
	
	public void clicarSalvar() {
		clicar(btnSalvar);
	}

	public void preencherPerfil(String nome, String telefone, String nomeAnimal, String sobreMim) {

		digitar(txtNome, nome);
		digitar(txtTelefone, telefone);
		digitar(txtCidade, nomeAnimal);
		digitar(txtSobre, sobreMim);
		
	}
	
	public String mensagemErro() {
		return esperarElementoVisivel(mensagemErro).getText().trim();
	}

	public String sucesso() {
		return esperarElementoVisivel(mensagemSucesso).getText().trim();
	}
}
