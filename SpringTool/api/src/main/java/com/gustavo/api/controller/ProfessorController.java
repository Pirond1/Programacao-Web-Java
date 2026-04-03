package com.gustavo.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.Professor;
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
	
	@PostMapping
	public Professor salvar(@RequestBody Professor professor) {
		return service.salvar(professor);
	}
}
