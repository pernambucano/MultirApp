package br.com.grupo4.mutirapp.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

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
		return "/usuario/perfil";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();

		if (!senha.equals(this.confirmacaoSenha)) {
			FacesMessage message = new FacesMessage("A senha n�o foi confirmada corretamente.");
			context.addMessage(null, message);
			return null;
		}

		FacesMessage message;

		// Página de retorno
		String pageReturn = null;

		if (usuario.getId() == 0) {
			pageReturn = "/login";
			usuario.setStatus(true);
		}
		
		try {
			this.usuarioService.cadastrarUsuario(usuario);
			message = new FacesMessage("Opera��o realizada com sucesso.");
			context.addMessage(null, message);
		} catch (Exception e) {
			message = new FacesMessage("Usu�rio j� cadastrado!");
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

}
