package cose.seu.action.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cose.seu.dao.BookDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.entity.Book;

public class BookSearchServlet  extends HttpServlet{
	
	
	
	
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
	
		BufferedWriter writerback = new BufferedWriter(new OutputStreamWriter(out));        
		String booknName=req.getParameter("bookName");

		BookDao  findByName=new BookDaoImpl();
		
		if(findByName.findBookByName(booknName) != null)
		
		{	
			
			
			//找到书籍后的动作
			
			Long BID= Long.parseLong(req.getParameter("BID"));
			
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
	        resp.setContentLength(jsonBytes.length);  
	        resp.getOutputStream().write(jsonBytes);  
	        
			        
			System.out.println("output finish");
			writerback.flush(); 
			writerback.close(); 
		      
		 }
		else
		{
		 
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	        System.out.println("dfads");
	        writer.write("false");  
	        writer.flush(); 
	        writer.close();
		}
			
	

	}
		
}
	