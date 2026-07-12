package framework.steps.DemoSauce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import framework.constantes.SauceDemoConstants;
import framework.flows.FlowsLoginSauceDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSauceLoginSteps {

	private FlowsLoginSauceDemo flowsLoginSauceDemo;
	
	public DemoSauceLoginSteps() {
		flowsLoginSauceDemo = new FlowsLoginSauceDemo();
	}
	
	
	@Given("que o usuário esteja na página de login do DemoSauce")
	public void que_o_usuário_esteja_na_página_de_login_do_demo_sauce() {
	    flowsLoginSauceDemo.acessarSite();
	}

	@When("ele insere o usuario {string} e a senha {string}")
	public void ele_insere_o_usuario_e_a_senha(String usuario, String senha) {
	    flowsLoginSauceDemo.efetuarLogin(usuario, senha);
	}

	@Then("a seguinte {string} deve ser exibida")
	public void a_seguinte_deve_ser_exibida(String mensagem) {
	    // Write code here that turns the phrase above into concrete actions
	    String texto = selecionarMensagemErro(mensagem).trim();
	    assertEquals(texto, flowsLoginSauceDemo.mensagemErro());
	}

	@Then("o login é realizado com sucesso")
	public void o_login_é_realizado_com_sucesso() {
	    assertTrue(flowsLoginSauceDemo.loginRealizadoComSucesso());
	}
	
	private String selecionarMensagemErro(String tipoErro) {
		if (tipoErro.equals("bloqueado")) {
			return SauceDemoConstants.USUARIOBLOQUEADO;
		}else {
			return SauceDemoConstants.USUARIOSENHAINVALIDOS;
		}
	}
	
}
