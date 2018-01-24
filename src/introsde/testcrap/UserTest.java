package introsde.testcrap;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import introsde.APP3.users.persistence.dao.PlaceVisitedPersistencyService;
import introsde.APP3.users.persistence.dao.UserPersistencyService;
import introsde.APP3.users.persistence.entities.PlaceVisited;
import introsde.APP3.users.persistence.entities.User;

public class UserTest {

		@Test
		public void testFullRun() {
			testAddUser();
			testAddPlace();
			testSearchPlace();
			remove();
		}
		public void testAddUser() {		
			User u = new User();
			u.setFirst_name("USER");
			u.setId(1);
			UserPersistencyService.saveUser(u);
			u = UserPersistencyService.getUserById(1);
			assertEquals("USER", u.getFirst_name());
		}
		
		public void testAddPlace() {
			User u = UserPersistencyService.getUserById(1);
			
			PlaceVisited p = new PlaceVisited();
			p.setId_park(2000);
			p.setVote(1);
			u.getPlaces().add(p);
			UserPersistencyService.updateUser(u);
			u = UserPersistencyService.getUserById(1);
			assertEquals(1, u.getPlaces().size());
			ArrayList<PlaceVisited> pp = new ArrayList<PlaceVisited>(u.getPlaces());
			assertEquals((int) 2000, (int) pp.get(0).getId_park());
		}
		
		public void testSearchPlace() {
			ArrayList<PlaceVisited> ppp = new ArrayList<>(PlaceVisitedPersistencyService.getAllPlacesVisitedForPark(2000));
			assertEquals(1,ppp.size());
			assertEquals((int)2000, (int)ppp.get(0).getId_park());
			assertEquals((int)1, (int)ppp.get(0).getVote());
			
		}
		
		public void remove() {
			User u = UserPersistencyService.getUserById(1);
			
			UserPersistencyService.removeUser(u);
		}
}
