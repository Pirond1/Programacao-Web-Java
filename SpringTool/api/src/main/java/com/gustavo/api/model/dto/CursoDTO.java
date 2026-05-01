package com.gustavo.api.model.dto;

public class CursoDTO {

	private Long id;
	private String titulo;
	
	public CursoDTO(Long id, String titulo) {
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
