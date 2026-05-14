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

import com.gustavo.receitas.model.dto.IngredienteDTO;
import com.gustavo.receitas.model.dto.ReceitaIngredienteDTO;
import com.gustavo.receitas.model.entity.Ingrediente;
import com.gustavo.receitas.service.IngredienteService;
import com.gustavo.receitas.service.ReceitaIngredienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	private final IngredienteService service;
	private final ReceitaIngredienteService receitaIngredienteService;

	public IngredienteController(IngredienteService service, ReceitaIngredienteService receitaIngredienteService) {
		this.service = service;
		this.receitaIngredienteService = receitaIngredienteService;
	}

	@GetMapping
	public List<Ingrediente> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public IngredienteDTO buscarPorId(@PathVariable Long id) {
		Ingrediente ingrediente = service.buscarPorId(id);
		return service.converterDTO(ingrediente);
	}

	@PostMapping
	public Ingrediente salvar(@RequestBody @Valid Ingrediente ingrediente) {
		return service.salvar(ingrediente);
	}

	@PutMapping("/{id}")
	public Ingrediente atualizar(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
		return service.atualizar(id, ingrediente);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}

	@GetMapping("/{id}/receita")
	public List<ReceitaIngredienteDTO> listar_receitas(@PathVariable Long id) {
		return receitaIngredienteService.listar_receitas(id);
	}

}
