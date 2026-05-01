package com.gustavo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.api.model.dto.AlunoDTO;
import com.gustavo.api.model.dto.CursoDTO;
import com.gustavo.api.model.dto.CursoProfessorDTO;
import com.gustavo.api.model.dto.ProfessorCursoDTO;
import com.gustavo.api.model.dto.ProfessorDTO;
import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.model.entity.Curso;
import com.gustavo.api.model.entity.Professor;
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
	
	public Curso listarPorId(Long id) {
		return cursoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Curso não encontrado"));
	}
	
	public Curso salvar(Curso curso, Long professor_id) {
		Professor professor = professorRepository.findById(professor_id)
				.orElseThrow(()-> new RuntimeException("Professor não encontrado"));
		
		curso.setProfessor(professor);
		return cursoRepository.save(curso);
	}
	
	public CursoProfessorDTO converterDTO(Curso curso) {
		Professor professor = curso.getProfessor();

		ProfessorDTO professorDTO = new ProfessorDTO(
			professor.getId(),
			professor.getNome(),
			professor.getEspecialidade()
		);
					
		return new CursoProfessorDTO(curso.getId(), curso.getTitulo(), professorDTO);
	}
	
}