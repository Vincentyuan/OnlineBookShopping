package com.example.dangdang;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

	
public class userinfor extends Activity {
    /** Called when the activity is first created. */
	private ImageView head;
	private TextView username;
	private TextView  level;
	private Button shoppingcar;
	private Button finishedOrder;
	private Button unfinishedOrder;
	private Button myfavorate;
	private Button bankCard;
	private Button browseHistory;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfor);
        init();
    }

	private void init() {
		// TODO Auto-generated method stub
		head=(ImageView)findViewById(R.id.userinfor_headpicture);
		username=(TextView)findViewById(R.id.userinfor_name_);
		level=(TextView)findViewById(R.id.userinfor_grade_);
		shoppingcar=(Button)findViewById(R.id.goToShoppingCart);
		finishedOrder=(Button)findViewById(R.id.getfinishedPost);
		unfinishedOrder=(Button)findViewById(R.id.getunfinishedPost);
		myfavorate=(Button)findViewById(R.id.userinfor_mylike);
		bankCard=(Button)findViewById(R.id.userinfor_card);
		browseHistory=(Button)findViewById(R.id.userinfor_browseHistory);
		
		
		
		Intent heh=getIntent();
		username.setText(heh.getExtras().getString("username"));
		System.out.println(heh.getExtras().getString("username"));
		level.setText(heh.getExtras().getString("userlevel"));
		
		
		
	}
}