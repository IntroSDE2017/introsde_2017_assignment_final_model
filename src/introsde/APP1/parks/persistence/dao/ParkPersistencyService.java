package introsde.APP1.parks.persistence.dao;

import java.util.List;

import introsde.APP1.parks.persistence.entities.Park;

public class ParkPersistencyService {
	private static ParksDAO parkDAO;

	public static Park savePark(Park entity) {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		Park p = parkDAO.persist(entity);
		parkDAO.closeCurrentSessionwithTransaction();
		return p;
	}

	public static Park updatePark(Park entity) {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		Park newEntity = parkDAO.merge(entity);
		parkDAO.closeCurrentSessionwithTransaction();
		return newEntity;
	}
	
	public static void removePark(Park p) {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		parkDAO.delete(p);
		parkDAO.closeCurrentSessionwithTransaction();
	}
	
	public static Park getParkById(int id) {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		Park book = (Park) parkDAO.getCurrentSession().get(Park.class, id);
		parkDAO.closeCurrentSessionwithTransaction();
		return book;
	}
	
	public static List<Park> getAllParks() {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		List<Park> books = (List<Park>) parkDAO.getCurrentSession().createQuery("from Park").list();
		parkDAO.closeCurrentSessionwithTransaction();
		return books;
	}

	public static List<Park> getAllParksWithName(String name) {
		parkDAO = ParksDAO.getInstance();
		parkDAO.openCurrentSessionwithTransaction();
		List<Park> books = (List<Park>) parkDAO.getCurrentSession().createQuery("from Park p WHERE lower(p.nome) LIKE '%"+name.toLowerCase()+"%' OR lower(p.comuni) LIKE '%"+name.toLowerCase()+"%'").list();
		parkDAO.closeCurrentSessionwithTransaction();
		return books;
	}
}
