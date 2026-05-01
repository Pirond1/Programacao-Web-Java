package com.gustavo.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.dto.ProfessorCursoDTO;
import com.gustavo.api.model.entity.Professor;
import com.gustavo.api.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	private final ProfessorService service;
	
	public ProfessorController(ProfessorService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Professor> listar() {
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ProfessorCursoDTO buscarPorId(@PathVariable long id) {
		Professor professor = service.listarPorId(id);
		return service.converterDTO(professor);
	}
	
	@PostMapping
	public Professor salvar(@RequestBody Professor professor) {
		return service.salvar(professor);
	}
}
