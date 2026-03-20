package com.gustavo.api.controller;

import com.gustavo.api.model.Aluno;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	AlunoRepository repository;

	public AlunoController(AlunoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return repository.findAll();
	}
	
	@PostMapping
	public Aluno salvar(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}
	
}
