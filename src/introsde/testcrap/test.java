package introsde.testcrap;


import introsde.APP1.parks.persistence.dao.ParkPersistencyService;
import introsde.APP1.parks.persistence.entities.Park;

public class test {

	public static void main(String[] args) {
		Park p = new Park();
		p.setNome("ESEMPIO");
		p.setParco("PARKO1");
		p = ParkPersistencyService.savePark(p);
		System.out.println(p.getNome() + p.getParco() + p.getId());
		ParkPersistencyService.removePark(p);
		
//      \copy parks (id,parco,nome,superficie,provvedimento,comuni,elencoufficiale,altreinformazioni,indirizzo,gestore,provincie,email) FROM '/home/dallatorre/IntroSDEProjects/FinalProject_Server1/src/DBparks-Aligned.csv' DELIMITER ',' CSV HEADER
	}

}
