Feature: Ordenação de produtos

Background: Página de Login
	Given que o usuário esteja logado com o usuario "standard_user" e a senha "secret_sauce" no DemoSauce
	
Scenario: 01 - Pedido de um único produto
	When eu seleciono um produto
	And finalizo a compra
	Then o pedido é realizado com sucesso
	
Scenario: 02 - Pedido de todos os produtos
	When eu seleciono todos os produtos
	And finalizo a compra
	Then o pedido é realizado com sucesso
	
Scenario: 03 - Fechar pedido após remover um produto do carrinho
	When eu seleciono todos os produtos
	And retiro um produto na tela de carrinho
	And finalizo a compra
	Then o pedido é realizado com sucesso
	
#Talvez para análise de testes manuais, o site tem o "erro" onde é possível finalizar pedido sem itens
#Para reforçar conhecimentos de manipulações de elementos, será adicionado um teste com valor zerado
Scenario: 04 - Fechar pedido sem nenhum item
	When eu seleciono todos os produtos
	And retiro todos os produtos na tela inicial
	And finalizo a compra
	Then o pedido é realizado com sucesso
