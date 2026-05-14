package com.gustavo.receitas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavo.receitas.model.dto.ChefDTO;
import com.gustavo.receitas.model.dto.ReceitaChefDTO;
import com.gustavo.receitas.model.entity.Chef;
import com.gustavo.receitas.model.entity.Receita;
import com.gustavo.receitas.repository.ChefRepository;
import com.gustavo.receitas.repository.ReceitaRepository;

@Service
public class ReceitaService {

	private final ChefRepository chefRepository;
	private final ReceitaRepository receitaRepository;

	public ReceitaService(ChefRepository chefRepository, ReceitaRepository receitaRepository) {
		this.chefRepository = chefRepository;
		this.receitaRepository = receitaRepository;
	}

	public List<Receita> listarTodos() {
		return receitaRepository.findAll();
	}

	public Receita listarPorId(Long id) {
		return receitaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Receita não encontrada"));
	}

	public Receita salvar(Receita receita, Long chef_id) {
		Chef chef = chefRepository.findById(chef_id)
				.orElseThrow(() -> new RuntimeException("Chef não encontrado"));

		receita.setChef(chef);
		return receitaRepository.save(receita);
	}

	public ReceitaChefDTO converterDTO(Receita receita) {
		Chef chef = receita.getChef();

		ChefDTO chefDTO = new ChefDTO(
			chef.getId(),
			chef.getNome(),
			chef.getEspecialidade()
		);

		return new ReceitaChefDTO(receita.getId(), receita.getTitulo(), chefDTO);
	}

}
