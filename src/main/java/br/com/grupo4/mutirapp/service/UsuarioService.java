package br.com.grupo4.mutirapp.service;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import br.com.grupo4.mutirapp.exception.UsuarioJaCadastradoException;
import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;

@Component
public interface UsuarioService {
	public Usuario getUsuarioByEmail(String email);
	public void cadastrarUsuario(Usuario usuario)  throws UsuarioJaCadastradoException, ConstraintViolationException;
	public void alterarUsuario(Usuario usuario);
	public void deleteUsuarioByEmail(String email);
	public List<Acao> getAcoesCadastradasPorEmail(String email);
	public List<Acao> getAcoesInteressadasPorEmail(String email);
	public void inserirInteresse(Usuario usuario, Acao a, Date data);
}
