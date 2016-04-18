package com.example.dangdang.entity;

public class AsyncBookclass {
	
	private String bookclassImagePath=null;
	
	private String bookclassName=null;
	
	
	
	public AsyncBookclass(String bookclassImagePath, String bookclassName) {
		super();
		this.bookclassImagePath = bookclassImagePath;
		this.bookclassName = bookclassName;
	}

	public String getBookclassImagePath() {
		return bookclassImagePath;
	}

	public void setBookclassImagePath(String bookclassImagePath) {
		this.bookclassImagePath = bookclassImagePath;
	}

	public String getBookclassName() {
		return bookclassName;
	}

	public void setBookclassName(String bookclassName) {
		this.bookclassName = bookclassName;
	}

	


}
