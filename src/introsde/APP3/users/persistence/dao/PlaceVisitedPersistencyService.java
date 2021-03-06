package introsde.APP3.users.persistence.dao;
import java.util.ArrayList;
import java.util.List;

import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.RankedVisit;

public class PlaceVisitedPersistencyService {
	private static UsersDAO bookDao;

	public static PlaceVisited savePlaceVisited(PlaceVisited entity) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		PlaceVisited p = bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return p;
	}

	public static PlaceVisited updatePlaceVisited(PlaceVisited entity) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		PlaceVisited newEntity = bookDao.merge(entity);
		bookDao.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removePlaceVisited(PlaceVisited p) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		bookDao.delete(p);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public static PlaceVisited getPlaceVisitedById(int id) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		PlaceVisited book = (PlaceVisited) bookDao.getCurrentSession().get(PlaceVisited.class, id);
		bookDao.closeCurrentSessionwithTransaction();
		return book;
	}
	
	public static List<PlaceVisited> getAllPlacesVisited() {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited").list();
		bookDao.closeCurrentSessionwithTransaction();
		return books;
	}
	
	public static List<PlaceVisited> getAllPlacesVisitedForPark(Integer id) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited where id_park='"+id+"'").list();
		bookDao.closeCurrentSessionwithTransaction();
		return books;
	}
	
	public static List<PlaceVisited> getAllPlacesVisitedForShed(Integer id) {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		List<PlaceVisited> books = (List<PlaceVisited>) bookDao.getCurrentSession().createQuery("from PlaceVisited where id_shed='"+id+"'").list();
		bookDao.closeCurrentSessionwithTransaction();
		return books;
	}
	
	public static List<RankedVisit> getMostRatedVisits() {
		bookDao = UsersDAO.getInstance();
		bookDao.openCurrentSessionwithTransaction();
		
		List<Object[]> books = (List<Object[]>) bookDao.getCurrentSession().createQuery("SELECT SUM(v.vote) as sum, v.id_park as id_park, v.id_shed as id_shed FROM PlaceVisited v GROUP BY id_park, id_shed ORDER BY SUM(v.vote) DESC").list();
		
		List<RankedVisit> result = new ArrayList<RankedVisit>();
		for (Object[] aRow : books) {
			RankedVisit visit = new RankedVisit();
			visit.setSum( ((Long)aRow[0]).intValue() );
			visit.setId_park((Integer)aRow[1]); 
			visit.setId_shed((Integer)aRow[2]); 
			result.add(visit);
		}
		bookDao.closeCurrentSessionwithTransaction();
		return result;
	}
}