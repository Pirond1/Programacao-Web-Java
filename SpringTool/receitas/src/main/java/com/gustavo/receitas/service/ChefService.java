package com.gustavo.receitas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.receitas.model.dto.ChefReceitaDTO;
import com.gustavo.receitas.model.dto.ReceitaDTO;
import com.gustavo.receitas.model.entity.Chef;
import com.gustavo.receitas.repository.ChefRepository;

@Service
public class ChefService {

	private final ChefRepository repository;

	public ChefService(ChefRepository repository) {
		this.repository = repository;
	}

	public List<Chef> listarTodos() {
		return repository.findAll();
	}

	public Chef listarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Chef não encontrado"));
	}

	public Chef salvar(Chef chef) {
		return repository.save(chef);
	}

	public ChefReceitaDTO converterDTO(Chef chef) {
		List<ReceitaDTO> receitaDTO = chef.getReceitas().stream()
				.map(
					receita -> new ReceitaDTO(receita.getId(), receita.getTitulo())
				)
				.toList();

		return new ChefReceitaDTO(chef.getId(), chef.getNome(), chef.getEspecialidade(), receitaDTO);
	}
	
	public Chef atualizar(Long id, Chef chefAtt) {
	    Chef chef = listarPorId(id);
	    chef.setNome(chefAtt.getNome());
	    chef.setEspecialidade(chefAtt.getEspecialidade());
	    return repository.save(chef);
	}

	public void deletar(Long id) {
	    repository.deleteById(id);
	}

}
