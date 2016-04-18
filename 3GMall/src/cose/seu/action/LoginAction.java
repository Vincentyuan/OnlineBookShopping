package cose.seu.action;



import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import cose.seu.dao.LoginDao;
import cose.seu.dao.impl.LoginDaoImpl;

@SuppressWarnings("deprecation")
public class LoginAction extends ActionSupport implements Action{
	private String username;
	private String  pswd;
	private String flag;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	@SuppressWarnings("null")
	public String execute()throws Exception
	{
	//	HttpServletRequest request = ServletActionContext.getRequest(); 
	//	username = request.getParameter("username"); 
	//	pswd=request.getParameter("pswd");
		System.out.println("hadfgdsfasd");
/*		if(flag.equals("android"))
		{
			
			
			HttpServletResponse response = null;
			
		   
		    System.out.println("POST");  
		    System.out.println("name="+username);  
		    System.out.println("pswd="+pswd);  
		//    response.setCharacterEncoding("UTF-8");
		    
		    if(username.equals("1")&&pswd.equals("1")){
		    	OutputStream out = response.getOutputStream();  
		    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		    	writer.write("success");  
		    	writer.flush(); 
		    	writer.close(); 
		    }else{
		        OutputStream out = response.getOutputStream();  
		        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		        writer.write("false");  
		        writer.flush(); 
		        writer.close(); 
			
			
		    }
			
			
			return "";
			
			
			
			
			
		}
		else
		*/
		{
		LoginDao login=new LoginDaoImpl();
		
		
		System.out.println("dafsdf");
		System.out.println(username+pswd);
		System.out.println(login.Login(username, pswd));
		if(login.Login(username, pswd))
		{
			System.out.println("login sucess");
			return "success";
		
		}else
			return "input";
		}
	}
	
	
	
	
	/*
	


protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
  	request.setCharacterEncoding("UTF-8");  
    String name = request.getParameter("name");  
    String age  = request.getParameter("age");  
    System.out.println("POST");  
    System.out.println("name="+name);  
    System.out.println("age="+age);  
    response.setCharacterEncoding("UTF-8");
    
    if(name.equals("q")&&age.equals("1")){
    OutputStream out = response.getOutputStream();  
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
    writer.write("success");  
    writer.flush(); 
    writer.close(); 
    }else{
        OutputStream out = response.getOutputStream();  
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write("false");  
        writer.flush(); 
        writer.close(); 
    }*/
}
	

	
	
	
	
	
	
	


