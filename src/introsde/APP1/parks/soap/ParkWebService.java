package introsde.APP1.parks.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.APP1.parks.persistence.entities.Park;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface ParkWebService{
    @WebMethod String getHelloWorldAsString(String name);

	@WebMethod List<Park> getParkList();
	@WebMethod Park addPark(Park park);
	@WebMethod Park updatePark(Park park);
	@WebMethod Park getParkById(Integer id);
	@WebMethod List<Park> getParkByName(String name);
}