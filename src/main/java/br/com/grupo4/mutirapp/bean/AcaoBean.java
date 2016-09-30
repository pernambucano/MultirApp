package br.com.grupo4.mutirapp.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.service.AcaoService;
import br.com.grupo4.mutirapp.service.AcaoServiceImpl;
import br.com.grupo4.mutirapp.service.UsuarioService;
import br.com.grupo4.mutirapp.service.UsuarioServiceImpl;

@ManagedBean
@SessionScoped
public class AcaoBean {

	private AcaoService acaoService = AcaoServiceImpl.getInstance();
	private UsuarioService usuarioS  = UsuarioServiceImpl.getInstance();
	private Acao acao;
	private List<Acao> listaAcoes;
	FacesContext context = FacesContext.getCurrentInstance();
	private Map<String,String> params =
			context.getExternalContext().getRequestParameterMap();

	private String acao_id;
	public AcaoBean() {
		this.acao = new Acao();
	}

	/*
	 * Actions
	 */ 
	
	public String buscar(String titulo){
		this.listaAcoes = this.acaoService.getAcoesByTitulo(titulo); 

		return "/acao/buscar";
		// return null;
	}

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
		return "/acao/visualizar";
	}

	public String excluir() {
		return null;
	}

	public String getAcaoById(int id) {
		this.acaoService.getAcaoById(id);
		return "/acao/visualizar";
	}
	
	public String visualizar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.acao_id = getAcaoIdParam(fc);

		return "/acao/visualizar";
	}
	

	public String getAcao_id() {
		return acao_id;
	}

	public void setAcao_id(String acao_id) {
		this.acao_id = acao_id;
	}

	//get value from "f:param"
	public String getAcaoIdParam(FacesContext fc){

		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("acao_id");

	}

	public void teste() {
		Acao a = acaoService.getAcaoById(Integer.parseInt(acao_id));
		Usuario usuario= usuarioS.getUsuarioByEmail(this.getEmailUsuario());
		this.usuarioS.inserirInteresse(usuario, a, new Date());
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

	public String getData() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	private String getEmailUsuario() {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext eContext = fContext.getExternalContext();
		String email = eContext.getRemoteUser();
		return email;
	}
}