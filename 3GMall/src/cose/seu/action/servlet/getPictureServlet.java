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

public class getPictureServlet extends HttpServlet{
	
	
	
	
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
   
		OutputStream out = resp.getOutputStream();  
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		        
		String path=req.getParameter("paht");
		
		        
		//根据path获取数据返回给客户端        
		       
//		byte[] jsonBytes = json.toString().getBytes("utf-8");  
//	    resp.setContentLength(jsonBytes.length);  
//	    resp.getOutputStream().write(jsonBytes);  
		        
		        
		System.out.println("output finish");
		writer.flush(); 
		writer.close(); 
		      
		       	}
	

		
		
}
	