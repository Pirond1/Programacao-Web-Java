package com.gustavo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.api.model.Professor;
import com.gustavo.api.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private final ProfessorRepository repository;
	
	public ProfessorService(ProfessorRepository repository) {
		this.repository = repository;
	}
	
	public List<Professor> listarTodos(){
		return repository.findAll();
	}
	
	public Professor salvar(Professor professor) {
		return repository.save(professor);
	}
}
