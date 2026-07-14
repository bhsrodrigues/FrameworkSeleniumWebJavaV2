package framework.flows;

import framework.pages.AdoPet.PerfilAdoPetPage;

public class FlowsAlterarPerfilAdoPet {
	
	private PerfilAdoPetPage perfilAPPage;

	public FlowsAlterarPerfilAdoPet() {
		perfilAPPage = new PerfilAdoPetPage();
	}
	
	public void preencherDadosDoPerfil(String nome, String telefone, String cidade, String sobreMim){
		perfilAPPage.acessarPerfil();
		perfilAPPage.preencherPerfil(nome, telefone, cidade, sobreMim);
		perfilAPPage.clicarSalvar();
	}
	
	public String mensagemErroCadastro() {
		return perfilAPPage.mensagemErro();
	}
	
	public String mensagemCadastroSucesso() {
		return perfilAPPage.sucesso();
	}

}
