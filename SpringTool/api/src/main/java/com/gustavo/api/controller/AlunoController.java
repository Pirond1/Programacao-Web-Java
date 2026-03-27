package com.gustavo.api.controller;

import com.gustavo.api.model.Aluno;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.repository.AlunoRepository;
import com.gustavo.api.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Aluno buscarPorId(@PathVariable long id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public Aluno salvar(@RequestBody Aluno aluno) {
		return service.salvar(aluno);
	}
	
	@PutMapping("/{id}")
	public Aluno atualizar(@PathVariable long id, @RequestBody Aluno aluno) {
		return service.atualizar(id, aluno);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		service.deletar(id);
	}
}
