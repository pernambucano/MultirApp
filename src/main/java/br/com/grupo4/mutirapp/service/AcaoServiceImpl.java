package br.com.grupo4.mutirapp.service;

import java.util.List;

import br.com.grupo4.mutirapp.dao.AcaoDAO;
import br.com.grupo4.mutirapp.dao.AcaoDAOImpl;
import br.com.grupo4.mutirapp.model.Acao;

public class AcaoServiceImpl implements AcaoService {
	
	private AcaoDAO acaoDAO = AcaoDAOImpl.getInstance();
	private static AcaoServiceImpl instance;
	
	public static AcaoServiceImpl getInstance(){
		if (instance == null){
			instance = new AcaoServiceImpl();
		}
		
		return instance;
	}

	public void setAcaoDAO(AcaoDAO acaoDAO) {
		this.acaoDAO = acaoDAO;
	}
	
	@Override
	public List<Acao> listarTodasAcoes() {
		return acaoDAO.listarTodasAcoes();
	}

	@Override
	public Acao getAcaoByTitulo(String titulo) {
		return acaoDAO.buscarPorTitulo(titulo);
	}

	@Override
	public void cadastrarAcao(Acao acao) {
		acaoDAO.salvar(acao);
	}

	@Override
	public void alterarAcao(Acao acao) {
		acaoDAO.atualizar(acao);
	}

	@Override
	public void deleteAcaoByTitulo(String titulo) {
		acaoDAO.deleteAcaoByTitulo(titulo);
	}
	
	@Override
	public void deleteAcaoById(int id) {
		acaoDAO.excluir(id);
	}

	@Override
	public List<Acao> getUltimasAcoes(int max) {
		return acaoDAO.listarUltimasAcoes(max);
	}

	@Override
	public Acao getAcaoById(int id) {
		return acaoDAO.getAcaoById(id);
	}

}
