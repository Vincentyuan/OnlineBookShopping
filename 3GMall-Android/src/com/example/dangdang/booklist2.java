package com.example.dangdang;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.example.dangdang.booklist.itemlistener;
import com.example.dangdang.entity.AsyncBookImage;
import com.example.dangdang.utils.HttpClientFactory;
import com.example.dangdang.utils.ImageCacheUtils;
import com.example.dangdang.utils.NetworkUtils;

public class booklist2 extends ListActivity{
	
	private SimpleAdapter adapter;
	private List<AsyncBookImage> bookImages=new ArrayList<AsyncBookImage>();
	private HttpClient client;
	private MyHandler myHandler;
	private ListView bookList;
	
	
	private String tid=new String ();
	private String type=new String();
	private List<HashMap<String, Object>> booklistdata=new ArrayList<HashMap<String ,Object>>(); //for intent to next Activiey
	
	
//	private String path=new String("http://223.3.87.207/3GMall/");
	private String path=new String("http://10.0.2.2/3GMall/");
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		bookList=getListView();
		myHandler=new MyHandler();
		
		Intent getTid=getIntent();
		tid=getTid.getExtras().getString("TID");
		type=getTid.getExtras().getString("type");
		
		setTitle(type);
		
		client=new DefaultHttpClient();
		
		BookListThread bt=new BookListThread();
		
		
		
		bt.start();
	}
	class MyHandler  extends Handler{
		
		public static final int SHOW_BOOK_LIST=0x0000;
		public static final int SHOW_BOOK_IMAGE=0x0001;
		@Override
		public void handleMessage(Message msg) {
			if(msg.what==SHOW_BOOK_LIST){
				adapter=(SimpleAdapter)msg.obj;
				bookList.setAdapter(adapter);
				
				LoadBookImages();
				System.out.println("ehhe");
				
			}
			
			if(msg.what==SHOW_BOOK_IMAGE){
				AsyncBookImage bookImage=(AsyncBookImage)msg.obj;
				
				//bookImage 的处理方式。
				
				System.out.println("jiazai");
				for(int i=0;i<adapter.getCount();i++){
					Map param=(Map)adapter.getItem(i);
					
					System.out.println(bookImage.getBookName());
					System.out.println(param.get("bName").toString());
					if(bookImage.getBookName().equalsIgnoreCase(param.get("bName").toString())){
						param.put("bookImage", bookImage.getImageName());
					}
				}
				
				bookList.setAdapter(adapter);
			}
			
			bookList.setOnItemClickListener(new itemlistener());
		}
		
		
	}

	
	class BookListThread extends Thread
	{
		public void run ()
		{
			System.out.println("get details ");
			DefaultHttpClient client = new DefaultHttpClient();  
			List<NameValuePair> list = new ArrayList<NameValuePair>();  
			NameValuePair pair1 = new BasicNameValuePair("type",type);
			System.out.println(type);
			System.out.println(tid);
			list.add(pair1);
           
            try{
		            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
		        	
		            HttpPost post = new HttpPost(path+"BookListServlet");  
		           
		            post.setEntity(entity);  
		            
		            HttpResponse response = client.execute(post); 
		   
		            System.out.println(response.getStatusLine().getStatusCode());
		            System.out.println(response.getStatusLine().getStatusCode()==200);
		            if(response.getStatusLine().getStatusCode()==200){  
		     
		                HttpEntity entity2=response.getEntity(); 
		                
		                String JDBC=EntityUtils.toString(entity2,"UTF-8");
		        
		                
		                System.out.println(JDBC+"lenth"+JDBC.length());
		                
		                String [] templist=JDBC.split(",,,,");
		               
		//                System.out.println(templist.length);
		                
		                SimpleAdapter adapter=createAdapter(templist);
		                
		                
		                Message msg=Message.obtain(myHandler,MyHandler.SHOW_BOOK_LIST);
						msg.obj=adapter;
						msg.sendToTarget();
		                
		            }
		            System.out.println("bookthread finish");
		            
		            
		            
            	}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
            	}
		}
		
	}
	
	private SimpleAdapter createAdapter (String [] dataarray)
	{
//		System.out.println(dataarray.length+"string []");
		String[] from=new String[]{"bName","writer","face"};
		int[] to=new int[]{R.id.textView1,R.id.textView3,R.id.imageView1};
		
		List<HashMap<String,Object>> data=new ArrayList<HashMap<String,Object>>();
		
		for(int i=0;i<dataarray.length;i++)
		{
			HashMap<String ,Object> map=new HashMap<String ,Object>();
			String [] temp=dataarray[i].split(",,");
			String threadBID=temp[0];
			String threadface=temp[2];
        	String threadbName=temp[1];
        	String threadwriter=temp[3];
        	
        	map.put("bName", threadbName);
        	map.put("writer", threadwriter);
        	map.put("face", null);
        	map.put("BID", threadBID);
        	
        	if(ImageCacheUtils.isImageExistedInLocalCache(threadface, booklist2.this)){
				map.put("face", threadface);
			}else{
				AsyncBookImage asyncBookImage=new AsyncBookImage(threadbName,threadface, threadface);
		//		System.out.println(bookImages.size());
				bookImages.add(asyncBookImage);
			}
        	
        	
        	data.add(map);
        	
		}
		booklistdata=data;
		
		
		SimpleAdapter adap=new SimpleAdapter(booklist2.this,data, R.layout.booklist ,from,to)  //5个参数
		{
			public void setViewImage(ImageView v, String value) {
				
				//如果没有设置任何图片，那么就使用默认的图片
				if(value == null || "".equals(value)) 
					return;
				
				//如果设置了图片名，那么从缓存中获取（线程从服务端获取数据时先放入缓存的）
				Bitmap bitmap = ImageCacheUtils.getBitmapFromCache(value,booklist2.this);
				v.setImageBitmap(bitmap);
			}
		};
		
		return adap;
		
	}

	public void LoadBookImages() {
		// TODO Auto-generated method stub
		for(AsyncBookImage bookImage:bookImages){
			BookImageThread bit=new BookImageThread(bookImage);
	//		System.out.println("load image");
			bit.start();
		}
		
	}
	
	
	class BookImageThread extends Thread{
		private AsyncBookImage bookImage;
		public BookImageThread(AsyncBookImage bookImage){
	//		System.out.println(bookImage.getPath());
	//		System.out.println("bookimage thread");
			this.bookImage=bookImage;
		}
		
		public void run(){
			try {
				/*URL url=new URL("223.3.87.207/3GMall/"+bookImage.getPath());
				
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				
				
				InputStream is=conn.getInputStream();
				*/
	//			System.out.println("wocao");
				client=new DefaultHttpClient();
				HttpPost heh=new HttpPost("http://10.0.2.2/3GMall/"+bookImage.getPath());//postlist.get(i);
				
				
    //            System.out.println("post");              
               // heh.setEntity(null);  
                HttpResponse response1= client.execute(heh); 
                InputStream is=response1.getEntity().getContent();
                
                
    //            System.out.println("post1");  
				String tempname=bookImage.getImageName().substring(bookImage.getImageName().length()-1-6, bookImage.getImageName().length());
                
				ImageCacheUtils.saveImageToCache(tempname, is, booklist2.this);
				
				System.out.println("show image");
				
				Message msg=Message.obtain(myHandler,MyHandler.SHOW_BOOK_IMAGE);
				
				System.out.println("send handler");
				msg.obj=bookImage;
				msg.sendToTarget();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class itemlistener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			Intent getdetail=new Intent(booklist2.this,bookdetails.class);
			System.out.println(booklistdata.get(arg2).get("BID").toString());
			getdetail.putExtra("BID", booklistdata.get(arg2).get("BID").toString());
			System.out.println(booklistdata.get(arg2).get("bName").toString());
			getdetail.putExtra("bName", booklistdata.get(arg2).get("bName").toString());
			startActivity(getdetail);
			
		}
		
	}
	
	
}
