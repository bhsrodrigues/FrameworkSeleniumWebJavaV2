Feature: DemoSauce login

Background: Página de Login
	Given que o usuário esteja na página de login do DemoSauce
	
Scenario Outline: 01Login sem sucesso )
	When ele insere o usuario "<usuario>" e a senha "<senha>"
	Then a seguinte "<mensagem>" deve ser exibida
	Examples:
		| usuario 			| senha 		| mensagem 	|
		| locked_out_user	| secret_sauce 	| bloqueado |
		| standard_user		| senha_errada	| inválido	|


Scenario: 02Login efetuado com sucesso
	When ele insere o usuario "standard_user" e a senha "secret_sauce"
	Then o login é realizado com sucesso