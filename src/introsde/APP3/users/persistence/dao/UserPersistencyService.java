package introsde.APP3.users.persistence.dao;
import java.util.List;

import introsde.APP3.users.persistence.entities.User;

public class UserPersistencyService {
	private static UsersDAO bookDao;

	public static User saveUser(User entity) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		User p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static User updateUser(User entity) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.update(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return entity;
	}
	
	public static void removeUser(User p) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static User getUserById(Integer id) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		User book = (User) bookDao.getCurrentSession().get(User.class, id);
		bookDao.closeCurrentSessionwithTransaction();
		return book;
	}
	
	public static List<User> getAllUsers() {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		List<User> books = (List<User>) bookDao.getCurrentSession().createQuery("from User").list();
		bookDao.closeCurrentSessionwithTransaction();
		return books;
	}

	public static List<User> getUserByName(String name) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		List<User> books = (List<User>) bookDao.getCurrentSession().createQuery("from User p WHERE lower(p.first_name) LIKE '%"+name.toLowerCase()+"%' OR lower(p.username) LIKE '%"+name.toLowerCase()+"%' ").list();
		bookDao.closeCurrentSessionwithTransaction();
		return books;
	}
}