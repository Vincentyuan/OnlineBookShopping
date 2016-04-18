package cose.seu.entity;

import java.io.Serializable;
import java.util.Date;

public class Favorite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	public Favorite(Long fID, UserInfo user, Book book, Date favDate) {
		super();
		FID = fID;
		this.user = user;
		this.book= book;
		FavDate = favDate;
	}
	public Favorite(){
		
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	private Long FID;
	private UserInfo user;
	private Book book;
	private Date FavDate;
	public Long getFID() {
		return FID;
	}
	public void setFID(Long fID) {
		FID = fID;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getFavDate() {
		return FavDate;
	}
	public void setFavDate(Date favDate) {
		FavDate = favDate;
	}
	
}
