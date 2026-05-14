package com.gustavo.receitas.model.dto;

import java.util.List;

public class ChefReceitaDTO {

	private Long id;
	private String nome;
	private String especialidade;
	private List<ReceitaDTO> receitas;

	public ChefReceitaDTO(Long id, String nome, String especialidade, List<ReceitaDTO> receitas) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.receitas = receitas;
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

	public List<ReceitaDTO> getReceitas() {
		return receitas;
	}

}
