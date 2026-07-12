package framework.flows;

import framework.pages.HomeSauceDemoPage;

public class FlowsFiltrosSauceDemo {
	
	private HomeSauceDemoPage homeSDPage;
	//private static final ThreadLocal<Boolean> filtrosOK = new ThreadLocal<Boolean>();
	private static final ThreadLocal<String> motivosErros = new ThreadLocal<String>();
	
	public FlowsFiltrosSauceDemo() {
		homeSDPage = new HomeSauceDemoPage();
		motivosErros.set("");
	}
	
	public void filtrarNomeAscendente() {
		homeSDPage.selecionarFiltro("Name (A to Z)");
		
		if (!homeSDPage.validarOrdenacaoNome(true)) 
			motivosErros.set("Não foi possível fazer ordenação por nomes Ascendentes.\n");
	}
	
	public void filtrarNomeDescendente() {
		homeSDPage.selecionarFiltro("Name (Z to A)");
		if (!homeSDPage.validarOrdenacaoNome(false)) 
			motivosErros.set("Não foi possível fazer ordenação por nomes descendente");
	}
	
	public void filtrarValoresAscendente() {
		homeSDPage.selecionarFiltro("Price (low to high)");
		if (!homeSDPage.validarOrdenacaoValores(true)) 
			motivosErros.set("Não foi possível fazer ordenação por valores ascendentes");
	}
	
	public void filtrarValoresDescendentes() {
		homeSDPage.selecionarFiltro("Price (high to low)");
		if (!homeSDPage.validarOrdenacaoValores(false)) 
			motivosErros.set("Não foi possível fazer ordenação por valores descendentes");
	}
	
	public boolean filtrosRealizadosComSucesso() {
		return motivosErros.get().equals("") ? true : false;
	}
	
	public String mensagemErro() {
		return motivosErros.get();
	}
	
}
