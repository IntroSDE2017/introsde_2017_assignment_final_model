package introsde.APP2.sheds.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import introsde.APP2.sheds.persistence.entities.Shed;

public enum ShedsDAO {
	instance;
	private Session currentSession;
	private static final SessionFactory currentSessionFactory = getSessionFactory();
	
	private final static String HIBERNATE_CFG_XML = "hibernateAPP2.cfg.xml";

	private ShedsDAO() {
		
	}
	
	public static ShedsDAO getInstance() {
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
		configuration.addAnnotatedClass(Shed.class);
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
	
	public void persist(Shed entity) {
		getCurrentSession().save(entity);
	}

	public void update(Shed entity) {
		getCurrentSession().update(entity);
	}
	
	public Shed merge(Shed entity) {
		return (Shed) getCurrentSession().merge(entity);
	}

	public Shed findById(String id) {
		Shed book = (Shed) getCurrentSession().get(Shed.class, id);
		return book; 
	}

	public void delete(Shed entity) {
		getCurrentSession().delete(entity);
	}

}
