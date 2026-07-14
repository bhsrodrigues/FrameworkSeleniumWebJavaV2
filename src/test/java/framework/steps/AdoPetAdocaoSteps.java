package framework.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import framework.flows.FlowsAdocaoAdoPet;
import framework.flows.FlowsLoginAdoPet;
import framework.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdoPetAdocaoSteps {

	private FlowsAdocaoAdoPet flowsAdocaoAP;
	private ScenarioContext scenarioContext;

	public AdoPetAdocaoSteps() {
		flowsAdocaoAP = new FlowsAdocaoAdoPet();
		scenarioContext = new ScenarioContext();
	}
	
	@Given("dado que adotante esteja logado")
	public void dado_que_adotante_esteja_logado() {
		new FlowsLoginAdoPet().preencherDadosLogin("asdfasdf@asdf.asdf", "ASDFasdf1234");
	}

	@When("não preencho nenhum dados")
	public void não_preencho_nenhum_dados() {
		flowsAdocaoAP.enviarFormularioVazio();
	}

	@Then("é exibido erro de mensagem sobre formulário não preenchido")
	public void é_exibido_erro_de_mensagem_sobre_formulário_não_preenchido() {
		assertEquals("Formulário não preenchido", flowsAdocaoAP.mensagemErroNoEnvioDoFormulario());
	}

	@When("preencho telefone com formato inválido")
	public void preencho_telefone_com_formato_inválido() {
		flowsAdocaoAP.preencherFormularioAdocao("Teste Adotante", "(11) 987+-987-987", "Pet", "Mensagem Teste");
	}

	@Then("é exibido erro de dados informados inválidos")
	public void é_exibido_erro_de_dados_informados_inválidos() {
		assertEquals("Formulário preenchido incorretamente", flowsAdocaoAP.mensagemErroNoEnvioDoFormulario());
	}

	@When("preencho todos os campos exceto a mensagem de adoção")
	public void preencho_todos_os_campos_exceto_a_mensagem_de_adoção() {
	    // Write code here that turns the phrase above into concrete actions
		flowsAdocaoAP.preencherFormularioAdocao("Teste Adotante", "(11) 987+-987-987", "Pet", "");
	}

	@Then("é exibido erro de mensagem não preenchida")
	public void é_exibido_erro_de_mensagem_não_preenchida() {
		assertEquals("Mensagem não preenchida", flowsAdocaoAP.mensagemErroNoEnvioDoFormulario());
	}

	@When("preencho corretamente os dados de adoção")
	public void preencho_corretamente_os_dados_de_adoção() {
		LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String mensagemEnviada = "Mensagem de teste enviada em: " + agora.format(formatador);
        scenarioContext.adicionarContexto("mensagem", mensagemEnviada);
		flowsAdocaoAP.preencherFormularioAdocao("Teste Adotante", "(11) 987+-987-987", "Pet", mensagemEnviada);
	}

	@Then("a mensagem de adoção é enviada com sucesso")
	public void a_mensagem_de_adoção_é_enviada_com_sucesso() {
		flowsAdocaoAP.acessarMenuMensagem();
		String mensagemEnviada = (String) scenarioContext.pegarContexto("mensagem");
	    assertTrue(flowsAdocaoAP.listaMensagensEnviadas().contains(mensagemEnviada));
	    
	}

}
