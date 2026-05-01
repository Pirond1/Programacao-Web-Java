package com.gustavo.api.model.dto;

import com.gustavo.api.model.entity.Professor;

public class CursoProfessorDTO {
	
	private Long id;
	private String titulo;
	private ProfessorDTO professor;
	
	public CursoProfessorDTO(Long id, String titulo, ProfessorDTO professor) {
		this.id = id;
		this.titulo = titulo;
		this.professor = professor;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public ProfessorDTO getProfessor() {
		return professor;
	}
}
