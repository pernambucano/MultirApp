package br.com.grupo4.mutirapp.dao;

import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;

public interface AcaoDAO {
	public void salvar(Acao acao);
	public void atualizar(Acao acao);
	public void excluir(int id);
	public Acao buscarPorTitulo(String titulo);
	public Acao getAcaoById(int id);
	public void deleteAcaoByTitulo(String titulo);
	public List<Acao> listarTodasAcoes();
}
