package br.com.grupo4.mutirapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder();
			reg.applySettings(cfg.getProperties());
			StandardServiceRegistry service = reg.build();
			return cfg.buildSessionFactory(service);
		} catch (Throwable e) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return HibernateUtil.sessionFactory;
	}

}
