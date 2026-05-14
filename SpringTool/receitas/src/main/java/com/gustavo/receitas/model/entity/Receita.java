package com.gustavo.receitas.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Título é obrigatório")
	@Size(message = "Título deve ter entre 3 a 50 caracteres", min = 3, max = 50)
	private String titulo;

	@NotNull(message = "Tempo de preparo é obrigatório")
	@Min(message = "Tempo de preparo mínimo de 5 minutos", value = 5)
	@Max(message = "Tempo de preparo máximo de 300 minutos", value = 300)
	private int tempoPreparo;

	@ManyToOne
	@JoinColumn(name = "chef_id")
	private Chef chef;

	@ManyToMany
	@JoinTable(
		name = "receita_ingrediente",
		joinColumns = @JoinColumn(name = "receita_id"),
		inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
	)
	private List<Ingrediente> ingredientes = new ArrayList<>();

	public Receita() {}

	public Receita(String titulo, int tempoPreparo) {
		this.titulo = titulo;
		this.tempoPreparo = tempoPreparo;
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

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
