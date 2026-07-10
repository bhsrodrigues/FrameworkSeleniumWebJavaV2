package framework.steps.DemoSauce;

import static org.junit.jupiter.api.Assertions.assertTrue;

import framework.flows.FlowsFiltrosSauceDemo;
import framework.flows.FlowsLoginSauceDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSauceFiltrosSteps {
	
	private FlowsFiltrosSauceDemo flwFiltrosSD;
	
	public DemoSauceFiltrosSteps() {
		flwFiltrosSD = new FlowsFiltrosSauceDemo();
	}
	
	@Given("que o usuário tenha esteja logado com o usuario {string} e a senha {string} no DemoSauce")
	public void que_o_usuário_tenha_esteja_logado_com_o_usuario_e_a_senha_no_demo_sauce(String usuario, String senha) {
	    // Write code here that turns the phrase above into concrete actions
		FlowsLoginSauceDemo flwLogin = new FlowsLoginSauceDemo();
		flwLogin.acessarSite();
		flwLogin.efetuarLogin(usuario, senha);
		
	    
	}

	@When("selecionado o filtro por nome descendente")
	public void selecionado_o_filtro_por_nome_descendente() {
	    // Write code here that turns the phrase above into concrete actions
	    flwFiltrosSD.filtrarNomeAscendente();
	}

	@When("seleciono o filtro por nome ascendente")
	public void seleciono_o_filtro_por_nome_ascendente() {
	    // Write code here that turns the phrase above into concrete actions
	    flwFiltrosSD.filtrarNomeDescendente();
	}

	@When("seleciono o filtro por valor crescente")
	public void seleciono_o_filtro_por_valor_crescente() {
	    // Write code here that turns the phrase above into concrete actions
		flwFiltrosSD.filtrarValoresAscendente();
	}

	@When("seleciono o filtro por valor descrescente")
	public void seleciono_o_filtro_por_valor_descrescente() {
	    // Write code here that turns the phrase above into concrete actions
		flwFiltrosSD.filtrarValoresDescendentes();
	}

	@Then("os produtos serao reordenados corretamente")
	public void os_produtos_serao_reordenados_corretamente() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(flwFiltrosSD.filtrosRealizadosComSucesso(), flwFiltrosSD.mensagemErro());
	}

}
