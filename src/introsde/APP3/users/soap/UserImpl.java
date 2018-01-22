package introsde.APP3.users.soap;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import introsde.APP3.users.persistence.dao.UserPersistencyService;
import introsde.APP3.users.persistence.dao.ReviewPersistencyService;
import introsde.APP3.users.persistence.dao.PlaceVisitedPersistencyService;
import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.Review;
import introsde.APP3.users.persistence.entities.User;


//Service Implementation
@WebService(endpointInterface = "introsde.APP3.users.soap.UserWebService")
public class UserImpl implements UserWebService{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public List<User> getUserList() {
		List<User> personList = UserPersistencyService.getAllUsers();
		return personList;
	}

	@Override
	public User addUser(User item) {
		item.setId(null);
		return UserPersistencyService.saveUser(item);
	}

	@Override
	public User updateUser(User item) {
		if(UserPersistencyService.getUserById(item.getId()) != null) {
			return UserPersistencyService.updateUser(item);
		}
		throw new IllegalArgumentException("User with id "+item.getId()+" not found");
	}

	@Override
	public User getUserById(String id) {
		User item = UserPersistencyService.getUserById(id);
		if( item==null ) {
			throw new IllegalArgumentException("User with id "+id+" not found");
		}
		return item;
	}

	@Override
	public List<Review> getReviewList() {
		List<Review> personList = ReviewPersistencyService.getAllReviews();
		return personList;
	}

	@Override
	public List<Review> getReviewsOfUser(String userID) {
		User user = getUserById(userID);
		return new ArrayList<Review>(user.getReviews());
	}

	@Override
	public List<Review> getReviewsOfPark(Integer parkID) {
		return ReviewPersistencyService.getAllReviewsForPark(parkID);
	}

	@Override
	public List<Review> getReviewsOfShed(Integer shedID) {
		return ReviewPersistencyService.getAllReviewsForShed(shedID);
	}

	@Override
	public void addReview(Review review, String userID) {
		User user = getUserById(userID);
		user.getReviews().add(review);
		UserPersistencyService.updateUser(user);
	}

	@Override
	public Review updateReview(Review review) {
		return ReviewPersistencyService.updateReview(review);
	}

	@Override
	public Review getReviewById(Integer id) {
		Review item = ReviewPersistencyService.getReviewById(id);
		if( item==null ) {
			throw new IllegalArgumentException("Review with id "+id+" not found");
		}
		return item;
	}

	@Override
	public List<PlaceVisited> getPlaceVisitedList() {
		List<PlaceVisited> itemList = PlaceVisitedPersistencyService.getAllPlacesVisited();
		return itemList;
	}

	@Override
	public List<PlaceVisited> getPlacesVisitedOfUser(String userID) {
		User user = getUserById(userID);
		return new ArrayList<PlaceVisited>(user.getPlaces());
	}

	@Override
	public void addPlaceVisited(PlaceVisited place, String userID) {
		User user = getUserById(userID);
		user.getPlaces().add(place);
		UserPersistencyService.updateUser(user);
	}

	@Override
	public PlaceVisited updatePlaceVisited(PlaceVisited place) {
		return PlaceVisitedPersistencyService.updatePlaceVisited(place);
	}

	@Override
	public PlaceVisited getPlaceVisitedById(Integer id) {
		PlaceVisited item = PlaceVisitedPersistencyService.getPlaceVisitedById(id);
		if( item==null ) {
			throw new IllegalArgumentException("Visit with id "+id+" not found");
		}
		return item;
	}

	@Override
	public List<PlaceVisited> getPlacesVisitedOfPark(Integer parkID) {
		return PlaceVisitedPersistencyService.getAllPlacesVisitedForPark(parkID);
	}

	@Override
	public List<PlaceVisited> getPlacesVisitedOfShed(Integer shedID) {
		return PlaceVisitedPersistencyService.getAllPlacesVisitedForShed(shedID);
	}
	
}