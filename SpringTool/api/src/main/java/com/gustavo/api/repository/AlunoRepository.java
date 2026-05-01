package com.gustavo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.api.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
