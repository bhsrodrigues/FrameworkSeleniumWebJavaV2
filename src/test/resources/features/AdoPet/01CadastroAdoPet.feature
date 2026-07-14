Feature: Cadastro de adotante

Background: Acessar a tela de cadastro de adotante
	Given Adotante acessar página de cadastro da AdoPet

Scenario: 01 - Efetuar cadastro sem preencher nenhum dado
	When clico no botão para finalizar cadastro
	Then cadastro não é realizado por falta de dados

Scenario: 02 - Efetuar cadastro com email em formato inválido
	When preencho todos os campos, mas informo email inválido
	And clico no botão para finalizar cadastro
	Then cadastro não é realizado por email inválido

Scenario: 03 - Efetuar cadastro com senha e confirmação diferentes
	When preencho todos os campos, mas senha e confirmação de senha diferentes
	And clico no botão para finalizar cadastro
	Then cadastro não é realizado por senhas divergentes

Scenario: 04 - Efetuar cadastro com usuário repetido
	When preencho todos os campos com dados já cadastrados
	And clico no botão para finalizar cadastro
	Then cadastro não é realizado por adotante já cadastrado

Scenario: 05 - Efetuar cadastro com dados válidos
	When preencho todos os campos corretamente
	And clico no botão para finalizar cadastro
	Then cadastro é realizado com sucesso
