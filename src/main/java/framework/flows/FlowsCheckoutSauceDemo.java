package framework.flows;

import java.math.BigDecimal;

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
		produtoDMPage.adicionarTodosProdutosAoCarrinho();
	}
	
	public void retirarUmProdutoDoCarrinho() {
		produtoDMPage.clicarEmCarrinho();
		produtoDMPage.removerItemAleatorioDoCarrinho();
	}
	
	public void removerTodosProdutosDoCarrinho() {
		produtoDMPage.removerTodosProdutosDoCarrinhoTelaProdutos();
	}
	
	public boolean avancarComFluxoDeCheckout() throws InterruptedException {
		produtoDMPage.clicarEmCarrinho();
		produtoDMPage.iniciarCheckout();
		checkoutDMPage.avancarCompra("Nome Cliente", "Sobrenome", "01234567");
		if (checkoutDMPage.valorTotalProduto().compareTo(new BigDecimal(0)) == 0) {
			return true;
		}else {
			return checkoutDMPage.somarTodosProdutos().compareTo(checkoutDMPage.valorTotalProduto()) == 0 ? true : false;			
		}
		
	}
	
	public boolean pedidoFinalizado(String mensagem) {
		checkoutDMPage.finalizarCompra();
		return checkoutDMPage.iconePedidoFeitoExiste() && 
					checkoutDMPage.mensagemSucesso().getText().toLowerCase().trim().equals(
							mensagem.toLowerCase().trim());
		
	}
}
