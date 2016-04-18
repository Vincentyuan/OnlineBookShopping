package cose.seu.action;

import cose.seu.dao.LoginDao;
import cose.seu.dao.impl.LoginDaoImpl;
import cose.seu.entity.UserInfo;

public class findPasswd  {
	private String  username;
	private String firstPasswd;
	private String secondPasswd;
	private String answer;
	private UserInfo user;
	private LoginDao login=new LoginDaoImpl();
	
	public String findPasswd_INusername()
	{
		if(login.checkUsernameExist(username))//it is right
		{
			user=login.getUserInfo(username);
			return "findPasswd_answer";
		}
		else
		{
			return "fail";
		}
	}

	public String findPasswd_checkAnswer()
	{
		if(login.checkAnswer(username,answer))//it is rigth
		{
			return "findPasswd_newpasswd";
		}
		else
		{
			return "fail";
		}
	}
	public String findPasswd_newPasswd()
	{
		if(firstPasswd.equals(secondPasswd)&&login.ChangePasswd(username ,secondPasswd ))
		{
			return "home";
			
		}
		else
			return "fail";
	}
}
