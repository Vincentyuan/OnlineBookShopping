package com.example.dangdang.entity;

public class AsyncBooktype {

	private String  booktypeImagePath=null;
	private String  booktypeName=null;
	
	private AsyncBooktype (String path,String name)
	{
		this.booktypeImagePath=path;
		this.booktypeName=name;
	}
	public void setBooktypeImagePath(String booktypeImagePath) {
		this.booktypeImagePath = booktypeImagePath;
	}
	public String getBooktypeImagePath() {
		return booktypeImagePath;
	}
	public String getBooktypeName() {
		return booktypeName;
	}
	public void setBooktypeName(String booktypeName) {
		this.booktypeName = booktypeName;
	}

}
