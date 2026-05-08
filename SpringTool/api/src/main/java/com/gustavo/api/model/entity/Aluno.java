package com.gustavo.api.model.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nome é obrigatório")
	@Size(message = "Nome deve ter entre 3 a 50 caracteres", min = 3, max = 50)
	private String nome;
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email com formato inválido")
	private String email;
	
	@ManyToMany
	@JoinTable(
		name = "matriculas",
		joinColumns = @JoinColumn(name = "aluno_id"),
		inverseJoinColumns = @JoinColumn(name = "curso_id")
		)
	private List<Curso> cursos = new ArrayList<>();
	

	public Aluno(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Aluno() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
