package framework.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProdutosDemoSaucePage extends BasePage{

    private By botaoAdicionarAoCarrinho = By.cssSelector(".inventory_list > .inventory_item > .inventory_item_description button");
    private By botaoAdicionarBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By botaoAdicionarBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By botaoAdicionarBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By botaoAdicionarFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By botaoAdicionarOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private By botaoAdicionarTShirtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By botaoRemoverDoCarrinhoTelaProdutos = By.cssSelector(".inventory_list > .inventory_item > .inventory_item_description button");
    private By botaoRemoverBackpack = By.id("remove-sauce-labs-backpack");
    private By botaoRemoverBikeLight = By.id("remove-sauce-labs-bike-light");
    private By botaoRemoverBoltTShirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By botaoRemoverFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");
    private By botaoRemoverOnesie = By.id("remove-sauce-labs-onesie");
    private By botaoRemoverTShirtRed = By.id("remove-test.allthethings()-t-shirt-(red)");
    private By botaoCarrinho = By.cssSelector("#shopping_cart_container > .shopping_cart_link");
    private By botaoCheckout = By.id("checkout");
    private List<By> listaBotoesAdicionarAoCarrinho = List.of(botaoAdicionarBackpack,botaoAdicionarBikeLight,botaoAdicionarBoltTShirt,
			botaoAdicionarFleeceJacket,botaoAdicionarOnesie,botaoAdicionarTShirtRed);
    private List<By> listaBotoesRemoverDoCarrinho = List.of(botaoRemoverBackpack,botaoRemoverBikeLight,botaoRemoverBoltTShirt,
			botaoRemoverFleeceJacket,botaoRemoverOnesie,botaoRemoverTShirtRed);
    
    public ProdutosDemoSaucePage(){
    	super();
    }
    
    public void adicionarProdutoAoCarrinho() {
    	//By produtoAdicionado = selecionarBotaoAInteragir(listaBotoesAdicionarAoCarrinho);
    	clicar(selecionarBotaoAInteragir(listaBotoesAdicionarAoCarrinho));
    }
    
    public void adicionarTodosProdutosAoCarrinho() {
    	clicarTodos(botaoAdicionarAoCarrinho);
    }
    
    public void removerTodosProdutosDoCarrinhoTelaProdutos() {
    	clicarTodos(botaoRemoverDoCarrinhoTelaProdutos);
    }
    
    public void removerItemAleatorioDoCarrinho() {
    	clicar(selecionarBotaoAInteragir(listaBotoesRemoverDoCarrinho));
    }
    
    private By selecionarBotaoAInteragir(List<By> listaBotoes) {
    	Random rnd = new Random();
    	return listaBotoes.get(
    			rnd.nextInt(listaBotoes.size()));
    }
    
    public void clicarEmCarrinho() {
    	clicar(botaoCarrinho);
    }
    
    public void iniciarCheckout() {
    	clicar(botaoCheckout);
    }
    
    private void clicarTodos(By by) {
    	List<WebElement> listaBotoes = esperarListaDeElementosVisiveis(by);
    	for(WebElement e: listaBotoes) {
    		clicar(e);
    	}
    }
	
}
