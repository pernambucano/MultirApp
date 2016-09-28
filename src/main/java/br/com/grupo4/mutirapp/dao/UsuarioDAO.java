package br.com.grupo4.mutirapp.dao;

import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario buscarPorId(Integer id);
	public Usuario buscarPorLogin(String login);
	public Usuario buscarPorEmail(String email);
	public List<Usuario> listar();
	public List<Acao> listarAcoesCriadasPorId(int usuario_id);
	public List<Acao> listarAcoesInteressadasPorId(int usuario_id);
	
	// Paulo
	
	
}
