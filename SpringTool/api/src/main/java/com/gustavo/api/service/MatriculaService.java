package com.gustavo.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.model.entity.Curso;
import com.gustavo.api.repository.AlunoRepository;
import com.gustavo.api.repository.CursoRepository;

@Service
public class MatriculaService {
	
	private final AlunoRepository alunoRepository;
	private final CursoRepository cursoRepository;
	
	public MatriculaService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
		this.alunoRepository = alunoRepository;
		this.cursoRepository = cursoRepository;
	}
	
	public Aluno matricular(Long alunoId, Long cursoId) {
		Aluno aluno = alunoRepository.findById(alunoId)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		
		Curso curso = cursoRepository.findById(cursoId)
				.orElseThrow(() -> new RuntimeException("Curso não encontrado"));
		
		aluno.getCursos().add(curso);
		
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> listar_alunos(Long cursoId) {
		Curso curso = cursoRepository.findById(cursoId)
				.orElseThrow(() -> new RuntimeException("Curso não encontrado"));
		
		return curso.getAlunos();
	}
	
	public List<Curso> listar_cursos(Long alunoId) {
		Aluno aluno = alunoRepository.findById(alunoId)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		
		return aluno.getCursos();
	}
}
