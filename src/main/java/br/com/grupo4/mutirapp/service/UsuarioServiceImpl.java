package br.com.grupo4.mutirapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.mutirapp.dao.UsuarioDAO;
import br.com.grupo4.mutirapp.dao.UsuarioDAOImpl;
import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Interesse;
import br.com.grupo4.mutirapp.model.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO = UsuarioDAOImpl.getInstance();

	private static UsuarioServiceImpl instance;

	public static UsuarioServiceImpl getInstance() {
		if (instance == null) {
			instance = new UsuarioServiceImpl();
		}

		return instance;
	}

	@Override
	public List<Acao> listarAcoes(String email) {
		 List<Acao> lista = (List<Acao>) this.usuarioDAO.buscarPorEmail(email).getAcoes();
		// return lista;
		return lista;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		return this.usuarioDAO.buscarPorEmail(email);
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		this.usuarioDAO.salvar(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		this.usuarioDAO.atualizar(usuario);
	}

	@Override
	public void deleteUsuarioByEmail(String email) {
		this.usuarioDAO.excluir(this.usuarioDAO.buscarPorEmail(email));
	}

	@Override
	public List<Acao> getAcoesCadastradasPorEmail(String email) {
		return this.usuarioDAO.listarAcoesCriadasPorId(this.usuarioDAO.buscarPorEmail(email).getId());
	}

	@Override
	public List<Acao> getAcoesInteressadasPorEmail(String email) {
		return this.usuarioDAO.listarAcoesInteressadasPorId(this.usuarioDAO.buscarPorEmail(email).getId());
	}

	@Override
	public void inserirInteresse(Usuario usuario, Acao a, Date data) {
		Interesse interesse = new Interesse();
		interesse.setUsuario(usuario);
		interesse.setAcao(a);
		interesse.setData(data);
		usuario.getInteresses().add(interesse);
	}
}
