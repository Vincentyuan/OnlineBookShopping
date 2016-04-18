package cose.seu.entity;

import java.io.Serializable;

public class Credit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long CCID;
	private UserInfo user;
	private Long creNumber;
	public Credit(Long cCID, UserInfo user, Long creNumber) {
		super();
		CCID = cCID;
		this.user = user;
		this.creNumber = creNumber;
	}
	public Credit() {
		// TODO Auto-generated constructor stub
	}
	public Long getCCID() {
		return CCID;
	}
	public void setCCID(Long cCID) {
		CCID = cCID;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Long getCreNumber() {
		return creNumber;
	}
	public void setCreNumber(Long creNumber) {
		this.creNumber = creNumber;
	}
	@Override
	public String toString() {
		return "Credit [CCID=" + CCID + ", user=" + user + ", creNumber="
				+ creNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CCID == null) ? 0 : CCID.hashCode());
		result = prime * result
				+ ((creNumber == null) ? 0 : creNumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Credit other = (Credit) obj;
		if (CCID == null) {
			if (other.CCID != null)
				return false;
		} else if (!CCID.equals(other.CCID))
			return false;
		if (creNumber == null) {
			if (other.creNumber != null)
				return false;
		} else if (!creNumber.equals(other.creNumber))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
