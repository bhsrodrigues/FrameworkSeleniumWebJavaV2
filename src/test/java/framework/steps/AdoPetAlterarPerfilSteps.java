package framework.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import framework.flows.FlowsAlterarPerfilAdoPet;
import framework.flows.FlowsLoginAdoPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdoPetAlterarPerfilSteps {

	private FlowsAlterarPerfilAdoPet flowsPerfilAP;

	public AdoPetAlterarPerfilSteps() {
		flowsPerfilAP = new FlowsAlterarPerfilAdoPet();
	}
	
	@Given("adotado já esteka logado na AdoPet")
	public void adotado_já_esteka_logado_na_ado_pet() {
		new FlowsLoginAdoPet().preencherDadosLogin("asdfasdf@asdf.asdf", "ASDFasdf1234");
	}

	@When("quando alterações são feitas com campos vazios")
	public void quando_alterações_são_feitas_com_campos_vazios() {
		flowsPerfilAP.preencherDadosDoPerfil("", "", "", "");
	}

	@Then("não é possível finalizar o cadastro")
	public void não_é_possível_finalizar_o_cadastro() {
		//TO DO - Ajustar após retorno do site da AdoPet
		assertEquals("Formulário não preenchido", flowsPerfilAP.mensagemErroCadastro());
	}

	@When("quando alterações são com todos campos preenchidos")
	public void quando_alterações_são_com_todos_campos_preenchidos() {
		flowsPerfilAP.preencherDadosDoPerfil("Adotante de Teste","(11)987987987", "São Paulo", "Sobre mim");
	}

	@Then("perfil é atualizado com sucesso")
	public void perfil_é_atualizado_com_sucesso() {
		//TO DO - Ajustar após retorno do site da AdoPet
		assertEquals("Atualização feita com sucesso", flowsPerfilAP.mensagemCadastroSucesso());
	}
}
