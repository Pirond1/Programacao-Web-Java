package com.gustavo.receitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.receitas.model.dto.ChefReceitaDTO;
import com.gustavo.receitas.model.entity.Chef;
import com.gustavo.receitas.service.ChefService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chef")
public class ChefController {

	private final ChefService service;

	public ChefController(ChefService service) {
		this.service = service;
	}

	@GetMapping
	public List<ChefReceitaDTO> listar() {
		return service.listarTodos().stream()
				.map(chef -> service.converterDTO(chef))
				.toList();
	}

	@GetMapping("/{id}")
	public ChefReceitaDTO buscarPorId(@PathVariable Long id) {
		Chef chef = service.listarPorId(id);
		return service.converterDTO(chef);
	}

	@PostMapping
	public Chef salvar(@RequestBody @Valid Chef chef) {
		return service.salvar(chef);
	}
	
	@PutMapping("/{id}")
	public ChefReceitaDTO atualizar(@PathVariable Long id, @RequestBody Chef chef) {
		Chef atualiza = service.atualizar(id, chef);
		return service.converterDTO(atualiza);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
	    service.deletar(id);
	}

}
