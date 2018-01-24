package introsde.APP3.users.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Preferences")
public class Preference implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;								// ID is automatically generated
	
	private Boolean preferenceParks;
	private Boolean preferenceSheds;
	
	public Boolean getPreferenceParks() {
		return preferenceParks;
	}
	public void setPreferenceParks(Boolean preferenceParks) {
		this.preferenceParks = preferenceParks;
	}
	public Boolean getPreferenceSheds() {
		return preferenceSheds;
	}
	public void setPreferenceSheds(Boolean preferenceSheds) {
		this.preferenceSheds = preferenceSheds;
	}
	
	
}
