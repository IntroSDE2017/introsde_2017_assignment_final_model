package introsde.APP1.parks.soap;

import java.util.List;

import javax.jws.WebService;

import introsde.APP1.parks.persistence.dao.ParkPersistencyService;
import introsde.APP1.parks.persistence.entities.Park;

//Service Implementation
@WebService(endpointInterface = "introsde.APP1.parks.soap.ParkWebService")
public class ParkImpl implements ParkWebService{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public List<Park> getParkList() {
		List<Park> personList = ParkPersistencyService.getAllParks();		// GET all the person in DB and create the people wrapper
		return personList;
	}
	
}

