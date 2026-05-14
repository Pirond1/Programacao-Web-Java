package com.gustavo.receitas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.receitas.model.dto.ReceitaChefDTO;
import com.gustavo.receitas.model.entity.Ingrediente;
import com.gustavo.receitas.model.entity.Receita;
import com.gustavo.receitas.service.ReceitaIngredienteService;
import com.gustavo.receitas.service.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	private final ReceitaService service;
	private final ReceitaIngredienteService receitaIngredienteService;

	public ReceitaController(ReceitaService service, ReceitaIngredienteService receitaIngredienteService) {
		this.service = service;
		this.receitaIngredienteService = receitaIngredienteService;
	}

	@GetMapping
	public List<ReceitaChefDTO> listar() {
		return service.listarTodos().stream()
				.map(receita -> service.converterDTO(receita))
				.toList();
	}

	@GetMapping("/{id}")
	public ReceitaChefDTO listarPorId(@PathVariable Long id) {
		Receita receita = service.listarPorId(id);
		return service.converterDTO(receita);
	}

	@PostMapping("/{chef_id}")
	public ReceitaChefDTO salvar(@RequestBody @Valid Receita receita, @PathVariable Long chef_id) {
		Receita salva = service.salvar(receita, chef_id);
		return service.converterDTO(salva);
	}

	@GetMapping("/{id}/ingrediente")
	public List<Ingrediente> listar_ingredientes(@PathVariable Long id) {
		return receitaIngredienteService.listar_ingredientes(id);
	}

}
