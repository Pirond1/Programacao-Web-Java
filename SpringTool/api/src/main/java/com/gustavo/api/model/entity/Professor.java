package com.gustavo.api.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(message = "Nome deve ter entre 3 a 50 caracteres", min = 3, max = 50)
	private String nome;
	
	@NotBlank(message = "Especialidade é obrigatório")
	@Size(message = "Especialidade deve ter entre 3 a 20 caracteres", min = 3, max = 20)
	private String especialidade;
	
	@OneToMany(mappedBy = "professor")
	private List<Curso> cursos;
	
	public Professor() {}

	public Professor(String nome, String especialidade) {
		this.nome = nome;
		this.especialidade = especialidade;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public List<Curso> getCursos(){
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
