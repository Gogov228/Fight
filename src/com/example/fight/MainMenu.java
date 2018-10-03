package com.example.fight;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener, android.view.View.OnClickListener {

	Button button1;
	Button button2;
	Button button3;
	Button button4;
	static int Health=150; 
	static int Damage=10;
	static int KritChanse=15;
	static int KriticalHit=30;
	static int Dmgl=1;
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.menu);
	    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(this);
	    button2 = (Button) findViewById(R.id.button2);
	    button2.setOnClickListener(this);
	    button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
	    button4.setOnClickListener(this);
	  }
	@Override
	  public void onClick(View v) {
	    switch (v.getId()) {
	    case R.id.button1:
	      // TODO Call second activity	      	    
	        Intent intent = new Intent(this, Opponent.class);
	        startActivity(intent);	
	        break;
	        
	        
	      
	    case R.id.button2:
		      // TODO Call second activity	      	    
		        Intent intent1 = new Intent(this, Hero.class);
		        startActivity(intent1);
		      break;
	      
	    case R.id.button3:
	    	MainMenu.this.finish();
	    	break;
	    case R.id.button4:
	    	Intent intent2 = new Intent(this, Shop.class);
	        startActivity(intent2);
	    }
	  }
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBackPressed(){
		
	}
}
