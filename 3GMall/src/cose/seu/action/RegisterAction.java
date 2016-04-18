package cose.seu.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import cose.seu.dao.LoginDao;
import cose.seu.dao.impl.LoginDaoImpl;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;

public class RegisterAction extends ActionSupport implements Action {
	
	private String username=null;
	private String pwd=null;
	private String spwd=null;
	private String nickname=null;
	private UserInfo user;
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String execute()throws Exception
	{
		LoginDao reg=new LoginDaoImpl();
		System.out.println(pwd);
		System.out.println(spwd);
		
		
		if(reg.checkUsernameExist(username))  //exist?
			return "fail";
		System.out.println("d");
		if(pwd.isEmpty())   //passwd equls
			return "fail";
		if(spwd.isEmpty())   //passwd equls
			return "fail";
		System.out.println("d");
		if(!spwd.equals(pwd))   //passwd equls
			return "fail";
		UserInfo  newOne=new UserInfo();
	//	newOne.setAge(age);
		newOne.setUserName(username);
		newOne.setPassword(pwd);
		newOne.setNickName(nickname);
		
		System.out.println("passwd:"+newOne.getPassword()+"  age:"+newOne.getAge()+" username:"+newOne.getUserName()+"  email "+newOne.getMail());
		System.out.println("register prepare");
		if(reg.Register(newOne))
		{
			System.out.println("register sucess");
			HttpSession s=ServletActionContext.getRequest().getSession(true);
			
			Session c = HibernateSessionFactory.getSession();
			List<UserInfo> uList = c.createQuery("from UserInfo u where u.UserName ='"+username+"'").list();
			user = uList.get(0);
			System.out.println(user);
			s.setAttribute("user", user);
			
			return "success";
			
		}
		else
			return "fail";
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	
	
}
