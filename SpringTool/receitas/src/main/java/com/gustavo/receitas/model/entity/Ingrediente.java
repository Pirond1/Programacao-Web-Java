package com.gustavo.receitas.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Size(message = "Nome deve ter entre 3 a 50 caracteres", min = 3, max = 50)
	private String nome;

	@NotBlank(message = "Unidade de medida é obrigatória")
	@Size(message = "Unidade de medida deve ter entre 1 a 20 caracteres", min = 1, max = 20)
	private String unidadeMedida;
	
	@NotNull(message = "Quantidade é obrigatória")
	@Min(message = "Quantidade minima de 1", value = 1)
	@Max(message = "Carga horária maxima de 99999", value = 99999)
	private int quantidade;

	@ManyToMany(mappedBy = "ingredientes")
	@JsonIgnore
	private List<Receita> receitas = new ArrayList<>();

	public Ingrediente() {}

	public Ingrediente(String nome, String unidadeMedida, int quantidade) {
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
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

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

}
