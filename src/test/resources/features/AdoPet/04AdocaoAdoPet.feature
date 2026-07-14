Feature: Solicitação de adoção

Background: Adotante já logado
	Given dado que adotante esteja logado

Scenario: 01 - Solicitação de adoção sem informar nenhum dado
	When não preencho nenhum dados
	Then é exibido erro de mensagem sobre formulário não preenchido

Scenario: 02 - Solicitação de adoção informando dados inválidos
	When preencho telefone com formato inválido
	Then é exibido erro de dados informados inválidos

Scenario: 03 - Solicitação de adoção não informando mensagem de adoção
	When preencho todos os campos exceto a mensagem de adoção
	Then é exibido erro de mensagem não preenchida

Scenario: 04 - Solicitação de adoção enviada com sucesso
	When preencho corretamente os dados de adoção
	Then a mensagem de adoção é enviada com sucesso