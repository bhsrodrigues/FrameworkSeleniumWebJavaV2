package framework.steps.DemoSauce;

import static org.junit.jupiter.api.Assertions.assertTrue;

import framework.constantes.SauceDemoConstants;
import framework.flows.saucedemo.FlowsCheckoutSauceDemo;
import framework.flows.saucedemo.FlowsLoginSauceDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSaucePedidoSteps {

	private FlowsCheckoutSauceDemo flwsCheckoutSD;
	
	public DemoSaucePedidoSteps() {
		flwsCheckoutSD = new FlowsCheckoutSauceDemo(); 
	}
	
	@Given("que o usuário esteja logado com o usuario {string} e a senha {string} no DemoSauce")
	public void que_o_usuário_esteja_logado_com_o_usuario_e_a_senha_no_demo_sauce(String usuario, String senha) {
		FlowsLoginSauceDemo flwLogin = new FlowsLoginSauceDemo();
		flwLogin.acessarSite();
		flwLogin.efetuarLogin(usuario, senha);
	}

	@When("eu seleciono um produto")
	public void eu_seleciono_um_produto() {
		flwsCheckoutSD.adicionarUmProdutoAoCarrinho();
	}

	@When("finalizo a compra")
	public void finalizo_a_compra() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(flwsCheckoutSD.avancarComFluxoDeCheckout());
	}

	@Then("o pedido é realizado com sucesso")
	public void o_pedido_é_realizado_com_sucesso() {
		assertTrue(flwsCheckoutSD.pedidoFinalizado(SauceDemoConstants.MENSAGEMCOMPRASUCESSO));
	}

	@When("eu seleciono todos os produtos")
	public void eu_seleciono_todos_os_produtos() {
	    // Write code here that turns the phrase above into concrete actions
		flwsCheckoutSD.adicionarTodosProdutosAoCarrinho();
	}

	@When("retiro um produto na tela de carrinho")
	public void retiro_o_produto_na_tela_de_carrinho() {
	    // Write code here that turns the phrase above into concrete actions
	    flwsCheckoutSD.retirarUmProdutoDoCarrinho();
	}

	@When("retiro todos os produtos na tela inicial")
	public void retiro_todos_os_produtos_na_tela_inicial() {
		flwsCheckoutSD.removerTodosProdutosDoCarrinho();
	}

}