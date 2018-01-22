package introsde.APP3.users.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private String id;								// ID is automatically generated
    
    private String first_name;
    private String username;
    private Date registerDate;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Review> reviews;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<PlaceVisited> places;
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	public Set<PlaceVisited> getPlaces() {
		return places;
	}
	public void setPlaces(Set<PlaceVisited> places) {
		this.places = places;
	}
    
		
}

