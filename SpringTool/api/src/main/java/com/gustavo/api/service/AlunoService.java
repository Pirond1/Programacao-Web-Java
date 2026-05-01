package com.gustavo.api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.gustavo.api.model.dto.AlunoDTO;
import com.gustavo.api.model.dto.CursoDTO;
import com.gustavo.api.model.entity.Aluno;
import com.gustavo.api.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository repository;
	
	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}
	
	public List<Aluno> listarTodos(){
		return repository.findAll();
	}
	
	public Aluno buscarPorId(long id) {
		return repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Aluno não encontrado"));
	}
	
	public Aluno salvar(Aluno aluno) {
		return repository.save(aluno); 
	}
	
	public Aluno atualizar(long id, Aluno alunoAtt) {
		Aluno aluno = buscarPorId(id);
		aluno.setNome(alunoAtt.getNome());
		aluno.setEmail(alunoAtt.getEmail());
		return repository.save(aluno);
	}
	
	public void deletar(long id) {
		repository.deleteById(id);
	}
	
	public AlunoDTO converterDTO(Aluno aluno) {
		List<CursoDTO> cursoDTO = aluno.getCursos().stream()
				.map(
					curso -> new CursoDTO(curso.getId(), curso.getTitulo())
					)
				.toList();
		
		return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), cursoDTO);
	}
}
