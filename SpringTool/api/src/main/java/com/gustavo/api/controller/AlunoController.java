package com.gustavo.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.api.model.dto.AlunoDTO;
import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.model.entity.Curso;
import com.gustavo.api.service.AlunoService;
import com.gustavo.api.service.MatriculaService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoService service;
	private final MatriculaService matriculaService;

	public AlunoController(AlunoService service, MatriculaService matriculaService) {
		this.service = service;
		this.matriculaService = matriculaService;
	}
	
	@GetMapping
	public List<Aluno> listar() {
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public AlunoDTO buscarPorId(@PathVariable long id) {
		Aluno aluno = service.buscarPorId(id);
		return service.converterDTO(aluno);
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
	
	@GetMapping("/{id}/curso")
	public List<Curso> listar_cursos(@PathVariable Long id){
		return matriculaService.listar_cursos(id);
	}
}
