package com.gustavo.receitas.model.dto;

public class ChefDTO {

	private Long id;
	private String nome;
	private String especialidade;

	public ChefDTO(Long id, String nome, String especialidade) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

}
