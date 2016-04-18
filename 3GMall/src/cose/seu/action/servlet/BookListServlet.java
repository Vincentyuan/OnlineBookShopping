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

public class BookListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//deal with get type
		
		
		
		doPost(req, resp);
	}

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)//封装数据，封装请求
			throws ServletException, IOException {

		OutputStream out = response.getOutputStream();  
	//	System.out.println("dfa");
		String TID= request.getParameter("TID");
		String type=request.getParameter("type");
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		Book book=new Book();
		
		List<HashMap<String, Object>> json=new ArrayList <HashMap<String,Object>>();
		
		
		BookDao getclass=new BookDaoImpl();
		
		System.out.println("TID"+TID);
		System.out.println(type);
		List<Book> bookclass=getclass.findBookByType("工具"); //获取列表
		
		
		StringBuffer booklistt = new StringBuffer(" ");
		String      booklist="";
		System.out.println(bookclass.size()+"length");
		
//		booklistt.append(booklist+bookclass.get(0).getBID().toString()+","+
//				bookclass.get(0).getbName().toString()+","+
//				bookclass.get(0).getFace().toString()+","+bookclass.get(0).getAuthor().toString()+".");
		for(int i=1;i<bookclass.size()-1;i++)
		{
			HashMap<String ,Object> heh=new HashMap<String ,Object>();
	 //       HashMap<String ,Object> contain=new HashMap<String ,Object>();
	        
			booklistt.append(booklist+bookclass.get(i).getBID().toString()+",,"+
					bookclass.get(i).getbName().toString()+",,"+
					bookclass.get(i).getFace().toString()+",,"+
					bookclass.get(i).getAuthor().toString()+",,,,");
	  //      String writer1=bookclass.get(i).getAuthor().replaceAll("，", " ");
	   //     heh.put("writer", writer1);
	  //      contain.put("book"+i, heh);
	//        json.add(heh);
	//        HashMap<String ,Object> hehe=new HashMap<String ,Object>();
	//        hehe.put("did", "ver");
	//        json.add(hehe);
		}
//		booklistt.append(booklist+bookclass.get(bookclass.size()).getBID().toString()+","+
	//			bookclass.get(bookclass.size()).getbName().toString()+","+
		//		bookclass.get(bookclass.size()).getFace().toString()+","+
			//	bookclass.get(bookclass.size()).getAuthor().toString());
		System.out.println("get data finish");
		System.out.println(booklistt);
		
  //      byte[] jsonBytes = json.toString().getBytes("utf-8");  
 //      response.setContentLength(jsonBytes.length);  
  //      response.getOutputStream().write(jsonBytes);  
		 byte[] jsonBytes = booklistt.toString().getBytes("utf-8");  
        response.setContentLength(jsonBytes.length);  
        response.getOutputStream().write(jsonBytes);
        
    	System.out.println("output finish");
        writer.flush(); 
        
        
        writer.close(); 
		
		
	}
	
	
	
	
	
	
	
	
	
}
