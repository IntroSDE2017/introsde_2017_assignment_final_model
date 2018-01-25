package introsde.APP2.sheds.persistence.dao;

import java.util.List;

import introsde.APP2.sheds.persistence.entities.Shed;

public class ShedPersistencyService {
	private static ShedsDAO bookDao;

	public static Shed saveShed(Shed entity) {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return entity;
	}

	public static Shed updateShed(Shed entity) {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSessionwithTransaction();
		Shed newEntity = bookDao.merge(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removeShed(Shed p) {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static Shed getShedById(int id) {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSession();
		Shed book = (Shed) bookDao.getCurrentSession().get(Shed.class, id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public static List<Shed> getAllSheds() {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSession();
		List<Shed> books = (List<Shed>) bookDao.getCurrentSession().createQuery("from Shed").list();
		bookDao.closeCurrentSession();
		return books;
	}

	public static List<Shed> getShedsByName(String name) {
		bookDao = new ShedsDAO();
		bookDao.openCurrentSession();
		List<Shed> books = (List<Shed>) bookDao.getCurrentSession().createQuery("from Shed p WHERE p.comune LIKE '%"+name+"%' OR p.localita LIKE '%"+name+"%' OR p.nome LIKE '%"+name+"%'").list();
		bookDao.closeCurrentSession();
		return books;
	}
}
