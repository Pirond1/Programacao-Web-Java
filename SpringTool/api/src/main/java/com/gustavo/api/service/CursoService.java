package com.gustavo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gustavo.api.model.Curso;
import com.gustavo.api.model.Professor;
import com.gustavo.api.repository.CursoRepository;
import com.gustavo.api.repository.ProfessorRepository;

@Service
public class CursoService {

	private final ProfessorRepository professorRepository;
	private final CursoRepository cursoRepository;
	
	public CursoService(ProfessorRepository professorRepository, CursoRepository cursoRepository) {
		this.professorRepository = professorRepository;
		this.cursoRepository = cursoRepository;
	}
	
	public List<Curso> listarTodos(){
		return cursoRepository.findAll();
	}
	
	public Curso salvar(Curso curso, Long professor_id) {
		Professor professor = professorRepository.findById(professor_id)
				.orElseThrow(()-> new RuntimeException("Professor não encontrado"));
		
		curso.setProfessor(professor);
		return cursoRepository.save(curso);
	}
}