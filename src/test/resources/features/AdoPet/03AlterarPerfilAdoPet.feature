Feature: Alterar perfil do adotante

Background: Usuário logado
	Given adotado já esteka logado na AdoPet
	
Scenario: 01 - Alterar perfil com dados vazios;
	When quando alterações são feitas com campos vazios
	Then não é possível finalizar o cadastro
	
Scenario: 01 - Alterar perfil com dados vazios;
	When quando alterações são com todos campos preenchidos
	Then perfil é atualizado com sucesso