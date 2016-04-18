package cose.seu.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
	/**
	 * @author Jossion
	 */
	private static final long serialVersionUID = 6L;
	private Long oitid;
	private Order order;
	private Long isbn;
	private Book book;
	public OrderItem(Long oitid, Order order, Long isbn, Book book) {
		super();
		this.oitid = oitid;
		this.order = order;
		this.isbn = isbn;
		this.book = book;
	}
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	public Long getOitid() {
		return oitid;
	}
	public void setOitid(Long oitid) {
		this.oitid = oitid;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (oitid == null) {
			if (other.oitid != null)
				return false;
		} else if (!oitid.equals(other.oitid))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}

	
}
