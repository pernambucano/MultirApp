package br.com.grupo4.mutirapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.mutirapp.model.Acao;
import br.com.grupo4.mutirapp.util.HibernateUtil;

public class AcaoDAOImpl implements AcaoDAO {

	private SessionFactory sessionFactory;
	private static AcaoDAOImpl instance;
	
	public static AcaoDAOImpl getInstance(){
		if (instance == null){
			instance = new AcaoDAOImpl();
		}
		
		return instance;
	}
	
	public AcaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	@Transactional
	public void salvar(Acao acao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			session.save(acao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
		
	}

	@Override
	@Transactional
	public void atualizar(Acao acao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(acao);
			session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public void excluir(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getAcaoById(id));
		session.getTransaction().commit();
		}
	}
	
	@Transactional
	public Acao getAcaoById(int id) {
		return (Acao) sessionFactory.getCurrentSession().get(Acao.class, id); 
	}

	@Override
	@Transactional
	public Acao buscarPorTitulo(String titulo) {
		return (Acao) sessionFactory.getCurrentSession().get(Acao.class, titulo); 
	}

	@Override
	@Transactional
	public void deleteAcaoByTitulo(String titulo) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.buscarPorTitulo(titulo));
		session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public List<Acao> listarTodasAcoes() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			String queryStr = "from acao";
			SQLQuery query = session.createSQLQuery(queryStr);
			List<Acao> lista = (List<Acao>) query.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}
	
}
