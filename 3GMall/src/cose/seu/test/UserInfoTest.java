package cose.seu.test;

import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;
import cose.seu.dao.*;
import cose.seu.dao.impl.*;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserInfoTest {

	
	
	public static void main(String[] args)
	{
//		UserInfo user1=new UserInfo();
//		//user.setAge((long)12);
//		UserManagerDao userdao=new UserManagerDaoImpl();
//		//System.out.print(userdao.findById((long)1).getAge());
//		
//		UserInfo userInfo=userdao.findById((long)240);
//		System.out.println(userInfo.getFav().size());
//		
//		Session c = HibernateSessionFactory.getSession();
//		List<UserInfo> uList = c.createQuery("from UserInfo u where u.UserName ='chen'").list();
//		UserInfo user = uList.get(0);
//		System.out.println(user.getFav().size());
		UserInfo users =new UserInfo();
		UserManagerDao userdao=new UserManagerDaoImpl();
		
		
		System.out.println(users.getCreditNumber());
		
	}
	

}	
	
