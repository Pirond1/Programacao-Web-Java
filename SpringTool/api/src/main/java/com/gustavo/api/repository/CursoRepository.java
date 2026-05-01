package com.gustavo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.api.model.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
