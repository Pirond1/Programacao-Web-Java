package com.gustavo.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.dto.CursoProfessorDTO;
import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.model.entity.Curso;
import com.gustavo.api.service.CursoService;
import com.gustavo.api.service.MatriculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {

	private final CursoService service;
	private final MatriculaService matriculaService;
	
	public CursoController(CursoService service, MatriculaService matriculaService) {
		this.service = service;
		this.matriculaService = matriculaService;
	}
	
	@GetMapping
	public List<Curso> listar(){
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public CursoProfessorDTO listarPorId(@PathVariable Long id) {
		Curso curso = service.listarPorId(id);
		return service.converterDTO(curso);
	}
	
	@PostMapping("/{professor_id}")
	public Curso salvar(@RequestBody @Valid Curso curso, @PathVariable Long professor_id) {
		return service.salvar(curso, professor_id);
	}
	
	@GetMapping("/{id}/aluno")
	public List<Aluno> listar_alunos(@PathVariable Long id){
		return matriculaService.listar_alunos(id);
	}
}
