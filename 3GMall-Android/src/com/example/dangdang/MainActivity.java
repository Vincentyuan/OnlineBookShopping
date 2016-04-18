package com.example.dangdang;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dangdang.utils.NetworkUtils;
public class MainActivity extends Activity implements OnClickListener {

	
	EditText name;
	EditText passwd;
	Button sure;
	Button reset;
	
	//connect to web 
	private HttpClient client;
	private MyHandler myHandler = new MyHandler();
	public static final String LOGIN_URL = NetworkUtils.DANGDANG_BASE_URL+NetworkUtils.DANGDANG_LOGIN_URL;   //connect address
	Message msg;
	
//	private String path=new String("http://223.3.87.207/3GMall/");
	
	private String path=new String("http://10.0.2.2/3GMall/");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("登陆 ");
		initView();
		
		
	}
	public void initView(){
		
		sure=(Button)findViewById(R.id.main_sure);
		sure.setOnClickListener( this);
		reset=(Button)findViewById(R.id.main_reset);
		reset.setOnClickListener(this);
		name=(EditText)findViewById(R.id.main_username);
		passwd=(EditText)findViewById(R.id.main_passwd);
		client = new DefaultHttpClient();
		
	}
	
	
	
	public void onClick(View v){
		switch(v.getId()){
			case R.id.main_sure:
				
//提交用户名 ，和密码，后台比对，返回数据，若非空则进入下一步
	
				//start a new thread to check the username and passwd
				new LoginThread().start();
				
			
				break;
			case R.id.main_reset:
				name.setText("");
				passwd.setText("");
				break;
		}
		
	}
	
	//get data from the server to and then do flash the activity
	@SuppressLint("ShowToast")
	class MyHandler extends Handler { 

		@Override
		public void handleMessage(Message msg) {
			
		
			String  username="-1";
			String  userlevel="-1";
			String  userhead="-1";
			if(!((String )msg.obj).equals("fail"))
			{
				
		//		String  usercredit=null;
				try {
					JSONObject jsonObject = new JSONObject((String)msg.obj);
					System.out.println(jsonObject.get("username").toString());
					username=jsonObject.get("username").toString();
					userlevel=jsonObject.get("userlevel").toString();
					userhead=jsonObject.get("userhead").toString();
			//		usercredit=jsonObject.get("usercredit").toString();
					
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				  //写入到数据库      
				
				
				
				
			}
			 
			
			System.out.println((String)msg.obj);
			if(!((String)msg.obj).equals("fail"))
			{

				
				Intent settag=new Intent(MainActivity.this,setTag.class);
				settag.putExtra("username", username);
				settag.putExtra("userlevel", userlevel);
				
				startActivity(settag); 
							
			}
			else
			{
				System.out.println("handle");
				
				Toast.makeText(getApplicationContext(), "用户名或密码错误！", Toast.LENGTH_LONG).show();
			}

			//get the data and deal with it
	//		Toast.makeText(LoginActivity.this, str, Toast.LENGTH_LONG).show();
		}

	}

	class LoginThread extends Thread {
		public void run() {
			System.out.println("start read");
			
			
			System.out.println("dfasd");
			
			
			DefaultHttpClient client = new DefaultHttpClient();  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            NameValuePair pair1 = new BasicNameValuePair("username",name.getText().toString());  
            NameValuePair pair2 = new BasicNameValuePair("pwd",passwd.getText().toString());  
            NameValuePair pair3 = new BasicNameValuePair("flag","android");
            list.add(pair1);  
            list.add(pair2);  
            list.add(pair3);
            try{
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
        	
            HttpPost post = new HttpPost(path+"LoginServlet");  
           
            post.setEntity(entity);  
            HttpResponse response = client.execute(post); 
   
             System.out.println(response.getStatusLine().getStatusCode());
             System.out.println(response.getStatusLine().getStatusCode()==200);
            if(response.getStatusLine().getStatusCode()==200){  
      //        InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示  
                HttpEntity entity2=response.getEntity(); 
      
                String JDBC=EntityUtils.toString(entity2,"UTF-8");
                
                System.out.println(JDBC);
                if(JDBC.equals("fail"))
                {
                	showMsg("fail");
                }
                else{
	          //存储变量   
                	   	
                	
	                showMsg(JDBC);
                }
            } 
			
            }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
			

	private void showMsg(String str) {
		msg = Message.obtain();
		msg.obj = str;
		msg.setTarget(myHandler);   //send message  to flash the activity
		System.out.println("msg.obj"+msg.obj);
		msg.sendToTarget();
	}
	
	
	

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}}

	
	
	
	


