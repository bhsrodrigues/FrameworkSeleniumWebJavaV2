package framework.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import framework.flows.FlowsCadastroAdoPet;
import framework.utils.GeradorDadosAdoPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdoPetCadastroAdotanteSteps {

	private FlowsCadastroAdoPet flowsCadastroAP;
	
	public AdoPetCadastroAdotanteSteps() {
		flowsCadastroAP = new FlowsCadastroAdoPet();
	}
	
	@Given("Adotante acessar página de cadastro da AdoPet")
	public void adotante_acessar_página_de_cadastro_da_ado_pet() {
	    // Write code here that turns the phrase above into concrete actions
	    flowsCadastroAP.clicarLinkCadastrar();
	}

	@When("clico no botão para finalizar cadastro")
	public void clico_no_botão_para_finalizar_cadastro() {
		flowsCadastroAP.clicarBotaoCadastrar();
	}

	@Then("cadastro não é realizado por falta de dados")
	public void cadastro_não_é_realizado_por_falta_de_dados() {
		//TO DO - Necessário ajustar até backend do AdoPet voltar a funcionar
	    assertEquals("Cadastro incompleto", flowsCadastroAP.mensagemErroCadastro());
	}

	@When("preencho todos os campos, mas informo email inválido")
	public void preencho_todos_os_campos_mas_informo_email_inválido() {
		GeradorDadosAdoPet massa = new GeradorDadosAdoPet();
		flowsCadastroAP.preencherFormularioCadastro(massa.getNome(), 
				"email@invalido@teste_com", "ASDFasdf1234", "ASDFasdf1234");
	}

	@Then("cadastro não é realizado por email inválido")
	public void cadastro_não_é_realizado_por_email_inválido() {
		//TO DO - Necessário ajustar até backend do AdoPet voltar a funcionar
	    assertEquals("E-mail inválido", flowsCadastroAP.mensagemErroCadastro());
	}

	@When("preencho todos os campos, mas senha e confirmação de senha diferentes")
	public void preencho_todos_os_campos_mas_senha_e_confirmação_de_senha_diferentes() {
		GeradorDadosAdoPet massa = new GeradorDadosAdoPet();
		flowsCadastroAP.preencherFormularioCadastro(massa.getNome(), 
				massa.getEmail(), "ASDFasdf1234", "FDSAfdsa1234");
	}

	@Then("cadastro não é realizado por senhas divergentes")
	public void cadastro_não_é_realizado_por_senhas_divergentes() {
		//TO DO - Necessário ajustar até backend do AdoPet voltar a funcionar
	    assertEquals("Senha e confirmação divergentes", flowsCadastroAP.mensagemErroCadastro());
	}

	@When("preencho todos os campos com dados já cadastrados")
	public void preencho_todos_os_campos_com_dados_já_cadastrados() {
		flowsCadastroAP.preencherFormularioCadastro("Teste Cadastro", 
				"asdfasdf@asdf.asdf", "ASDFasdf1234", "ASDFasdf1234");
	}

	@Then("cadastro não é realizado por adotante já cadastrado")
	public void cadastro_não_é_realizado_por_adotante_já_cadastrado() {
		//TO DO - Necessário ajustar até backend do AdoPet voltar a funcionar
	    assertEquals("Usuário já cadastrado", flowsCadastroAP.mensagemErroCadastro());
	}

	@When("preencho todos os campos corretamente")
	public void preencho_todos_os_campos_corretamente() {
		GeradorDadosAdoPet massa = new GeradorDadosAdoPet();
		flowsCadastroAP.preencherFormularioCadastro(massa.getNome(), 
				massa.getEmail(), "ASDFasdf1234", "ASDFasdf1234");
	}

	@Then("cadastro é realizado com sucesso")
	public void cadastro_é_realizado_com_sucesso() {
		assertEquals("Cadastro com sucesso",flowsCadastroAP.cadastroComSucesso());
	}

}
