package com.example.dangdang;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.dangdang.bookbrowse.booktypeAdapter;
import com.example.dangdang.bookbrowse.itemclick;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class shoppingcar extends Activity {
	private Button bt_show;
	private EditText et_text;
	private TextView totalprice;
	private ListView listview;
	private static List<HashMap<String ,Object>>  order=new ArrayList<HashMap<String ,Object>>(); 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcar);
        init();
        getdata();
   //     this.setTitle("gouwuche ");
        
        orderAdapter orderadpter =new orderAdapter(this);
        
        listview.setAdapter(orderadpter);
    }

	private void getdata() {
		// TODO Auto-generated method stub
	//read form sqlit; deal with the 	
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		bt_show=(Button)findViewById(R.id.button1);
		totalprice=(TextView)findViewById(R.id.totalprice);
		listview=(ListView)findViewById(R.id.listView1);
		 IntentFilter intentFilter = new IntentFilter();
	     intentFilter.addAction("cn.abel.action.broadcast");
	     this.registerReceiver(new MyBroadcastReciver(), intentFilter);
	     
	     System.out.println("register finish");
		bt_show.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//handin to the server our data
				
				
			}
			
		});
		
	}
	
	
	
	
	public static class  MyBroadcastReciver extends BroadcastReceiver {  @Override
		  public void onReceive(Context context, Intent intent) {
		   String action = intent.getAction();
		   if(action.equals("cn.abel.action.broadcast")) {
		//    String author = intent.getStringExtra("author");
		    
		    HashMap<String ,Object> map=new HashMap<String ,Object>();
		    map.put("bName", intent.getStringExtra("bName").toString());
		    map.put("price", intent.getStringExtra("price").toString());
		    System.out.println(intent.getStringExtra("bName").toString()+intent.getStringExtra("price").toString());
		    
		    order.add(map);
		    System.out.println(order.size());
		
		   }
		  }
		     
}
	
	
	
	class Holder{
		 Button bt_show;
		 EditText et_text;
		 TextView price;
		 TextView bookName;
		 CheckBox check;
	}
	
	class orderAdapter extends BaseAdapter{
		
		private LayoutInflater mInflater;
		

		public orderAdapter(Context context) {
			// TODO Auto-generated constructor stub

			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return order.size();
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

			Holder holder=new Holder();
			if (convertView == null) { // View中添加内容 convertview
										// 首次调用是null下一次调用的时候保存上一次的

				
				// "初始化"
				convertView = mInflater.inflate(
						R.layout.shoppingitem, null);
				
				holder.et_text=(EditText)convertView
						.findViewById(R.id.bookNumber);
				holder.price=(TextView) convertView
						.findViewById(R.id.bookprice);
				holder.bookName=(TextView)convertView
						.findViewById(R.id.detailOfBook);
				holder.check=(CheckBox)convertView
						.findViewById(R.id.chooseForHandin);
								
				convertView.setTag(holder);

			} else {

				holder = (Holder) convertView.getTag();
			}

	//		System.out.println(booktype.get(position).get("typeName"));
			
	//		text.setText((CharSequence) booktype.get(position).get("typeName"));
			holder.bookName.setText(order.get(position).get("bName").toString());
			holder.price.setText(order.get(position).get("price").toString());
		
			return convertView;
		}

		
	}
	
	
    
    
}