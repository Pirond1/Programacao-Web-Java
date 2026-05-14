package com.gustavo.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.receitas.model.entity.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}
