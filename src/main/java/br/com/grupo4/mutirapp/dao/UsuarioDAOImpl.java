package br.com.grupo4.mutirapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.mutirapp.model.Acao;
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
	public void salvar(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.save(usuario);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void atualizar(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
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
		Criteria criteria = session.createCriteria(Usuario.class, "usuario");
		criteria.add(Restrictions.eq("email", email));
		criteria.setMaxResults(1);
		Usuario u = (Usuario) criteria.uniqueResult();
		session.getTransaction().commit();
		return u;
	}

	@Override
	@Transactional
	public List<Acao> listarAcoesCriadasPorId(int usuario_id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		String querySt = "from Acao where usuario_id = :usuarioId";
		SQLQuery query =  session.createSQLQuery(querySt);
		query.addEntity(Usuario.class);
		query.setParameter("usuarioId", usuario_id);
		List results = (List<Acao>) query.list();
		session.getTransaction().commit();
		return results;
	}

	@Override
	@Transactional
	public List<Acao> listarAcoesInteressadasPorId(int usuario_id) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		String querySt = "from Interesse where usuario_id = :usuarioId";
		SQLQuery query =  session.createSQLQuery(querySt);
		query.addEntity(Usuario.class);
		query.setParameter("usuarioId", usuario_id);
		List results = (List<Acao>) query.list();
		session.getTransaction().commit();
		return results;
	}

}
