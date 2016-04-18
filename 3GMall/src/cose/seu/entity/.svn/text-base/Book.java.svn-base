
package cose.seu.entity;
import java.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.Data;

public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private Long BID;
	private String bName;
	private String publisher;
	private float price;
	private Long stoNumber;
	private String summary;
	private Date pTime;
	private Type type;
	private String face;
	private Date inTime;
	private Long salNumber;
	private String comAveLevel;
	private float vipPrice;
	private Long comNumber;
	private String author;	
	private Set<Comments> comments;
	
	public Book(Long bID, String bName, String publisher, float price,
			Long stoNumber, String summary, Date pTime, Type type, String face,
			Date inTime, Long salNumber, String comAveLevel, float vipPrice,
			Long comNumber, String author, Set<Comments> comments) {
		super();
		BID = bID;
		this.bName = bName;
		this.publisher = publisher;
		this.price = price;
		this.stoNumber = stoNumber;
		this.summary = summary;
		this.pTime = pTime;
		this.type = type;
		this.face = face;
		this.inTime = inTime;
		this.salNumber = salNumber;
		this.comAveLevel = comAveLevel;
		this.vipPrice = vipPrice;
		this.comNumber = comNumber;
		this.author = author;
		this.comments = comments;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Long getBID() {
		return BID;
	}

	public void setBID(Long bID) {
		BID = bID;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Long getStoNumber() {
		return stoNumber;
	}

	public void setStoNumber(Long stoNumber) {
		this.stoNumber = stoNumber;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getpTime() {
		return pTime;
	}

	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Long getSalNumber() {
		return salNumber;
	}

	public void setSalNumber(Long salNumber) {
		this.salNumber = salNumber;
	}

	public String getComAveLevel() {
		return comAveLevel;
	}

	public void setComAveLevel(String comAveLevel) {
		this.comAveLevel = comAveLevel;
	}

	public float getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(float vipPrice) {
		this.vipPrice = vipPrice;
	}

	public Long getComNumber() {
		return comNumber;
	}

	public void setComNumber(Long comNumber) {
		this.comNumber = comNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Book [BID=" + BID + ", bName=" + bName + ", publisher="
				+ publisher + ", price=" + price + ", stoNumber=" + stoNumber
				+ ", summary=" + summary + ", pTime=" + pTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BID == null) ? 0 : BID.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result
				+ ((comAveLevel == null) ? 0 : comAveLevel.hashCode());
		result = prime * result
				+ ((comNumber == null) ? 0 : comNumber.hashCode());
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result + ((pTime == null) ? 0 : pTime.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result
				+ ((salNumber == null) ? 0 : salNumber.hashCode());
		result = prime * result
				+ ((stoNumber == null) ? 0 : stoNumber.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + Float.floatToIntBits(vipPrice);
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
		Book other = (Book) obj;
		if (BID == null) {
			if (other.BID != null)
				return false;
		} else if (!BID.equals(other.BID))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (comAveLevel == null) {
			if (other.comAveLevel != null)
				return false;
		} else if (!comAveLevel.equals(other.comAveLevel))
			return false;
		if (comNumber == null) {
			if (other.comNumber != null)
				return false;
		} else if (!comNumber.equals(other.comNumber))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (pTime == null) {
			if (other.pTime != null)
				return false;
		} else if (!pTime.equals(other.pTime))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (salNumber == null) {
			if (other.salNumber != null)
				return false;
		} else if (!salNumber.equals(other.salNumber))
			return false;
		if (stoNumber == null) {
			if (other.stoNumber != null)
				return false;
		} else if (!stoNumber.equals(other.stoNumber))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Float.floatToIntBits(vipPrice) != Float
				.floatToIntBits(other.vipPrice))
			return false;
		return true;
	}
	


}
