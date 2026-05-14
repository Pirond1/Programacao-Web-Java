package com.gustavo.receitas.model.dto;

public class ReceitaDTO {

	private Long id;
	private String titulo;

	public ReceitaDTO(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
