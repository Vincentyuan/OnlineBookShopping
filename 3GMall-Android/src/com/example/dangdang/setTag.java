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
                .setIndicator("��Ʒ��� ", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(browse));      
        tabHost.addTab(tabHost.newTabSpec("Tab2")      
                .setIndicator("�������� ", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(infor));  
        		// .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));  //�����仰����ʹ��ÿ����ת����ҳ�涼���½�һ��ҳ�棬����������״̬�ᶪʧ�������Լ�����������
        tabHost.addTab(tabHost.newTabSpec("Tab3")      
                .setIndicator("���ﳵ", getResources().getDrawable(R.drawable.ic_launcher))      
                .setContent(car));    
                            
    }
}