package framework.flows;

import framework.pages.AdoPet.CadastroAdoPetPage;

public class FlowsCadastroAdoPet extends FlowsHomeAdoPet {

	private CadastroAdoPetPage cadastroAPPage;
	
	public FlowsCadastroAdoPet() {
		cadastroAPPage = new CadastroAdoPetPage();
	}
	
	public void clicarBotaoCadastrar() {
		cadastroAPPage.clicarCadastrar();
	}
	
	public void preencherFormularioCadastro(String nome, String email, String senha, String confirmarSenha) {
		cadastroAPPage.preencherCadastro(nome, email, senha, confirmarSenha);
	}
	
	public String mensagemErroCadastro() {
		return cadastroAPPage.mensagemErro().trim().toLowerCase();
	}
	
	public String cadastroComSucesso() {
		return cadastroAPPage.mensagemCadastroSucesso().trim().toLowerCase();
	}

}
