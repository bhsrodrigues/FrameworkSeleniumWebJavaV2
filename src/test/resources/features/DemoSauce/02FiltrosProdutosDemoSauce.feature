Feature: Ordenação de produtos

Background: Página de Login
	Given que o usuário tenha esteja logado com o usuario "standard_user" e a senha "secret_sauce" no DemoSauce
	
Scenario: Validar filtros de ordenação
	When selecionado o filtro por nome descendente
	And seleciono o filtro por nome ascendente
	And seleciono o filtro por valor crescente
	And seleciono o filtro por valor descrescente
	Then os produtos serao reordenados corretamente