package com.gustavo.api.model.dto;

import java.util.List;

public class ProfessorCursoDTO {

	private Long id;
	private String nome;
	private String especialidade;
	private List<CursoDTO> cursos;
	
	public ProfessorCursoDTO(Long id, String nome, String especialidade, List<CursoDTO> cursos) {
		this.id = id;
		this.nome = nome;
		this.especialidade = especialidade;
		this.cursos = cursos;
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
	
	public List<CursoDTO> getCursos(){
		return cursos;
	}
}
