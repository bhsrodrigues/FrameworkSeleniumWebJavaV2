package framework.utils;

import java.util.Arrays;
import java.util.List;

public class GeradorDadosAdoPet {

	private List<String> nomes = Arrays.asList(
		"Gabriel", "Julia", "Lucas", "Mariana", "Matheus", 
        "Beatriz", "Pedro", "Ana", "Guilherme", "Larissa", 
        "Arthur", "Camila", "Gustavo", "Isabela", "Felipe", 
	    "Letícia", "Rafael", "Amanda", "Leonardo", "Bruna", 
	    "Thiago", "Manuela", "Vinícius", "Caroline", "Rodrigo", 
		"Luana", "Diego", "Gabriela", "Daniel", "Sofia"
	);

	
	private List<String> sobrenomes = Arrays.asList(
		"Silva", "Santos", "Oliveira", "Souza", "Rodrigues", 
		"Ferreira", "Alves", "Pereira", "Lima", "Gomes", 
	    "Costa", "Ribeiro", "Martins", "Carvalho", "Almeida", 
	    "Lopes", "Soares", "Fernandes", "Vieira", "Barbosa");
		
	private String nome;
	private String email;
	
	public GeradorDadosAdoPet() {
		this.nome = nomes.get((int) (Math.random() * nomes.size())) + " " + 
				sobrenomes.get((int) (Math.random() * nomes.size()));
		this.email = nome.replace(" ", "_") + "_teste" + 
				(int)(Math.random() * 9999) + "@emailteste.com.br";
	}
	
	public String getNome() {
		return this.nome.toLowerCase();
	}
	
	public String getEmail() {
		return this.email;
	}

}
