package com.example.dangdang;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bookdetails  extends Activity{
	
	private ImageView bookcover;
	private TextView bookdetails_bookNumber;
	private TextView  bookdetails_bookprice;
	private TextView contain;
	private Button AddToShoppingCar;
	private TextView author;
	private TextView   press;//textView7
	private TextView    markLevel;//textView9
	private String  BID;
	private String bookname;
	private String price;
//	private TextView titlename;
//	private Button shopping;
	
//	private String path=new String("http://223.3.87.207/3GMall/");
	
	private String path=new String("http://10.0.2.2/3GMall/");
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
	//	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 注意顺序   
		setContentView(R.layout.bookdetails);
	//	
    //    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,      // 注意顺序   
    //    R.layout.title);  
		
		
		init();
		getdata();
	}


	private void getdata() {
		// TODO Auto-generated method stub
		//read from sqlite or web server
		new bookdetailThread().start();
	}
	
	
	class bookdetailThread extends Thread{
		
		public void run(){
		System.out.println("start read");
		
		
		System.out.println("dfasd");
		
		
		DefaultHttpClient client = new DefaultHttpClient();  
        List<NameValuePair> list = new ArrayList<NameValuePair>();  
        NameValuePair pair1 = new BasicNameValuePair("BID",BID);  
        list.add(pair1);  
        try{
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
    	
        HttpPost post = new HttpPost(path +"BookdetailServlet");  
       
        post.setEntity(entity);  
        HttpResponse response = client.execute(post); 

         System.out.println(response.getStatusLine().getStatusCode());
         System.out.println(response.getStatusLine().getStatusCode()==200);
        if(response.getStatusLine().getStatusCode()==200){  
  //        InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示  
            HttpEntity entity2=response.getEntity(); 
            String JDBC=EntityUtils.toString(entity2,"UTF-8");
                
            System.out.println(JDBC);
            System.out.println(JDBC.indexOf("comNumber=")-2);
            
            System.out.println(JDBC.substring(JDBC.indexOf("BID=")+4,JDBC.indexOf("comNumber=")-2));
            
            bookdetails_bookNumber.setText(JDBC.substring(JDBC.indexOf("BID=")+4,JDBC.indexOf("comNumber=")-2));
            price=JDBC.substring(JDBC.indexOf("price=")+7,JDBC.indexOf("writer=")-2);
        //    System.out.println("pirce"+price);
        //    System.out.println(JDBC.substring(JDBC.indexOf("price=")+7,JDBC.indexOf("writer=")-2));
			bookdetails_bookprice.setText(price);
			contain.setText(JDBC.substring(JDBC.indexOf("comNumber=")+"comNumber=".length(),JDBC.indexOf("comAveLevel=")-2));
			author.setText(JDBC.substring(JDBC.indexOf("writer=")+7,JDBC.indexOf("publisher=")-2));
			markLevel.setText(JDBC.substring(JDBC.indexOf("comAveLevel=")+"comavelevel".length()+1,JDBC.indexOf("price")-2));
			press.setText(JDBC.substring(JDBC.indexOf("publisher")+"publisher".length()+1,JDBC.length()-1));
        } 
		
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}

	private void init() {
		// TODO Auto-generated method stub
		bookcover=(ImageView)findViewById(R.id.bookdetails_bookcover);
		bookdetails_bookNumber=(TextView)findViewById(R.id.bookdetails_bookNumber);
		bookdetails_bookprice=(TextView)findViewById(R.id.bookdetails_bookprice);
		contain=(TextView)findViewById(R.id.textView3);
		AddToShoppingCar=(Button)findViewById(R.id.AddToShoppingCar);
		author=(TextView)findViewById(R.id.textView5);
		press=(TextView)findViewById(R.id.textView7);
		markLevel=(TextView)findViewById(R.id.textView9);
		
	//	titlename=(TextView)findViewById(R.id.text);
	//	shopping=(Button)findViewById(R.id.button);
		
		
		Intent get=getIntent();
		BID=get.getExtras().getString("BID");
		bookname=get.getExtras().getString("bName");
		setTitle(bookname);
		AddToShoppingCar.setOnClickListener(new OnClickListener  (){

			@Override
			 public void onClick(View v) {
				   
				   Intent intent = new Intent();
				   intent.setAction("cn.abel.action.broadcast");
				   
				   //要发送的内容
				   intent.putExtra("bName", bookname);
				   intent.putExtra("price",price);
				   System.out.println(price);
			//	   System.out.println(bookdetails_bookprice.getContext().toString());
				   System.out.println("broadcast send");
				   //发送 一个无序广播
				   bookdetails.this.sendBroadcast(intent);
			}
			
		});
	}

}
