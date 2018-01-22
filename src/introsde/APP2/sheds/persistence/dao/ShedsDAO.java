package introsde.APP2.sheds.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import introsde.APP2.sheds.persistence.entities.Shed;

public class ShedsDAO {

	private Session currentSession;
	
	private Transaction currentTransaction;
	
	private final static String configFile = "hibernateAPP2.cfg.xml";

	public ShedsDAO() {
		
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure(configFile);
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

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
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