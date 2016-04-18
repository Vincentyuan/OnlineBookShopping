package com.example.dangdang.entity;

public class AsyncBookImage {
	
	private String bookName = null;
	
	private String imageName = null;
	
	private String path = null;
	
	public AsyncBookImage(String bookName, String imageName, String path) {
		this.bookName = bookName;
		this.imageName = imageName;
		this.path = path;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
