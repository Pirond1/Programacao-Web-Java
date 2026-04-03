package com.gustavo.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.Curso;
import com.gustavo.api.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	private final CursoService service;
	
	public CursoController(CursoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Curso> listar(){
		return service.listarTodos();
	}
	
	@PostMapping("/{professor_id}")
	public Curso salvar(@RequestBody Curso curso, @PathVariable Long professor_id) {
		return service.salvar(curso, professor_id);
	}
}
