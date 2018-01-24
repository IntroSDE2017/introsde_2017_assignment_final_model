package introsde.APP3.users.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.Preference;
import introsde.APP3.users.persistence.entities.Review;
import introsde.APP3.users.persistence.entities.User;

public class UsersDAO {

	private static final String HIBERNATE_CFG_XML = "hibernateAPP3.cfg.xml";

	private Session currentSession;
	
	private Transaction currentTransaction;

	public UsersDAO() {
		
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
		Configuration configuration = new Configuration().configure(HIBERNATE_CFG_XML);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Review.class);
		configuration.addAnnotatedClass(PlaceVisited.class);
		configuration.addAnnotatedClass(Preference.class);
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
	
	public User persist(User entity) {
		getCurrentSession().save(entity);
		return entity;
	}
	public Review persist(Review entity) {
		getCurrentSession().save(entity);
		return entity;
	}
	public PlaceVisited persist(PlaceVisited entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	public void update(User entity) {
		getCurrentSession().update(entity);
	}
	public void update(Review entity) {
		getCurrentSession().update(entity);
	}
	public void update(PlaceVisited entity) {
		getCurrentSession().update(entity);
	}
	
	public User merge(User entity) {
		return (User) getCurrentSession().merge(entity);
	}
	public Review merge(Review entity) {
		return (Review) getCurrentSession().merge(entity);
	}
	public PlaceVisited merge(PlaceVisited entity) {
		return (PlaceVisited) getCurrentSession().merge(entity);
	}

	public User findUserById(String id) {
		User book = (User) getCurrentSession().get(User.class, id);
		return book; 
	}
	public Review findReviewById(String id) {
		Review book = (Review) getCurrentSession().get(Review.class, id);
		return book; 
	}
	public PlaceVisited findPlaceVisitedById(String id) {
		PlaceVisited book = (PlaceVisited) getCurrentSession().get(PlaceVisited.class, id);
		return book; 
	}

	public void delete(User entity) {
		getCurrentSession().delete(entity);
	}
	public void delete(Review entity) {
		getCurrentSession().delete(entity);
	}
	public void delete(PlaceVisited entity) {
		getCurrentSession().delete(entity);
	}

}
