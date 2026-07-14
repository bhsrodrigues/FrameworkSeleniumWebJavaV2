package framework.flows;

import framework.pages.AdoPet.HomeAdoPetPage;
import framework.pages.AdoPet.LoginAdoPetPage;

public class FlowsLoginAdoPet extends FlowsHomeAdoPet{

	private LoginAdoPetPage loginAPPage;
	
	public FlowsLoginAdoPet() {
		
		loginAPPage = new LoginAdoPetPage();
	}
	
	public void clicarBotaoLogin() {
		loginAPPage.clicarBotaoLogin();
	}
	
	public void preencherDadosLogin(String usuario, String senha) {
		clicarLinkLogin();
		loginAPPage.login(usuario, senha);
		clicarBotaoLogin();
	}
	
	public String mensagemErroLogin() {
		return loginAPPage.mensagemErro().trim().toLowerCase();
	}
	
	public boolean loginEfetuadoComSucesso() {
		return retornarSite().contains("/home");
	}

}
