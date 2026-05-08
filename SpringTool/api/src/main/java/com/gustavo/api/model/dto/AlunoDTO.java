package com.gustavo.api.model.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {

	private Long id;
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	@NotBlank(message = "Email é obrigatório")
	@Email
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
