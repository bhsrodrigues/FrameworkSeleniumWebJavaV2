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
	
	public AdocaoAdoPetPage() {
		super();
	}

}
