package framework.flows;

import framework.pages.AdoPet.HomeAdoPetPage;

public class FlowsHomeAdoPet {

	private HomeAdoPetPage homeAPPage;
	public FlowsHomeAdoPet() {
		homeAPPage = new HomeAdoPetPage();
	}
	
	private void acessarSite() {
		homeAPPage.acessarSite();
	}
	
	public void clicarLinkCadastrar() {
		this.acessarSite();
		homeAPPage.clicarFazerCadastro();
	}
	
	public FlowsLoginAdoPet clicarLinkLogin() {
		this.acessarSite();
		homeAPPage.clicarLogin();
		return (FlowsLoginAdoPet) this;
	}

	protected String retornarSite() {
		return homeAPPage.getUrlSite();
	}
}
