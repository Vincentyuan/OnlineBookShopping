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
import cose.seu.entity.Type;

public class BookClassServlet extends HttpServlet{
	
	
	
	
	
	@Override
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
		System.out.println("dfa");
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		Book book=new Book();
		
		List<HashMap<String, Object>> json=new ArrayList <HashMap<String,Object>>();
		
		
		BookDao getclass=new BookDaoImpl();
		List<Type> bookclass=getclass.showType();
		System.out.println(bookclass.size()+"length");
		
		for(int i=0;i<bookclass.size();i++)
		{
			HashMap<String ,Object> heh=new HashMap<String ,Object>();
	        HashMap<String ,Object> contain=new HashMap<String ,Object>();
	        heh.put("TID",bookclass.get(i).getTID() );
	        heh.put("typeName",bookclass.get(i).getTypeName() );
	//        contain.put("tyeName", value)
	        json.add(heh);
		}
        byte[] jsonBytes = json.toString().getBytes("utf-8");  
        response.setContentLength(jsonBytes.length);  
        response.getOutputStream().write(jsonBytes);  
        
        
    	System.out.println("output finish");
        writer.flush(); 
        
        
        writer.close(); 
		
		
	}
		
		
	
	
	
	
	
	

}
