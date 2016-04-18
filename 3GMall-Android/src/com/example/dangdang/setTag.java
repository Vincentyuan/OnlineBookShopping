package com.example.dangdang;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class setTag extends TabActivity{
    /** Called when the activity is first created. */
	
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main); 
        final TabHost tabHost = getTabHost(); 	
        
        
        Intent get=getIntent();
        
  
        
        //user infor
        Intent infor=new Intent(this, userinfor.class);  //new Intent(this, bookbrowse.class)
        infor.putExtra("username", get.getExtras().getString("username"));
        infor.putExtra("userlevel", get.getExtras().getString("userlevel"));
        infor.putExtra("userhead", get.getExtras().getString("userhead"));
        
        // browse
        Intent browse=new Intent(this,bookbrowse.class);
        
        //bus
        
        Intent car=new Intent(this, shoppingcar.class);
        
        
        
        
        tabHost.addTab(tabHost.newTabSpec("Tab1")      
                .setIndicator("商品浏览 ", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(browse));      
        tabHost.addTab(tabHost.newTabSpec("Tab2")      
                .setIndicator("个人中心 ", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(infor));  
        		// .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));  //添加这句话，会使得每次跳转到该页面都是新建一个页面，以往的数据状态会丢失，读者自己可以试验下
        tabHost.addTab(tabHost.newTabSpec("Tab3")      
                .setIndicator("购物车", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(car));    
                            
    }
}