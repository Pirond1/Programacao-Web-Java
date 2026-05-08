package com.gustavo.api.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Titulo é obrigatório")
	@Size(message = "Titulo deve ter entre 3 a 20 caracteres", min = 3, max = 20)
	private String titulo;
	
	@NotNull(message = "Carga horária é obrigatória")
	@Min(message = "Carga horária minima de 10 Horas", value = 10)
	@Max(message = "Carga horária maxima de 99 Horas", value = 99)
	private int cargaHoraria;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@ManyToMany(mappedBy = "cursos")
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {}
	
	public Curso(String titulo, int cargaHoraria) {
		this.titulo = titulo;
		this.cargaHoraria = cargaHoraria;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
