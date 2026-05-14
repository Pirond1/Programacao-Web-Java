package com.gustavo.receitas.model.dto;

public class ReceitaChefDTO {

	private Long id;
	private String titulo;
	private ChefDTO chef;

	public ReceitaChefDTO(Long id, String titulo, ChefDTO chef) {
		this.id = id;
		this.titulo = titulo;
		this.chef = chef;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public ChefDTO getChef() {
		return chef;
	}

}
