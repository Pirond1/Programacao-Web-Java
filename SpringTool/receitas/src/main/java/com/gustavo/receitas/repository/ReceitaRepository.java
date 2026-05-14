package com.gustavo.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.receitas.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
