Feature: Ordenação de produtos

Background: Página de Login
	Given que o usuário tenha esteja logado com o usuario "standard_user" e a senha "secret_sauce" no DemoSauce
	
Scenario: 01 - Pedido de um único produto
	When eu seleciono um produto
	And finalizo a compra
	Then o pedido é realizado com sucesso
	
Scenario: 02 - Pedido de todos os produtos
	When eu seleciono todos os produtos
	And finalizo a compra
	Then o pedido é realizado com sucesso
	
Scenario: 03 - Fechar pedido após remover produto do carrinho
	When eu seleciono um produto
	And retiro o produto na tela de carrinho
	And tento finalizar a compra
	Then não é possível finalizar o pedido