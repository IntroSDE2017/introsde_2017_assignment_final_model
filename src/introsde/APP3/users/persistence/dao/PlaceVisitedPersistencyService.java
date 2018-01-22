package introsde.APP3.users.persistence.dao;
import java.util.List;
import java.util.Set;

import introsde.APP3.users.persistence.entities.PlaceVisited;

public class PlaceVisitedPersistencyService {
	private static UsersDAO bookDao;

	public static PlaceVisited savePlaceVisited(PlaceVisited entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		PlaceVisited p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static PlaceVisited updatePlaceVisited(PlaceVisited entity) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		PlaceVisited newEntity = bookDao.merge(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removePlaceVisited(PlaceVisited p) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static PlaceVisited getPlaceVisitedById(int id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		PlaceVisited book = (PlaceVisited) bookDao.getCurrentSession().get(PlaceVisited.class, id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public static List<PlaceVisited> getAllPlacesVisited() {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited").list();
		bookDao.closeCurrentSession();
		return books;
	}
	
	public static List<PlaceVisited> getAllPlacesVisitedForPark(Integer id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited where id_park='"+id+"'").list();
		bookDao.closeCurrentSession();
		return books;
	}
	
	public static List<PlaceVisited> getAllPlacesVisitedForShed(Integer id) {
		bookDao = new UsersDAO();
		bookDao.openCurrentSession();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited where id_shed='"+id+"'").list();
		bookDao.closeCurrentSession();
		return books;
	}
}