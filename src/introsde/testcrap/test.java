package introsde.testcrap;


import java.util.ArrayList;
import java.util.List;

import introsde.APP1.parks.persistence.dao.ParkPersistencyService;
import introsde.APP1.parks.persistence.entities.Park;
import introsde.APP3.users.persistence.dao.PlaceVisitedPersistencyService;
import introsde.APP3.users.persistence.dao.UserPersistencyService;
import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.User;

public class test {

	public static void main(String[] args) {
		System.out.println( ParkPersistencyService.getAllParks() );
		System.out.println( ParkPersistencyService.getAllParks() );
		System.out.println( ParkPersistencyService.getAllParks() );
		System.out.println( ParkPersistencyService.getAllParksWithName("stelvio") );
		System.out.println( ParkPersistencyService.getAllParksWithName("stelvio") );
		System.out.println( ParkPersistencyService.getAllParksWithName("stelvio") );
//      \copy parks (id,parco,nome,superficie,provvedimento,comuni,elencoufficiale,altreinformazioni,indirizzo,gestore,provincie,email) FROM '/home/dallatorre/IntroSDEProjects/FinalProject_Server1/src/DBparks-Aligned.csv' DELIMITER ',' CSV HEADER
//		\copy sheds (id,nome,localita,comune,settore_alpino,web,anno,quota,letti,cuccette,tavolato,invernale,tipologia,regione) FROM '/home/dallatorre/IntroSDEProjects/FinalProject_Server1/src/Rifugi-Bivacchi-Aligned.csv' DELIMITER ',' CSV HEADER
	}

}
