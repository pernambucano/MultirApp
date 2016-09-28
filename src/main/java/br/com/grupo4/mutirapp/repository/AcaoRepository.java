package br.com.grupo4.mutirapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.grupo4.mutirapp.model.Acao;

public interface AcaoRepository  extends CrudRepository<Acao, Integer>{
	// criar servico que pega as 10 acoes mais recentes
}
