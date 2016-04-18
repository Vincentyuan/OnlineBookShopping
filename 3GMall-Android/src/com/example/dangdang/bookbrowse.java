package com.example.dangdang;



import java.util.ArrayList;
import java.util.HashMap;
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
import org.json.JSONArray;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class bookbrowse extends Activity {
    /** Called when the activity is first created. */
	private EditText bookNAME;
	private Button search;
	private ListView booktypelistview;
	private List<HashMap<String ,Object>> booktype=new ArrayList<HashMap<String,Object>>();
	
//	private String path=new String("http://223.3.87.207/3GMall/");
	private String path=new String("http://10.0.2.2/3GMall/");
	//web  definition
	private HttpClient client;
	private MyBookHandler myHandler = new MyBookHandler();
//	public static final String LOGIN_URL = "https:\\223.3.87.207";   //connect address
	
	Message msg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookbrowse);
        init();
        getdata();
        booktypeAdapter bookbrowse =new booktypeAdapter(this);
     
        booktypelistview.setAdapter(bookbrowse);
        booktypelistview.setOnItemClickListener(new itemclick() );//onclick action
        
    }
    
	private void init() {
		// TODO Auto-generated method stub
	
		
		booktypelistview=(ListView)findViewById(R.id.listView1);
		
	}
	void getdata(){
		
		System.out.println("run");
		
		new getTypeThread().start();
		
	}
	class getTypeThread extends Thread {
		public void run() {
			
			System.out.println("dfsagdf");
			DefaultHttpClient client = new DefaultHttpClient();  
           List<NameValuePair> list = new ArrayList<NameValuePair>();  
           NameValuePair pair1 = new BasicNameValuePair("book","booktypeget");
           list.add(pair1);
           
            try{
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
        	
            HttpPost post = new HttpPost(path+"BookClassServlet");  
           
            post.setEntity(entity);  
            
            HttpResponse response = client.execute(post); 
   
             System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getStatusCode()==200);
            if(response.getStatusLine().getStatusCode()==200){  
     
                HttpEntity entity2=response.getEntity(); 
      
                String JDBC=EntityUtils.toString(entity2,"UTF-8");
                System.out.println(JDBC);
                JSONArray jsonArray = new JSONArray(JDBC);
        //        Map<String ,Object> job=(Map<String, Object>) new JSONObject(JDBC);
                
                System.out.println(jsonArray);
                
                //写入到数组
                for(int i=0;i<jsonArray.length();i++)
                {
                	
                	HashMap<String ,Object> map=new HashMap<String ,Object>();
                	
                	String jsonstr=new String (jsonArray.getString(i));
                	
                	System.out.println(jsonstr);
                	
                	char [] jsonchar=jsonstr.toCharArray();
            //    	System.out.println(jsonchar);
                	String tid="";
                	for(int i1=7;i1<11;i1++)
                	{
                		tid=tid+jsonchar[i1];
                	}
                	String typeName="";
                	for(int i2=jsonchar.length-4;i2<jsonchar.length-2;i2++)
                	{
                		typeName=typeName+jsonchar[i2];
                	}
                	System.out.println(tid+"=="+typeName);
      //          	System.out.println(job.get("typeName").toString());
                	map.put("TID", tid);
                	map.put("typeName", typeName);
                	booktype.add(map);
   //             	System.out.println(booktype.get(i).get(key))
                }
                
               
            } 
            else{
            	showMsg("fail");
            }
			
            }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		}

	class booktypeAdapter extends BaseAdapter{
	
		private LayoutInflater mInflater;
		

		public booktypeAdapter(Context context) {
			// TODO Auto-generated constructor stub

			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return booktype.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			TextView text;
			if (convertView == null) { // View中添加内容 convertview
										// 首次调用是null下一次调用的时候保存上一次的

				
				// "初始化"
				convertView = mInflater.inflate(
						R.layout.booktypeitem, null);
				text=(TextView) convertView
						.findViewById(R.id.bookbrowse_name);

								
				convertView.setTag(text);

			} else {

				text = (TextView) convertView.getTag();
			}

	//		System.out.println(booktype.get(position).get("typeName"));
			
			text.setText((CharSequence) booktype.get(position).get("typeName"));
		
			return convertView;
		}

		
	}
	
	class itemclick implements android.widget.AdapterView.OnItemClickListener   
	{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
	//点击之后跳转到下一个activity		
			Intent getbooklist=new Intent(bookbrowse.this,booklist2.class);
			
			getbooklist.putExtra("TID", booktype.get(arg2).get("TID").toString());
			getbooklist.putExtra("type", booktype.get(arg2).get("typeName").toString());
			
			System.out.println("TYPE"+booktype.get(arg2).get("typeName").toString());
			startActivity(getbooklist);
			
		}
		
	}
		
	class MyBookHandler extends Handler { 
		public void handleMessage(Message msg) {
			Toast.makeText(getApplicationContext(), "访问失败", Toast.LENGTH_SHORT).show();
		}
			

	}
	
	private void showMsg(String str) {
		msg = Message.obtain();
		msg.obj = str;
		msg.setTarget(myHandler);   //send message  to flash the activity
		System.out.println("msg.obj"+msg.obj);
		msg.sendToTarget();
	}
	
}