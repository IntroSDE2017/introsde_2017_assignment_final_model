package introsde.APP1.parks.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import introsde.APP1.parks.persistence.entities.Park;

public enum ParksDAO {
	instance;
	private Session currentSession;
	private static final SessionFactory currentSessionFactory = getSessionFactory();
	
	private static final String HIBERNATE_CFG_XML = "hibernateAPP1.cfg.xml";

	private ParksDAO() {
		
	}
	
	public static ParksDAO getInstance() {
		return instance;
	}

	public Session openCurrentSession() {
		currentSession = currentSessionFactory.getCurrentSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = currentSessionFactory.getCurrentSession();
		
		if(!currentSession.getTransaction().isActive()) {
			currentSession.beginTransaction();
		}
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentSession.getTransaction().commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure(HIBERNATE_CFG_XML);
		configuration.addAnnotatedClass(Park.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	
	public Park persist(Park entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	public void update(Park entity) {
		getCurrentSession().update(entity);
	}
	
	public Park merge(Park entity) {
		return (Park) getCurrentSession().merge(entity);
	}

	public Park findById(String id) {
		Park item = (Park) getCurrentSession().get(Park.class, id);
		return item; 
	}

	public void delete(Park entity) {
		getCurrentSession().delete(entity);
	}

}
