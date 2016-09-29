package br.com.grupo4.mutirapp.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.service.AcaoService;
import br.com.grupo4.mutirapp.service.AcaoServiceImpl;

@ManagedBean
@RequestScoped
public class AcaoBean {

	private AcaoService acaoService = AcaoServiceImpl.getInstance();
	private Acao acao;
	
	
	public AcaoBean() {
		this.acao = new Acao();
	}

	/*
	 * Actions
	 */

	public String nova() {
		this.acao = new Acao();
		return "/acao/perfil";
	}

	public String editar() {
		return "/acao/perfil";
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
}