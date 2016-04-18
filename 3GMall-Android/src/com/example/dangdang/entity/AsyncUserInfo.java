package com.example.dangdang.entity;

public class AsyncUserInfo {
	
	
	private String userName=null;
	private String userlevel=null;
	private String userImagePath=null;
	private String userCredit=null;
	
	
	public AsyncUserInfo(String userName, String userlevel,
			String userImagePath, String userCredit) {
		super();
		this.userName = userName;
		this.userlevel = userlevel;
		this.userImagePath = userImagePath;
		this.userCredit = userCredit;
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	public String getUserImagePath() {
		return userImagePath;
	}
	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}
	public String getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(String userCredit) {
		this.userCredit = userCredit;
	}
	


}
