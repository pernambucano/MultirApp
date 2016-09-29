package br.com.grupo4.mutirapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.model.Interesse;
import br.com.grupo4.mutirapp.model.Usuario;
import br.com.grupo4.mutirapp.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	private SessionFactory sessionFactory;
	private static UsuarioDAOImpl instance;

	public static UsuarioDAOImpl getInstance(){
		if (instance == null){
			instance = new UsuarioDAOImpl();
		}

		return instance;
	}


	public UsuarioDAOImpl() {

		this.sessionFactory = HibernateUtil.getSessionFactory();
	}


	@Override
	@Transactional
	public void salvar(Usuario usuario) throws Exception{
		if (usuario.getId() == 0) {
			usuario.getPermissao().add("ROLE_USUARIO"); // Permissão padrão
		} else if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			// Recuperação das permissões do usuário
//			Session session = sessionFactory.getCurrentSession();
			Usuario usuarioPermissao = this.buscarPorId(usuario.getId());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			// Remoção do contexto persistente
//			session.evict(usuarioPermissao);
		}

		Session session = sessionFactory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception();
		}
	}

	@Override
	@Transactional
	public void atualizar(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();

		// Recuperação das permissões do usuário
//		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
//			Usuario usuarioPermissao = this.buscarPorId(usuario.getId());
//
//			// Remoção do contexto persistente
//			session.evict(usuarioPermissao);
//		}

		session.getTransaction().begin();
		session.update(usuario);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void excluir(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.delete(usuario);
		session.getTransaction().commit();


	}

	@Override
	@Transactional
	public Usuario buscarPorId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Usuario u = (Usuario) session.get(Usuario.class, id);
		session.getTransaction().commit();
		return u;
	}

	@Override
	@Transactional
	public Usuario buscarPorLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));
		Usuario u = (Usuario) criteria.uniqueResult();
		session.getTransaction().commit();
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuario> listar() {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Usuario.class);
		List<Usuario> lista =  criteria.list();
		session.getTransaction().commit();
		return lista;		
	}

	@Override
	@Transactional
	public Usuario buscarPorEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		Usuario u = (Usuario) criteria.uniqueResult();
		session.getTransaction().commit();
		return u;
	}

	@Override
	@Transactional
	public List<Acao> listarAcoesCriadasPorId(String email) {
		Usuario usuario = this.buscarPorEmail(email);
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		String querySt = "select * from acao where usuario_id = :usuarioId";
		SQLQuery query =  session.createSQLQuery(querySt);
		query.addEntity(Acao.class);
		query.setParameter("usuarioId", usuario.getId());
		List<Acao> results = query.list();
		session.getTransaction().commit();
		return results;
	}

	@Override
	@Transactional
	public List<Acao> listarAcoesInteressadasPorId(String email) {
		Usuario usuario = this.buscarPorEmail(email);
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		String querySt = "select a.* from acao a, interesse i where i.usuario_id = :usuarioId and a.id = i.acao_id";
		SQLQuery query =  session.createSQLQuery(querySt);
		query.addEntity(Acao.class);
		query.setParameter("usuarioId", usuario.getId());
		List<Acao> results = query.list();
		session.getTransaction().commit();
		return results;
	}

}
