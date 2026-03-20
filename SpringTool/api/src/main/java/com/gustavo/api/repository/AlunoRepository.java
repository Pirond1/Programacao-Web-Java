package com.gustavo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavo.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
