package framework.flows;

import framework.pages.AdoPet.AdocaoAdoPetPage;

public class FlowsAdocaoAdoPet {

	private AdocaoAdoPetPage adocaoAPPage;

	public FlowsAdocaoAdoPet() {
		adocaoAPPage = new AdocaoAdoPetPage();
	}
	
	public void acessarMenuMensagem() {
		adocaoAPPage.acessarMensagens();
	}
	
	private void clicarBotaoEnviarMensagem() {
		adocaoAPPage.clicarEnvio();
	}
	
	public void enviarFormularioVazio() {
		acessarMenuMensagem();
		clicarBotaoEnviarMensagem();
	}
	
	public String mensagemErroNoEnvioDoFormulario() {
		return adocaoAPPage.mensagemErro().toLowerCase();
	}

	
	public void preencherFormularioAdocao(String nome, String telefone, String nomePet, String mensagem) {
		adocaoAPPage.preencherFormulario(nome, telefone, nomePet, mensagem);
		clicarBotaoEnviarMensagem();
	}

	public String listaMensagensEnviadas() {
		return adocaoAPPage.mensagensEnviadas();
	}
}
