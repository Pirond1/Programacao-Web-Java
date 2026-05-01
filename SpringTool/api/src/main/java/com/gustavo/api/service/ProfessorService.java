package com.gustavo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.api.model.dto.AlunoDTO;
import com.gustavo.api.model.dto.CursoDTO;
import com.gustavo.api.model.dto.ProfessorCursoDTO;
import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.model.entity.Professor;
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
	
	public Professor listarPorId(Long Id) {
		return repository.findById(Id)
				.orElseThrow(()-> new RuntimeException("Professor não encontrado"));
	}
	
	
	public Professor salvar(Professor professor) {
		return repository.save(professor);
	}
	
	public ProfessorCursoDTO converterDTO(Professor professor) {
		List<CursoDTO> cursoDTO = professor.getCursos().stream()
									.map(
										curso -> new CursoDTO(curso.getId(), curso.getTitulo())
										)
									.toList();
									
		return new ProfessorCursoDTO(professor.getId(), professor.getNome(), professor.getEspecialidade(), cursoDTO);
	}
}
