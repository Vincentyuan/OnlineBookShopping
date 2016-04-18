package cose.seu.action.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cose.seu.dao.BookDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.entity.Book;

public class BookdetailServlet    extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//deal with get type
		
		
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)//封装数据，封装请求
			throws ServletException, IOException {

		OutputStream out = response.getOutputStream();  
		System.out.println("dfasdf");
		
		Long BID= Long.parseLong(request.getParameter("BID"));
		
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
			
		
		BookDao getdetails=new BookDaoImpl();
		
		
		Book book=getdetails.findBookById(BID);
		
		HashMap<String ,Object> json=new HashMap<String ,Object>();
	        
	    json.put("BID",book.getBID() );
	    json.put("price",book.getPrice() );
	    json.put("comNumber", book.getStoNumber());
	    json.put("writer", book.getAuthor());
	    json.put("publisher", book.getPublisher());
	    json.put("comAveLevel", book.getComAveLevel());
	    
	  
	        
        byte[] jsonBytes = json.toString().getBytes("utf-8");  
        response.setContentLength(jsonBytes.length);  
        response.getOutputStream().write(jsonBytes);  
        
        
    	System.out.println("output finish");
        writer.flush(); 
        
        
        writer.close(); 
		
		
	}
	
	
}
	
	
	
	
	
	