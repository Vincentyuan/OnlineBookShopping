package cose.seu.entity;

import java.io.Serializable;
import java.util.Set;

import cose.seu.dao.ShoppingCartDao;

public class ShoppingCart implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	
	private Long SCID;
	
	private UserInfo User;
	
	private Set<ShoppingList> shoppinglist;

	public ShoppingCart(UserInfo user, Set<ShoppingList> shoppinglist) {
		super();
		User = user;
		this.shoppinglist = shoppinglist;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo getUser() {
		return User;
	}

	public void setUser(UserInfo user) {
		User = user;
	}

	public Set<ShoppingList> getShoppinglist() {
		return shoppinglist;
	}

	public void setShoppinglist(Set<ShoppingList> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}


	public Long getSCID() {
		return SCID;
	}

	public void setSCID(Long sCID) {
		SCID = sCID;
	}

	@Override
	public String toString() {
		return "ShoppingCart [SCID=" + SCID + ", User=" + User
				+ ", shoppinglist=" + shoppinglist + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (SCID == null) {
			if (other.SCID != null)
				return false;
		} else if (!SCID.equals(other.SCID))
			return false;
		if (User == null) {
			if (other.User != null)
				return false;
		} else if (!User.equals(other.User))
			return false;
		if (shoppinglist == null) {
			if (other.shoppinglist != null)
				return false;
		} else if (!shoppinglist.equals(other.shoppinglist))
			return false;
		return true;
	}


	

	

}
