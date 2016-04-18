package com.example.dangdang.entity;

public class AsyncShoppingCar {
	
	private String bookname =null;
	private String booknumber=null;
	private String bookprice=null;
	public AsyncShoppingCar(String bookname, String booknumber, String bookprice) {
		super();
		this.bookname = bookname;
		this.booknumber = booknumber;
		this.bookprice = bookprice;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	
	

}
