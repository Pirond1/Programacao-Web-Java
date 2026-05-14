package com.gustavo.receitas.model.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IngredienteDTO {

	private Long id;
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	@NotBlank(message = "Unidade de medida é obrigatória")
	private String unidadeMedida;
	@NotNull(message = "Quantidade é obrigatória")
	private int quantidade;
	private List<ReceitaDTO> receitas;

	public IngredienteDTO(Long id, String nome, String unidadeMedida, int quantidade, List<ReceitaDTO> receitas) {
		this.id = id;
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
		this.receitas = receitas;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public List<ReceitaDTO> getReceitas() {
		return receitas;
	}

}
