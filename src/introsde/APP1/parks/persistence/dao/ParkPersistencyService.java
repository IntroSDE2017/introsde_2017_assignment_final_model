package introsde.APP1.parks.persistence.dao;

import java.util.List;

import introsde.APP1.parks.persistence.entities.Park;

public class ParkPersistencyService {
	private static ParksDAO bookDao;

	public static Park savePark(Park entity) {
		bookDao = new ParksDAO();
		bookDao.openCurrentSessionwithTransaction();
		Park p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static Park updatePark(Park entity) {
		bookDao = new ParksDAO();
		bookDao.openCurrentSessionwithTransaction();
		Park newEntity = bookDao.merge(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removePark(Park p) {
		bookDao = new ParksDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static Park getParkById(int id) {
		bookDao = new ParksDAO();
		bookDao.openCurrentSession();
		Park book = (Park) bookDao.getCurrentSession().get(Park.class, id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public static List<Park> getAllParks() {
		bookDao = new ParksDAO();
		bookDao.openCurrentSession();
		List<Park> books = (List<Park>) bookDao.getCurrentSession().createQuery("from Park").list();
		bookDao.closeCurrentSession();
		return books;
	}

	public static List<Park> getAllParksWithName(String name) {
		bookDao = new ParksDAO();
		bookDao.openCurrentSession();
		List<Park> books = (List<Park>) bookDao.getCurrentSession().createQuery("from Park p WHERE p.nome LIKE '%"+name+"%' OR p.comuni LIKE '%"+name+"%'").list();
		bookDao.closeCurrentSession();
		return books;
	}
}
