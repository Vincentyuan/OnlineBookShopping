package cose.seu.action.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cose.seu.dao.LoginDao;
import cose.seu.dao.impl.LoginDaoImpl;
import cose.seu.entity.UserInfo;

public class LoginServlet  extends HttpServlet{
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//deal with get type
		
		
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)//封装数据，封装请求
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");  
		
		 String name = "-1";  
	     String pwd  =  "-1";
	     String flag= "-1";
		
		
         name = req.getParameter("username");  
         pwd  = req.getParameter("pwd");
         flag=req.getParameter("flag");
        System.out.println("POST");  
        System.out.println("username="+name+"PWD"+pwd+"flag"+flag);  
     
        req.setCharacterEncoding("UTF-8");
        
        LoginDao login=new LoginDaoImpl();
        
        System.out.println("erro?");
        
	        if(flag.equals("android")&&login.Login(name, pwd)){
	        	
	        	System.out.println("check right");
		        OutputStream out = resp.getOutputStream();  
		        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		        
		        UserInfo in=login.getUserInfo(name);
		        
		        
		        
		        Map<String,Object> json=new HashMap<String,Object>();
		        
		        json.put("username", in.getUserName());
		        json.put("userlevel", in.getLevel());
		        json.put("userhead", in.getHead());
		        
		        byte[] jsonBytes = json.toString().getBytes("utf-8");  
	            resp.setContentLength(jsonBytes.length);  
	            resp.getOutputStream().write(jsonBytes);  
		        
		        
		    	System.out.println("output finish");
		        writer.flush(); 
		        
		        
		        writer.close(); 
		        }else{
			        OutputStream out = resp.getOutputStream();  
			        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			        System.out.println("dfads");
			        writer.write("fail");  
			        writer.flush(); 
			        writer.close(); 
		        }
	}
	

		
		
}
	
	
	
	

