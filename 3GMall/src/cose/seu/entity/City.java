package cose.seu.entity;

import java.io.Serializable;

public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long citId;
	private String citName;
	private Long citParent;
	public City(Long citId, String citName, Long citParent) {
		super();
		this.citId = citId;
		this.citName = citName;
		this.citParent = citParent;
	}
	public City() {
		// TODO Auto-generated constructor stub
	}
	public Long getCitId() {
		return citId;
	}
	public void setCitId(Long citId) {
		this.citId = citId;
	}
	public String getCitName() {
		return citName;
	}
	public void setCitName(String citName) {
		this.citName = citName;
	}
	public Long getCitParent() {
		return citParent;
	}
	public void setCitParent(Long citParent) {
		this.citParent = citParent;
	}
	@Override
	public String toString() {
		return "City [citId=" + citId + ", citName=" + citName + ", citParent="
				+ citParent + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citId == null) ? 0 : citId.hashCode());
		result = prime * result + ((citName == null) ? 0 : citName.hashCode());
		result = prime * result
				+ ((citParent == null) ? 0 : citParent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (citId == null) {
			if (other.citId != null)
				return false;
		} else if (!citId.equals(other.citId))
			return false;
		if (citName == null) {
			if (other.citName != null)
				return false;
		} else if (!citName.equals(other.citName))
			return false;
		if (citParent == null) {
			if (other.citParent != null)
				return false;
		} else if (!citParent.equals(other.citParent))
			return false;
		return true;
	}
	
	

}
