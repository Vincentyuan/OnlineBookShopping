package cose.seu.entity;

import java.io.Serializable;
import java.sql.Date;

public class ShoppingList implements Serializable {



	public ShoppingList(Long bnumber, ShoppingCart shoppingcart, java.util.Date aTime,
			cose.seu.entity.Book book) {
		super();
		Bnumber = bnumber;
		this.shoppingcart = shoppingcart;
		ATime = aTime;
		this.book = book;
	}

	public ShoppingList() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	
	private Long SLID;//购物车条目编号
	private Long Bnumber;//书籍数量
	private ShoppingCart shoppingcart;
	private java.util.Date ATime;//商品添加时间
	
	private Book book;//书目类

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ATime == null) ? 0 : ATime.hashCode());
		result = prime * result + ((Bnumber == null) ? 0 : Bnumber.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((SLID == null) ? 0 : SLID.hashCode());
		result = prime * result
				+ ((shoppingcart == null) ? 0 : shoppingcart.hashCode());
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
		ShoppingList other = (ShoppingList) obj;
		if (ATime == null) {
			if (other.ATime != null)
				return false;
		} else if (!ATime.equals(other.ATime))
			return false;
		if (Bnumber == null) {
			if (other.Bnumber != null)
				return false;
		} else if (!Bnumber.equals(other.Bnumber))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (SLID == null) {
			if (other.SLID != null)
				return false;
		} else if (!SLID.equals(other.SLID))
			return false;
		if (shoppingcart == null) {
			if (other.shoppingcart != null)
				return false;
		} else if (!shoppingcart.equals(other.shoppingcart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingList [SLID=" + SLID + ", Bnumber=" + Bnumber
				+ ", shoppingcart=" + shoppingcart + ", ATime=" + ATime
				+ ", Book=" + book + "]";
	}

	public Long getSLID() {
		return SLID;
	}

	public void setSLID(Long sLID) {
		SLID = sLID;
	}

	public Long getBnumber() {
		return Bnumber;
	}

	public void setBnumber(Long bnumber) {
		Bnumber = bnumber;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public java.util.Date getATime() {
		return ATime;
	}

	public void setATime(java.util.Date aTime) {
		ATime = aTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	

}
