package framework.pages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutDemoSaucePages extends BasePage{

	private By txtCampoNome = By.id("first-name");
	private By txtCampoSobrenome = By.id("last-name");
	private By txtCampoZipCode = By.id("postal-code");
	private By botaoContinuar = By.id("continue");
	private By lblValorProdutoCarrinho = By.className("inventory_item_price");
	private By lblSubTotal = By.cssSelector(".summary_info > .summary_subtotal_label");
	private By botaoFinalizarCompra = By.id("finish");
	@SuppressWarnings("unused")
	private By sectionPedidoRealizado = By.id("checkout-complete-container");
	private By iconeSucesso = By.cssSelector("#checkout_complete_container > .pony_express");
	private By lblMensagemSucesso = By.cssSelector("#checkout_complete_container > .complete-header");
	
	public CheckoutDemoSaucePages() {
		super();
	}
	
	private void preencherDadosCompra(String nome, String sobrenome, String cep) {
		digitar(txtCampoNome, nome);
		digitar(txtCampoSobrenome, sobrenome);
		digitar(txtCampoZipCode, cep);
	}
	
	public void avancarCompra(String nome, String sobrenome, String cep) {
		this.preencherDadosCompra(nome, sobrenome, cep);
		clicar(botaoContinuar);
	}
	
	public BigDecimal somarTodosProdutos() {
		List<WebElement> listElem = esperarListaDeElementosVisiveis(lblValorProdutoCarrinho);
		BigDecimal valorTotal = new BigDecimal(0.00);
		
		for(WebElement elem : listElem) {
			valorTotal = valorTotal.add(converterValorParaMonetario(elem.getText(),"$"));
		}
		return valorTotal;
	}
	
	public BigDecimal valorTotalProduto() {
		return converterValorParaMonetario(
					esperarElementoVisivel(lblSubTotal).getText(),"Item total: $").setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal converterValorParaMonetario(String valor,String textoARemover) {
		
		return new BigDecimal(valor.replace(textoARemover, ""));
	}
	
	public void finalizarCompra() {
		clicar(botaoFinalizarCompra);
	}
	
	public boolean iconePedidoFeitoExiste() {
		
		return esperarElementoVisivel(iconeSucesso).isDisplayed() ? true : false;
		
	}
	
	public WebElement mensagemSucesso() {
		return esperarElementoVisivel(lblMensagemSucesso);
	}
	
}
