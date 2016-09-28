package br.com.grupo4.mutirapp.service;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.grupo4.mutirapp.dao.UsuarioDAO;
import br.com.grupo4.mutirapp.dao.UsuarioDAOImpl;
import br.com.grupo4.mutirapp.model.Acao;
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
		// List<Acao> lista = (List<Acao>)
		// usuarioDAO.findByEmail(email).getAcoes();
		// return lista;
		return null;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		System.out.println("USI: " + usuario);
		System.out.println("USI: " + usuarioDAO);
		this.usuarioDAO.salvar(usuario);
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUsuarioByEmail(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Acao> getAcoesCadastradasPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acao> getAcoesInteressadasPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirInteresse(Usuario usuario, Acao a, Date data) {
		// TODO Auto-generated method stub

	}
}
