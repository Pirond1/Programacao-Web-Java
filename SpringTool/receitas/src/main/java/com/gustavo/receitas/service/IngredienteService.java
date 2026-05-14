package com.gustavo.receitas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.receitas.model.dto.IngredienteDTO;
import com.gustavo.receitas.model.dto.ReceitaDTO;
import com.gustavo.receitas.model.entity.Ingrediente;
import com.gustavo.receitas.repository.IngredienteRepository;

@Service
public class IngredienteService {

	private final IngredienteRepository repository;

	public IngredienteService(IngredienteRepository repository) {
		this.repository = repository;
	}

	public List<Ingrediente> listarTodos() {
		return repository.findAll();
	}

	public Ingrediente buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
	}

	public Ingrediente salvar(Ingrediente ingrediente) {
		return repository.save(ingrediente);
	}

	public Ingrediente atualizar(Long id, Ingrediente ingredienteAtt) {
		Ingrediente ingrediente = buscarPorId(id);
		ingrediente.setNome(ingredienteAtt.getNome());
		ingrediente.setUnidadeMedida(ingredienteAtt.getUnidadeMedida());
		ingrediente.setQuantidade(ingredienteAtt.getQuantidade());
		return repository.save(ingrediente);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public IngredienteDTO converterDTO(Ingrediente ingrediente) {
		List<ReceitaDTO> receitaDTO = ingrediente.getReceitas().stream()
				.map(
					receita -> new ReceitaDTO(receita.getId(), receita.getTitulo())
				)
				.toList();

		return new IngredienteDTO(ingrediente.getId(), ingrediente.getNome(), ingrediente.getUnidadeMedida(), ingrediente.getQuantidade(), receitaDTO);
	}

}
