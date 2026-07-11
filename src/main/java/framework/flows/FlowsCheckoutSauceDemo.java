package framework.flows;

import framework.pages.CheckoutDemoSaucePages;
import framework.pages.ProdutosDemoSaucePage;

public class FlowsCheckoutSauceDemo {

	private CheckoutDemoSaucePages checkoutDMPage;
	private ProdutosDemoSaucePage produtoDMPage;

	public FlowsCheckoutSauceDemo() {
		checkoutDMPage = new CheckoutDemoSaucePages();
		produtoDMPage = new ProdutosDemoSaucePage();
	}
	
	public void adicionarUmProdutoAoCarrinho() {
		produtoDMPage.adicionarProdutoAoCarrinho();
	}
	
	public void adicionarTodosProdutosAoCarrinho() {
		produtoDMPage.adicionarProdutoAoCarrinho();
	}
	
	public void retirarUmProdutoDoCarrinho() {
		produtoDMPage.adicionarTodosProdutosAoCarrinho();
		produtoDMPage.clicarEmCarrinho();
		produtoDMPage.removerItemAleatorioDoCarrinho();
	}
	
	public void removerTodosProdutosDoCarrinho() {
		produtoDMPage.adicionarTodosProdutosAoCarrinho();
		produtoDMPage.removerTodosProdutosDoCarrinhoTelaProdutos();
	}
	
	public boolean avancarComFluxoDeCheckout() {
		produtoDMPage.clicarEmCarrinho();
		produtoDMPage.iniciarCheckout();
		checkoutDMPage.avancarCompra("Nome Cliente", "Sobrenome", "01234567");
		return checkoutDMPage.somarTodosProdutos().compareTo(checkoutDMPage.valorTotalProduto()) == 0 ? true : false;
		
	}
	
	public boolean pedidoFinalizado(String mensagem) {
		
		return checkoutDMPage.iconePedidoFeitoExiste() && 
					checkoutDMPage.mensagemSucesso().getText().trim().equals(mensagem.toLowerCase().trim());
		
	}
}
