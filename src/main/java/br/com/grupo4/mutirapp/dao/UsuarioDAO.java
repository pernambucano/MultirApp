package br.com.grupo4.mutirapp.dao;

import java.util.List;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Interesse;
import br.com.grupo4.mutirapp.model.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario) throws Exception;
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario buscarPorId(Integer id);
	public Usuario buscarPorLogin(String login);
	public Usuario buscarPorEmail(String email);
	public List<Usuario> listar();
	public List<Acao> listarAcoesCriadasPorId(String email);
	public List<Acao> listarAcoesInteressadasPorId(String email); 
	public void inserirInteresse(Usuario u, Acao a);
}
