package com.gustavo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavo.api.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
