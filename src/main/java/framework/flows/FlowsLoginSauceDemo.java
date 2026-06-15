package framework.flows;

import framework.pages.LoginSauceDemoPage;
import framework.pages.HomeSauceDemoPage;

public class FlowsLoginSauceDemo {
	
	private LoginSauceDemoPage loginSDPage;
	private HomeSauceDemoPage homeSDPage;
	
	public FlowsLoginSauceDemo() {
		loginSDPage = new LoginSauceDemoPage();
		homeSDPage = new HomeSauceDemoPage();
	}
	
	public void acessarSite() {
		loginSDPage.navegar("https://www.saucedemo.com/");
	}
	
	public void efetuarLogin(String usuario, String senha) {
		loginSDPage.preencherDadosLogin(usuario,senha)
			.clicarBotaoLogin();
	}
	
	public String mensagemErro() {
		return loginSDPage.mensagemErroLogin().getText();
	}


	
	public boolean loginRealizadoComSucesso() {
		return homeSDPage.getComboFiltroExiste();
	}
		
	/*public void loginUsuarioBloqueado() {
		loginSDPage.validarErroLoginInvalido(LoginSauceDemoConstants.USUARIOBLOQUEADO);
	}
	
	public void loginUsuarioComProblema() {
		loginSDPage.validarErroLoginInvalido(LoginSauceDemoConstants.USUARIOCOMPROBLEMA);
	}
	
	public void loginUsuarioOuSenhaInvalidos() {
		loginSDPage.validarErroLoginInvalido(LoginSauceDemoConstants.USUARIOSENHAINVALIDOS);
	}*/
	
	
}
