Feature: Login

Background: Acessar página de login
	Given que esteja na página de login

Scenario: 01 Não informar nenhum dado
	When clico no botão login sem preencher dados
	Then é exibida mensagem de campos não preenchidos

Scenario: 02 Informo usuário não cadastrado
	When informo dados de usuário não cadastrado
	Then é exibida mensagem de usuário não encontrado
	
Scenario: 03 -Informo senha inválida
	When informo usuário válido e senha inválida
	Then é exibida mensagem de senha inválida
	
Scenario: 04 -Informo senha válida
	When informo usuário válido e senha válidas
	Then login é realizado com sucesso
	