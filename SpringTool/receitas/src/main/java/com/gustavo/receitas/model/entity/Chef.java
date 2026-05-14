package com.gustavo.receitas.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Chef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Size(message = "Nome deve ter entre 3 a 50 caracteres", min = 3, max = 50)
	private String nome;

	@NotBlank(message = "Especialidade é obrigatória")
	@Size(message = "Especialidade deve ter entre 3 a 30 caracteres", min = 3, max = 30)
	private String especialidade;

	@OneToMany(mappedBy = "chef")
	private List<Receita> receitas;

	public Chef() {}

	public Chef(String nome, String especialidade) {
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

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

}
