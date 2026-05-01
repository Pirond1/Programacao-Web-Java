package com.gustavo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.service.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

	private final MatriculaService service;
	
	public MatriculaController(MatriculaService service) {
		this.service = service;
	}
	
	@PostMapping
	public Aluno matricular(@RequestParam Long aluno_Id, @RequestParam Long curso_Id) {
		return service.matricular(aluno_Id, curso_Id);
	}
}
