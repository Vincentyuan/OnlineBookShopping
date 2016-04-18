package com.example.dangdang;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.dangdang.entity.AsyncBookImage;

public class booklist  extends ListActivity{

	private ListView booklist;
	private List<HashMap<String, Object>> booklistdata=new ArrayList<HashMap<String ,Object>>();
	private List<String>  ImagePath=new ArrayList<String >();
	private String tid=new String ();
	private String type=new String();
	private List< Bitmap>   bit=new ArrayList<Bitmap>();
//	private String path=new String("http://223.3.87.207/3GMall/");
	private String path=new String("http://10.0.2.2:8080/3GMall/");
	private String temp=null;
	
	private List<AsyncBookImage> bookImages=null;
	
	private SimpleAdapter adapter=null;
	
	
	private int count=0;
//	private MyHandler myHandler=null;
	Message msg;
	Handler myHandlerthis;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		booklist=getListView();
		Intent getTid=getIntent();
		tid=getTid.getExtras().getString("TID");
		type=getTid.getExtras().getString("type");
	
		
		getdata();
		setTitle(type);
		
		
		
		booklistAdapter  booklistadapter=new booklistAdapter(this);
		
		booklist.setAdapter(booklistadapter);
		booklist.setOnItemClickListener(new itemlistener());
	}
	private void getdata() {
		new booklistThread().start();
		
	}
	class booklistThread extends Thread{
		public void run() {
			//get booklist
			
			
			
			
			
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
         //       JSONArray js=EntityUtils.toString(entity2,"UTF-8");
                
                System.out.println(JDBC+"lenth"+JDBC.length());
                
                String [] templist=JDBC.split(",,,,");
               
                System.out.println(templist.length);
                
                
                List<HttpPost>  postlist=new ArrayList<HttpPost> ();
                
            //写入到数组
                for(int i=0;i<templist.length;i++)
                {
                	HashMap<String ,Object> map=new HashMap<String ,Object>();
                	
                	
                	
                	System.out.println(templist[i]);
                	String [] temp=templist[i].split(",,");
                	
                	
                	for(int in=0;in<temp.length;in++)
                	{
                		System.out.println(temp[in]);
                	}
                	String threadBID=temp[0];
                	String threadbName=temp[1];
                	String threadwriter=temp[3];
                	String threadface=temp[2];
                	
                	
                	
                	map.put("BID",threadBID);
                	map.put("bName", threadbName);
                	map.put("writer", threadwriter);
                	map.put("face", threadface);
                	
                	
          //      	HttpPost po=new HttpPost("223.3.87.207/3GMall/"+threadface);
        //       	postlist.add(po);
                	
                	/*try{
                       
                    	
               		HttpPost heh=new HttpPost("223.3.87.207/3GMall/"+threadface);//postlist.get(i);
                       
                       
                        heh.setEntity(entity);  
                        
                        HttpResponse response1= client.execute(heh); 
                        InputStream in=response1.getEntity().getContent();
                        Bitmap bitmap= BitmapFactory.decodeStream(in); 
                        bit.add(bitmap);
                        
                        
                        
                	}catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
                	*/
                	booklistdata.add(map);
                	
                	
             //   	ImagePath.add()
                }
                
               
               System.out.println("data finish");
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
	
	
	class itemlistener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			Intent getdetail=new Intent(booklist.this,bookdetails.class);
			System.out.println(booklistdata.get(arg2).get("BID").toString());
			getdetail.putExtra("BID", booklistdata.get(arg2).get("BID").toString());
			System.out.println(booklistdata.get(arg2).get("bName").toString());
			getdetail.putExtra("bName", booklistdata.get(arg2).get("bName").toString());
			startActivity(getdetail);
			
		}
		
	}
	
	class booklistAdapter extends BaseAdapter
	{

		private LayoutInflater mInflater;
		

		public booklistAdapter(Context context) {
			// TODO Auto-generated constructor stub

			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return booklistdata.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		class content
		{
			TextView bname;
			TextView writer;
			ImageView  imageView;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			content holder=new content();
			if (convertView == null) { // View中添加内容 convertview
										// 首次调用是null下一次调用的时候保存上一次的
				
				
				// "初始化"
				convertView = mInflater.inflate(
						R.layout.booklist, null);
				holder.bname=(TextView) convertView
						.findViewById(R.id.textView1);
				holder.writer=(TextView)convertView
						.findViewById(R.id.textView3);
				holder.imageView=(ImageView) convertView
						.findViewById(R.id.imageView1);

								
				convertView.setTag(holder);

			} else {

				holder=(content)convertView.getTag();
			}

	//		System.out.println(booktype.get(position).get("typeName"));
			System.out.println(booklistdata.get(position).get("bName"));
			holder.bname.setText((CharSequence) booklistdata.get(position).get("bName"));
			holder.writer.setText((CharSequence) booklistdata.get(position).get("writer"));
			
	//   
			
			
		//	holder.imageView.setImageBitmap(bit.get(position));
			
			return convertView;
		}
		}
		
	
	
	private void showMsg(String str) {
		msg = Message.obtain();
		msg.obj = str;
		msg.setTarget(myHandlerthis);   //send message  to flash the activity
		System.out.println("msg.obj"+msg.obj);
		msg.sendToTarget();
	}
	
}
	
	/*new Thread (){
		private AsyncBookImage bookImage;
		  void Thread(AsyncBookImage bookImage){
			this.bookImage=bookImage;
		}
    	public void run(){
    	
 //   		List<NameValuePair> list = new ArrayList<NameValuePair>();  
//			NameValuePair pair1 = new BasicNameValuePair("type",type);
			System.out.println(type);
			System.out.println(tid);
			
            try{
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");  
     //   	System.out.println();
        	System.out.println(count+"count"+bit.size()+"bit length");
            HttpPost post = new HttpPost("http://223.3.87.207/3GMall/"+booklistdata.get(count).get("face")); 
            
            System.out.println("http://223.3.87.207/3GMall/"+booklistdata.get(count).get("face"));
            
       //     post.setEntity(entity);  
        	HttpClient client = new DefaultHttpClient(); 
        
            HttpResponse response = client.execute(post); 
    		
            InputStream in=response.getEntity().getContent();
            
            bit.add(BitmapFactory.decodeStream(in));     
            count++;
            System.out.println(count+"count 2");
            
            Message msg=Message.obtain(myHandlerthis,Handler.SHOW_BOOK_IMAGE);
			msg.obj=image;
			msg.sendToTarget(myHandlerthis);
            
            
            
            
            
            in.close();
            
            }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }.start();
	*/
	
	
	



