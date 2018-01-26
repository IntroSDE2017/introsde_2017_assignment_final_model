package introsde.APP3.users.persistence.dao;
import java.util.List;

import introsde.APP3.users.persistence.entities.User;

public class UserPersistencyService {
	private static UsersDAO bookDao;

	public static User saveUser(User entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		User p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static User updateUser(User entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.update(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return entity;
	}
	
	public static void removeUser(User p) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static User getUserById(Integer id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		User book = (User) bookDao.getCurrentSession().get(User.class, id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public static List<User> getAllUsers() {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<User> books = (List<User>) bookDao.getCurrentSession().createQuery("from User").list();
		bookDao.closeCurrentSession();
		return books;
	}

	public static List<User> getUserByName(String name) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<User> books = (List<User>) bookDao.getCurrentSession().createQuery("from User p WHERE p.first_name LIKE '%"+name+"%' OR p.username LIKE '%"+name+"%' ").list();
		bookDao.closeCurrentSession();
		return books;
	}
}