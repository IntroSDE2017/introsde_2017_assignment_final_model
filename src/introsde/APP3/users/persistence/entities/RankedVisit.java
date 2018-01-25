package introsde.APP3.users.persistence.entities;

import java.io.Serializable;

public class RankedVisit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer sum;
	private Integer id_park;
	private Integer id_shed;
	
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
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
	
}
