package br.com.grupo4.mutirapp.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.service.UsuarioService;
import br.com.grupo4.mutirapp.service.UsuarioServiceImpl;

@ManagedBean
@RequestScoped
@Component
public class UsuarioBean {

	private UsuarioService usuarioService = UsuarioServiceImpl.getInstance();
	private Usuario usuario;
	private String confirmacaoSenha;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
	}

	/*
	 * Actions
	 */

	public String novo() {
		this.usuario = new Usuario();

		return "login";
	}

	public String editar() {
		String email = getEmailUsuario();
		
		this.usuario = this.usuarioService.getUsuarioByEmail(email);
		System.out.println(this.usuario.getId());
		
		return "/usuario/perfil";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();

		if (!senha.equals(this.confirmacaoSenha)) {
			FacesMessage message = new FacesMessage("A senha não foi confirmada corretamente.");
			context.addMessage(null, message);
			return null;
		}

		FacesMessage message;

		// Página de retorno
		String pageReturn = null;

		if (usuario.getId() == 0) {
			pageReturn = "/login";
			//usuario.setStatus(true);
		}
		
		// Por hora, nenhum usuário será bloqueado
		usuario.setStatus(true);
		
		try {
			this.usuarioService.cadastrarUsuario(usuario);
			message = new FacesMessage("Operação realizada com sucesso.");
			context.addMessage(null, message);
		} catch (Exception e) {
			message = new FacesMessage("Usuário já cadastrado!");
			context.addMessage(null, message);
			//throw new UsuarioJaCadastradoException();
			pageReturn = null;
		}
		return pageReturn;
	}

	public String excluir() {
		return null;
	}

	/*
	 * Getters e setters
	 */

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
	public List<Acao> getAcoesCadastradas() {
		
		return usuarioService.getAcoesCadastradasPorEmail(getEmailUsuario());
	}

	public List<Acao> getAcoesInteressadas() {
		return usuarioService.getAcoesInteressadasPorEmail(getEmailUsuario());
	}
	
	private String getEmailUsuario() {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext eContext = fContext.getExternalContext();
		String email = eContext.getRemoteUser();
		return email;
	}

}
