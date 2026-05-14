package com.gustavo.receitas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.receitas.model.dto.IngredienteDTO;
import com.gustavo.receitas.model.dto.ReceitaIngredienteDTO;
import com.gustavo.receitas.model.entity.Ingrediente;
import com.gustavo.receitas.model.entity.Receita;
import com.gustavo.receitas.repository.IngredienteRepository;
import com.gustavo.receitas.repository.ReceitaRepository;

@Service
public class ReceitaIngredienteService {

	private final ReceitaRepository receitaRepository;
	private final IngredienteRepository ingredienteRepository;

	public ReceitaIngredienteService(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository) {
		this.receitaRepository = receitaRepository;
		this.ingredienteRepository = ingredienteRepository;
	}

	public Receita adicionarIngrediente(Long receitaId, Long ingredienteId) {
		Receita receita = receitaRepository.findById(receitaId)
				.orElseThrow(() -> new RuntimeException("Receita não encontrada"));

		Ingrediente ingrediente = ingredienteRepository.findById(ingredienteId)
				.orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

		receita.getIngredientes().add(ingrediente);

		return receitaRepository.save(receita);
	}

	public List<Ingrediente> listar_ingredientes(Long receitaId) {
		Receita receita = receitaRepository.findById(receitaId)
				.orElseThrow(() -> new RuntimeException("Receita não encontrada"));

		return receita.getIngredientes();
	}

	public List<ReceitaIngredienteDTO> listar_receitas(Long ingredienteId) {
	    Ingrediente ingrediente = ingredienteRepository.findById(ingredienteId)
	            .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

	    return ingrediente.getReceitas().stream()
	            .map(r -> converterDTO(r))
	            .toList();
	}
	
	public ReceitaIngredienteDTO converterDTO(Receita receita) {
	    List<IngredienteDTO> ingredientesDTO = receita.getIngredientes().stream()
	            .map(i -> new IngredienteDTO(i.getId(), i.getNome(), i.getUnidadeMedida(), i.getQuantidade(), null))
	            .toList();

	    return new ReceitaIngredienteDTO(receita.getId(), receita.getTitulo(), ingredientesDTO);
	}

}
