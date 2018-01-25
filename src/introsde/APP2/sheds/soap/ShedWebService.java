package introsde.APP2.sheds.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.APP2.sheds.persistence.entities.Shed;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface ShedWebService{
	@WebMethod List<Shed> getShedList();
	@WebMethod Shed addShed(Shed Shed);
	@WebMethod Shed updateShed(Shed Shed);
	@WebMethod Shed getShedById(Integer id);
	@WebMethod List<Shed> getShedByName(String name);
}