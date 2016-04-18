package cose.seu.entity;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	UserInfo User;
	private Book ComBook;
	private Date ComDate;
	private String Comments;
	private String ComLevel;
	private Long CID;
	public Comments(UserInfo user, Book comBook, Date comDate, String comments,
			String comLevel, Long cID) {
		super();
		User = user;
		ComBook = comBook;
		ComDate = comDate;
		Comments = comments;
		ComLevel = comLevel;
		CID = cID;
	}
	public Comments() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo getUser() {
		return User;
	}
	public void setUser(UserInfo user) {
		User = user;
	}
	public Book getComBook() {
		return ComBook;
	}
	public void setComBook(Book comBook) {
		ComBook = comBook;
	}
	public Date getComDate() {
		return ComDate;
	}
	public void setComDate(Date comDate) {
		ComDate = comDate;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getComLevel() {
		return ComLevel;
	}
	public void setComLevel(String comLevel) {
		ComLevel = comLevel;
	}
	public Long getCID() {
		return CID;
	}
	public void setCID(Long cID) {
		CID = cID;
	}
	@Override
	public String toString() {
		return "Comments [User=" + User + ", ComBook=" + ComBook + ", ComDate="
				+ ComDate + ", Comments=" + Comments + ", ComLevel=" + ComLevel
				+ ", CID=" + CID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CID == null) ? 0 : CID.hashCode());
		result = prime * result + ((ComBook == null) ? 0 : ComBook.hashCode());
		result = prime * result + ((ComDate == null) ? 0 : ComDate.hashCode());
		result = prime * result
				+ ((ComLevel == null) ? 0 : ComLevel.hashCode());
		result = prime * result
				+ ((Comments == null) ? 0 : Comments.hashCode());
		result = prime * result + ((User == null) ? 0 : User.hashCode());
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
		Comments other = (Comments) obj;
		if (CID == null) {
			if (other.CID != null)
				return false;
		} else if (!CID.equals(other.CID))
			return false;
		if (ComBook == null) {
			if (other.ComBook != null)
				return false;
		} else if (!ComBook.equals(other.ComBook))
			return false;
		if (ComDate == null) {
			if (other.ComDate != null)
				return false;
		} else if (!ComDate.equals(other.ComDate))
			return false;
		if (ComLevel == null) {
			if (other.ComLevel != null)
				return false;
		} else if (!ComLevel.equals(other.ComLevel))
			return false;
		if (Comments == null) {
			if (other.Comments != null)
				return false;
		} else if (!Comments.equals(other.Comments))
			return false;
		if (User == null) {
			if (other.User != null)
				return false;
		} else if (!User.equals(other.User))
			return false;
		return true;
	}


}
