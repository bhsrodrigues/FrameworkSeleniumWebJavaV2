package framework.pages.AdoPet;

import org.openqa.selenium.By;

import framework.pages.BasePage;

public class AdocaoAdoPetPage extends BasePage{

	private By btnMensagem = By.cssSelector(".header div > .header__message");
	private By txtNome = By.id("#name");
	private By txtTelefone = By.id("#phone");
	private By txtNomeAnimal = By.id("#petName");
	private By txtMensagem = By.id("#msg");
	private By btnEnviar = By.xpath("//*[@data-test='submit-button']");
	private By sectionMensagensEviadas = By.cssSelector(".enviadas > ul.enviadas");
	private By mensagemErro = By.className("error");
	
	public AdocaoAdoPetPage() {
		super();
	}
	
	public void acessarMensagens() {
		clicar(btnMensagem);
	}

	public void clicarEnvio() {
		clicar(btnEnviar);
		
	}

	public String mensagemErro() {
		return esperarElementoVisivel(mensagemErro).getText().trim();
	}

	public void preencherFormulario(String nome, String telefone, String nomePet, String mensagem) {
		digitar(txtNome, nome);
		digitar(txtTelefone, telefone);
		digitar(txtNomeAnimal, nomePet);
		digitar(txtMensagem, mensagem);
	}

	public String mensagensEnviadas() {
		return esperarElementoVisivel(sectionMensagensEviadas).getText();
	}

	

}
