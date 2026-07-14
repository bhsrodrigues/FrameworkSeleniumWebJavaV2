package framework.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import framework.flows.FlowsLoginAdoPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdoPetLoginSteps {

	private FlowsLoginAdoPet flowsLoginAP;
	
	public AdoPetLoginSteps() {
		flowsLoginAP = new FlowsLoginAdoPet();
	}
	
	@Given("que esteja na página de login")
	public void que_esteja_na_página_de_login() {
	    flowsLoginAP.clicarLinkLogin();
	}

	@When("clico no botão login sem preencher dados")
	public void clico_no_botão_login_sem_preencher_dados() {
	    // Write code here that turns the phrase above into concrete actions
	    flowsLoginAP.clicarBotaoLogin();
	}

	@Then("é exibida mensagem de campos não preenchidos")
	public void é_exibida_mensagem_de_campos_não_preenchidos() {
		//TO DO - Ajustar mensagem esperada quando AdoPet retornar;
	    assertEquals("É necessário informar um endereço de email", flowsLoginAP.mensagemErroLogin());
	}

	@When("informo dados de usuário não cadastrado")
	public void informo_dados_de_usuário_não_cadastrado() {
	    flowsLoginAP.preencherDadosLogin("usuario.nao@cadastrado.com", "N4oCadastrad0");
	}

	@Then("é exibida mensagem de usuário não encontrado")
	public void é_exibida_mensagem_de_usuário_não_encontrado() {
		//TO DO - Ajustar mensagem esperada quando AdoPet retornar;
	    assertEquals("Usuário não encontrado", flowsLoginAP.mensagemErroLogin());
	}

	@When("informo usuário válido e senha inválida")
	public void informo_usuário_válido_e_senha_inválida() {
	    flowsLoginAP.preencherDadosLogin("asdfasdf@asdf.asdf", "4321fdsaFDSA");
	}

	@Then("é exibida mensagem de senha inválida")
	public void é_exibida_mensagem_de_senha_inválida() {
		//TO DO - Ajustar mensagem esperada quando AdoPet retornar;
	    assertEquals("Dados de login incorretos", flowsLoginAP.mensagemErroLogin());
	}

	@When("informo usuário válido e senha válidas")
	public void informo_usuário_válido_e_senha_válidas() {
		flowsLoginAP.preencherDadosLogin("asdfasdf@asdf.asdf", "ASDFasdf1234");
	}
	
	@Then("login é realizado com sucesso")
	public void login_e_realizado_com_sucesso() {
		assertTrue(flowsLoginAP.loginEfetuadoComSucesso());
	}


}
