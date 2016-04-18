package cose.seu.dao;

import cose.seu.entity.UserInfo;

public interface LoginDao {
	
	public boolean Login (String username,String passwd);
	/*
	 * 传入用户输入的用户名和密码，进行验证，若无用户名，返回errorname ，若用户名密码错误返回errorpasswd
	 * */
	
	public boolean Register(UserInfo information );
	/*
	 * 讲用户注册的信息封装成实体类，用 实体类操作数据库
	 * */
	public boolean UserinfoChange(Long id,UserInfo updateinfo);
	/*
	 * 用户提交要更改的信息
	 * */
	public boolean ChangePasswd(String name,String passwd );
	/*
	 * 用户更改个人信息
	 * */
	public boolean checkUsernameExist(String name);
	/*
	 * 检测用户名和密码是否存在
	 * */
	public UserInfo getUserInfo(String name);
	
	public boolean checkPwd(String user,String pwd);
	
	public boolean checkAnswer(String username,String answer);
	

}
