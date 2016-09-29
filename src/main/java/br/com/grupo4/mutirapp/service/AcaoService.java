package br.com.grupo4.mutirapp.service;

import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;

public interface AcaoService {
	public List<Acao> listarTodasAcoes();
	public void cadastrarAcao(Acao acao);
	public void alterarAcao(Acao acao);
	public void deleteAcaoByTitulo(String titulo);
	public void deleteAcaoById(int id);
	public List<Acao> getUltimasAcoes(int max);
	public Acao getAcaoById(int id);
	public List<Acao> getAcoesByTitulo(String titulo);
}
