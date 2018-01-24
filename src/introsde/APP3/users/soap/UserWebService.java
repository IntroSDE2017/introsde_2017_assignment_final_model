package introsde.APP3.users.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.Review;
import introsde.APP3.users.persistence.entities.User;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface UserWebService{
    @WebMethod String getHelloWorldAsString(String name);

	@WebMethod List<User> getUserList();
	@WebMethod User addUser(User user);
	@WebMethod User updateUser(User user);
	@WebMethod User getUserById(String id);
	@WebMethod boolean userPreferParks(String id);
	@WebMethod boolean userPreferSheds(String id);
	@WebMethod void setUserPreference(String id, boolean parks, boolean sheds);
	
	@WebMethod List<Review> getReviewList();
	@WebMethod List<Review> getReviewsOfUser(String userID);
	@WebMethod List<Review> getReviewsOfPark(Integer parkID);
	@WebMethod List<Review> getReviewsOfShed(Integer shedID);
	@WebMethod void addReview(Review review, String userID);
	@WebMethod Review updateReview(Review review);
	@WebMethod Review getReviewById(Integer id);
	
	@WebMethod List<PlaceVisited> getPlaceVisitedList();
	@WebMethod List<PlaceVisited> getPlacesVisitedOfUser(String userID);
	@WebMethod List<PlaceVisited> getPlacesVisitedOfPark(Integer parkID);
	@WebMethod List<PlaceVisited> getPlacesVisitedOfShed(Integer shedID);
	@WebMethod void addPlaceVisited(PlaceVisited place, String userID);
	@WebMethod PlaceVisited updatePlaceVisited(PlaceVisited place);
	@WebMethod PlaceVisited getPlaceVisitedById(Integer id);
	
}