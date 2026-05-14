package com.gustavo.receitas.model.dto;

import java.util.List;

public class ReceitaIngredienteDTO {

    private Long id;
    private String titulo;
    private List<IngredienteDTO> ingredientes;

    public ReceitaIngredienteDTO(Long id, String titulo, List<IngredienteDTO> ingredientes) {
        this.id = id;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
    }

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<IngredienteDTO> getIngredientes() {
		return ingredientes;
	}

}