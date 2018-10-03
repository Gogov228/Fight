package com.example.fight;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Shop extends Activity implements OnClickListener, android.view.View.OnClickListener{

 Button button1;
 Button button2;
 Button button3;
 Button button4;
 Button button5;
 Button button6;
 Button button7;
 Button button8;
 Button button9;
 static int[] check =  new int[9];
  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.shop);
    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(this);
    if (check[0]==1)
    	button1.setEnabled(false);	
    button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(this);
    if (check[1]==1)
    	button2.setEnabled(false);
    button3 = (Button) findViewById(R.id.button3);
    button3.setOnClickListener(this);
    if (check[2]==1)
    	button3.setEnabled(false);
    button4 = (Button) findViewById(R.id.button4);
    button4.setOnClickListener(this);
    if (check[3]==1)
    	button4.setEnabled(false);
    button5 = (Button) findViewById(R.id.button5);
    button5.setOnClickListener(this);
    if (check[4]==1)
    	button5.setEnabled(false);
    button6 = (Button) findViewById(R.id.button6);
    button6.setOnClickListener(this);
    if (check[5]==1)
    	button6.setEnabled(false);
    button7 = (Button) findViewById(R.id.button7);
    button7.setOnClickListener(this);
    if (check[6]==1)
    	button7.setEnabled(false);
    button8 = (Button) findViewById(R.id.button8);
    button8.setOnClickListener(this);
    if (check[7]==1)
    	button8.setEnabled(false);
    button9 = (Button) findViewById(R.id.button9);
    button9.setOnClickListener(this);
    if (check[8]==1)
    	button9.setEnabled(false);
    
  }
  
  
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId()) {
	 case R.id.button1:
		 if (MainActivity.moneyHr>=70){
			 MainMenu.Damage+=10;  
			 MainActivity.moneyHr-=70;
			button1.setEnabled(false); 
			check[0]=1;
		 }
		 break;
	 case R.id.button2:
		 if (MainActivity.moneyHr>=165){
			 MainMenu.Dmgl+=15;  
			 MainMenu.KriticalHit+=10;
			 button2.setEnabled(false);
			 check[1]=1;
			 MainActivity.moneyHr-=165;
		 }
		 break;
	 case R.id.button3:
		 if (MainActivity.moneyHr>=115){
			 MainMenu.Damage+=5; 
			 MainMenu.Health+=50;
			 button3.setEnabled(false);
			 check[2]=1;
			 MainActivity.moneyHr-=115;
		 }
		 break;
	 case R.id.button4:
		 if (MainActivity.moneyHr>=200){
			 MainMenu.KritChanse+=10;
			 button4.setEnabled(false);
			 check[3]=1;
			 MainActivity.moneyHr-=200;
		 }
		 break;
	 case R.id.button5:
		 if (MainActivity.moneyHr>=228){
			 MainMenu.KritChanse+=5;
			 MainMenu.Health+=5;
			 MainMenu.Damage+=5;
			 MainMenu.Dmgl+=5;
			 MainMenu.KriticalHit+=5;
			 button5.setEnabled(false);
			 check[4]=1;
			 MainActivity.moneyHr-=228;
		 }
		 break;
	 case R.id.button6:
		 if (MainActivity.moneyHr>=210){
			 MainMenu.Health+=100; 
			 MainMenu.Damage+=7;
			 button6.setEnabled(false);
			 check[5]=1;
			 MainActivity.moneyHr-=210;
		 }
		 break;
	 case R.id.button7:
		 if (MainActivity.moneyHr>=290){
			 MainMenu.Dmgl+=20;
			 MainMenu.KriticalHit+=20;
			 button7.setEnabled(false);
			 check[6]=1;
			 MainActivity.moneyHr-=290;
		 }
		 break;
	 case R.id.button8:
		 if (MainActivity.moneyHr>=320){
			 MainMenu.KritChanse+=15; 
			 MainMenu.Damage+=25;			 
			 button8.setEnabled(false);
			 check[7]=1;
			 MainActivity.moneyHr-=320;
		 }
	 case R.id.button9:
		 if (MainActivity.moneyHr>=400){
			 MainMenu.Damage+=30;
			 MainMenu.KritChanse+=7;
			 MainMenu.KriticalHit+=20;
			 button9.setEnabled(false);
			 check[8]=1;
			 MainActivity.moneyHr-=400;
		 }
	 default:
			break;
		 }

	}	
	


@Override
public void onClick(DialogInterface dialog, int which) {
	// TODO Auto-generated method stub
	
}
}
