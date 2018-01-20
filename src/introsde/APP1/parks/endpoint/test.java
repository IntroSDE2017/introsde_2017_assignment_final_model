package introsde.APP1.parks.endpoint;


import introsde.APP1.parks.persistence.dao.ParkPersistencyService;
import introsde.APP1.parks.persistence.entities.Park;

public class test {

	public static void main(String[] args) {
		Park p = new Park();
		p.setNome("ESEMPIO");
		p.setParco("PARKO1");
		System.out.println(ParkPersistencyService.savePark(p));
	}

}
