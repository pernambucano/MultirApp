package br.com.grupo4.mutirapp.service;

import br.com.grupo4.mutirapp.model.Acao;

public interface BuscaCEPService {
	
	public void preencherEndereco(Acao acao, String cep);

}
