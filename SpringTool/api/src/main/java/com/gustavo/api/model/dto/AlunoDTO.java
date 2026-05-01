package com.gustavo.api.model.dto;

import java.util.List;

public class AlunoDTO {

	private Long id;
	private String nome;
	private String email;
	private List<CursoDTO> cursos;
	
	public AlunoDTO(Long id, String nome, String email, List<CursoDTO> cursos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cursos = cursos;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<CursoDTO> getCursos(){
		return cursos;
	}
}
