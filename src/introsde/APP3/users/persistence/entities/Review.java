package introsde.APP3.users.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;								// ID is automatically generated

	private Integer id_park;
    private Integer id_shed;
    private Integer vote;
    private Date date;
	@Column(columnDefinition="text")
    private String review;
	@Column(columnDefinition="text")
    private String weather;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_park() {
		return id_park;
	}
	public void setId_park(Integer id_park) {
		this.id_park = id_park;
	}
	public Integer getId_shed() {
		return id_shed;
	}
	public void setId_shed(Integer id_shed) {
		this.id_shed = id_shed;
	}
	public Integer getVote() {
		return vote;
	}
	public void setVote(Integer vote) {
		this.vote = vote;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
    
}
