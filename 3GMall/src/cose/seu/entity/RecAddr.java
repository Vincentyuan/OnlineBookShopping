package cose.seu.entity;

import java.io.Serializable;

public class RecAddr implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;


	private Long AID;
	private String RecName;
	private Long RecPhone;
	private Long Postcode;
	private String Street;
	private City Province;
	private City City;
	private UserInfo User;
	public RecAddr(Long aID, String recName, Long recPhone, Long postcode,
			String street, cose.seu.entity.City province,
			cose.seu.entity.City city, UserInfo user) {
		super();
		AID = aID;
		RecName = recName;
		RecPhone = recPhone;
		Postcode = postcode;
		Street = street;
		Province = province;
		City = city;
		User = user;
	}
	public RecAddr() {
		// TODO Auto-generated constructor stub
	}
	public Long getAID() {
		return AID;
	}
	public void setAID(Long aID) {
		AID = aID;
	}
	public String getRecName() {
		return RecName;
	}
	public void setRecName(String recName) {
		RecName = recName;
	}
	public Long getRecPhone() {
		return RecPhone;
	}
	public void setRecPhone(Long recPhone) {
		RecPhone = recPhone;
	}
	public Long getPostcode() {
		return Postcode;
	}
	public void setPostcode(Long postcode) {
		Postcode = postcode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public City getProvince() {
		return Province;
	}
	public void setProvince(City province) {
		Province = province;
	}
	public City getCity() {
		return City;
	}
	public void setCity(City city) {
		City = city;
	}
	public UserInfo getUser() {
		return User;
	}
	public void setUser(UserInfo user) {
		User = user;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecAddr other = (RecAddr) obj;
		if (AID == null) {
			if (other.AID != null)
				return false;
		} else if (!AID.equals(other.AID))
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (Postcode == null) {
			if (other.Postcode != null)
				return false;
		} else if (!Postcode.equals(other.Postcode))
			return false;
		if (Province == null) {
			if (other.Province != null)
				return false;
		} else if (!Province.equals(other.Province))
			return false;
		if (RecName == null) {
			if (other.RecName != null)
				return false;
		} else if (!RecName.equals(other.RecName))
			return false;
		if (RecPhone == null) {
			if (other.RecPhone != null)
				return false;
		} else if (!RecPhone.equals(other.RecPhone))
			return false;
		if (Street == null) {
			if (other.Street != null)
				return false;
		} else if (!Street.equals(other.Street))
			return false;
		if (User == null) {
			if (other.User != null)
				return false;
		} else if (!User.equals(other.User))
			return false;
		return true;
	}
	

}
