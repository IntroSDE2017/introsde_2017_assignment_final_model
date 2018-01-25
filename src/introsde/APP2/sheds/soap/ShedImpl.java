package introsde.APP2.sheds.soap;

import java.util.List;

import javax.jws.WebService;

import introsde.APP2.sheds.persistence.dao.ShedPersistencyService;
import introsde.APP2.sheds.persistence.entities.Shed;

//Service Implementation
@WebService(endpointInterface = "introsde.APP2.sheds.soap.ShedWebService")
public class ShedImpl implements ShedWebService{

	@Override
	public List<Shed> getShedList() {
		List<Shed> personList = ShedPersistencyService.getAllSheds();
		return personList;
	}

	@Override
	public Shed addShed(Shed Shed) {
		Shed.setId(null);
		return ShedPersistencyService.saveShed(Shed);
	}

	@Override
	public Shed updateShed(Shed Shed) {
		if(ShedPersistencyService.getShedById(Shed.getId()) != null) {
			return ShedPersistencyService.updateShed(Shed);
		}
		throw new IllegalArgumentException("Shed with id "+Shed.getId()+" not found");
	}

	@Override
	public Shed getShedById(Integer id) {
		Shed Shed = ShedPersistencyService.getShedById(id);
		if( Shed==null ) {
			throw new IllegalArgumentException("Shed with id "+id+" not found");
		}
		return Shed;
	}

	@Override
	public List<Shed> getShedByName(String name) {
		List<Shed> personList = ShedPersistencyService.getShedsByName(name);
		return personList;
	}
	
}