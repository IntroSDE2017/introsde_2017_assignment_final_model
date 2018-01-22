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
		List<Park> personList = ParkPersistencyService.getAllParks();
		return personList;
	}

	@Override
	public Park addPark(Park park) {
		park.setId(null);
		return ParkPersistencyService.savePark(park);
	}

	@Override
	public Park updatePark(Park park) {
		if(ParkPersistencyService.getParkById(park.getId()) != null) {
			return ParkPersistencyService.updatePark(park);
		}
		throw new IllegalArgumentException("Park with id "+park.getId()+" not found");
	}

	@Override
	public Park getParkById(Integer id) {
		Park park = ParkPersistencyService.getParkById(id);
		if( park==null ) {
			throw new IllegalArgumentException("Park with id "+id+" not found");
		}
		return park;
	}
	
}

