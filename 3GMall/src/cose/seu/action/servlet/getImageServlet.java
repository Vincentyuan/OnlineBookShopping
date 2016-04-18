package cose.seu.action.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getImageServlet extends HttpServlet{
	
	
	
	
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
		        
		String path=req.getParameter("path");
		
//		InputStream is=new InputStream(); 
	 
		//根据path获取数据返回给客户端        
		       
//		byte[] jsonBytes = json.toString().getBytes("utf-8");  
//	    resp.setContentLength(jsonBytes.length);  
//	    resp.getOutputStream().write(jsonBytes);  
		        
		        
		System.out.println("output finish");
		writer.flush(); 
		writer.close(); 
		      
		       	}
	

		
		
}
	