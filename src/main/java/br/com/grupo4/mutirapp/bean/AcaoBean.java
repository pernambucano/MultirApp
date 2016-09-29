package br.com.grupo4.mutirapp.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.service.AcaoService;
import br.com.grupo4.mutirapp.service.AcaoServiceImpl;
import br.com.grupo4.mutirapp.service.BuscaCEPService;
import br.com.grupo4.mutirapp.service.BuscaCEPServiceImpl;

@ManagedBean
@RequestScoped
public class AcaoBean {

	private AcaoService acaoService = AcaoServiceImpl.getInstance();
	private BuscaCEPService buscaCepService = BuscaCEPServiceImpl.getInstance();
	private Acao acao;
	private List<Acao> listaAcoes;
	
	public AcaoBean() {
		this.acao = new Acao();
	}

	/*
	 * Actions
	 */
	
	public String buscar(String titulo){
		this.listaAcoes = this.acaoService.getAcoesByTitulo(titulo); 
		return "/acao/buscar";
//		return null;
	}

	public String nova() {
		this.acao = new Acao();
		return "/acao/perfil";
	}

	public String editar() {
		return "/acao/perfil";
	}
	
	public String buscarCep() {
		this.buscaCepService.preencherEndereco(acao, acao.getEndCep());
		return null;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Operação realizada com sucesso.");
		context.addMessage(null, message);
		this.acaoService.cadastrarAcao(acao);
		return "/acao/visualizar2";
	}

	public String excluir() {
		return null;
	}
	
	public String getAcaoById(int id){
		this.acaoService.getAcaoById(id);
		return "/acao/visualizar2";
	}

	/*
	 * Getters e setters
	 */
	
	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public List<Acao> getListaAcoes() {
		return listaAcoes;
	}

	public void setListaAcoes(List<Acao> listaAcoes) {
		this.listaAcoes = listaAcoes;
	}
	
	
}