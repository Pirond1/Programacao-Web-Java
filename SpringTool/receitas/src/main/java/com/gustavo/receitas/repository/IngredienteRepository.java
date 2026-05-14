package com.gustavo.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.receitas.model.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
