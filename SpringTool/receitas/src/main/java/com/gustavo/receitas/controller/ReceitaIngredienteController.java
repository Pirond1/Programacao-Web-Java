package com.gustavo.receitas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.receitas.model.dto.ReceitaIngredienteDTO;
import com.gustavo.receitas.model.entity.Receita;
import com.gustavo.receitas.service.ReceitaIngredienteService;

@RestController
@RequestMapping("/receita-ingrediente")
public class ReceitaIngredienteController {

	private final ReceitaIngredienteService service;

	public ReceitaIngredienteController(ReceitaIngredienteService service) {
		this.service = service;
	}

	@PostMapping
	public ReceitaIngredienteDTO adicionarIngrediente(@RequestParam Long receita_Id, @RequestParam Long ingrediente_Id) {
	    Receita receita = service.adicionarIngrediente(receita_Id, ingrediente_Id);
	    return service.converterDTO(receita);
	}

}
