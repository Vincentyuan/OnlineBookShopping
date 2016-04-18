package cose.seu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cose.seu.dao.LoginDao;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;

public class LoginDaoImpl implements LoginDao {

	public boolean Login(String username, String passwd) {
		
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 2.创建会话
		
		
		Session s = sf.openSession();
		
		if(!this.checkUsernameExist(username))
		{
			System.out.println(username);
			return false;
		}
	
		List<UserInfo> userl =s.createQuery("from UserInfo sc where sc.UserName=?").setString(0, username).list();
		UserInfo user = userl.get(0);
		
		System.out.println(user.getUserName());
		s.close();
		if(user.getPassword().equals(passwd))
		  {
			  	return true;
		  }
		  else
		  {
			  return false;
		  }
		
		
		      //无该用户返回errorname，密码错误返回errorpasswd
	}

	public boolean Register( UserInfo information) {
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
				
		Transaction trans = s.beginTransaction();
		
		
		s.save(information);
		trans.commit();
		s.close();
		
		
		
		return true;
	}

	//用户信息更新，需要用户的uid和 用户信息对象，更改之后放在其中 
	public boolean UserinfoChange(Long id,UserInfo updateinfo) {
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		
		Transaction trans = s.beginTransaction();
		
	
		s.update(updateinfo);

		trans.commit();
		s.close();
		
		
		return false;
	}

	public boolean ChangePasswd( String name, String passwd) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction tran=s.beginTransaction();
		
		List<UserInfo> userl=s.createQuery("from UserInfo sc where sc.UserName=?").setString(0, name).list();
		
		UserInfo user=userl.get(0);
		user.setPassword(passwd);
		
		s.save(user);
		tran.commit();
		s.close();
		return false;
	}

	public boolean checkUsernameExist(String name) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		if (name.isEmpty()) {
			return false;
			
		}
		List<Long> check=s.createQuery("select UID from UserInfo sc where sc.UserName=?").setString(0, name).list();
		//String nameForCheck=check.get(0).getUserName();
		if(check.size()==0)
			return false;
	
		return true;
	}
	

	public void showInfor(UserInfo hehe)
	{
		System.out.println(hehe.getNickName());
		System.out.println(hehe.getUserName());
		System.out.println(hehe.getMail());
		System.out.println(hehe.getPassword());
	}
	
	public UserInfo getUserInfo(String name)
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 2.创建会话
		
		
		Session s = sf.openSession();
		
		List<UserInfo> userl =s.createQuery("from UserInfo sc where sc.UserName=?").setString(0, name).list();
		UserInfo user = userl.get(0);
		s.close();
		return user;
		
	}

	public boolean checkPwd(String username,String pwd) {
		// TODO Auto-generated method stub
		if (pwd.isEmpty()) return false;
		Session s = HibernateSessionFactory.getSession();
		List<Long> check = s.createQuery("select u.UID from UserInfo u where u.UserName ='"+username+"' and u.Password='"+pwd+"'").list();
//		System.out.println(check);
		if(check==null)return false;
		return true;
	}
	public boolean checkAnswer(String username,String answer)
	{
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		List<UserInfo> check=s.createQuery("from UserInfo sc where sc.UserName=?").setString(0, username).list();
		String rightPasswd=check.get(0).getAnswer();
		if(rightPasswd.equals(answer))
			return true;
		else
			return false;

	}
	
}
