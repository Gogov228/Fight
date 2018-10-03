package com.example.fight;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Opponent extends Activity implements OnClickListener, android.view.View.OnClickListener {

	
	Button button1;
	Button button2;
	TextView hpopp;
	TextView chkritopp;
	TextView dmgopp;
	TextView kritopp;
	TextView update;
	TextView moneyOpp;
	static int chkrit;
	static int kritt;
	static int damage;
	static int hp;
	static int upgrade;
	static int moneyOp;
	static int bonush=100,bonusd=1,bonusc=1,bonusk=10;
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.opponent);
	    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    Random rnd = new Random();
        hp=rnd.nextInt(101)+bonush;
        kritt=rnd.nextInt(50)+bonusk;
        damage=rnd.nextInt(20)+bonusd;
        chkrit=rnd.nextInt(30)+bonusc;
        upgrade=rnd.nextInt(3)+1;
        moneyOp=rnd.nextInt(20)+1;
	    
	    button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(this);
	    
	    button2 = (Button) findViewById(R.id.button2);
	    button2.setOnClickListener(this);
	    
	    hpopp = (TextView) findViewById(R.id.textView1);
	    hpopp.setText("Здоровье: "+hp);
	    
	   
	    chkritopp = (TextView) findViewById(R.id.textView4);
	    chkritopp.setText("Шанс крита: "+chkrit+"%");
	    
	   
	    dmgopp = (TextView) findViewById(R.id.textView2);
	    dmgopp.setText("Урон 1 - "+damage);
	    
	   
	    kritopp = (TextView) findViewById(R.id.textView3);
	    kritopp.setText("Максимальный урон крита "+kritt);
	    
	    update = (TextView) findViewById(R.id.textView6);
	    update.setText("Улучшения: "+upgrade);
	    
	    moneyOpp = (TextView) findViewById(R.id.textView7);
	    moneyOpp.setText("Деньги: "+moneyOp);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	    case R.id.button1:
	      // TODO Call second activity	      	    
	    	AlertDialog.Builder builder  = new AlertDialog.Builder(this);
            builder.setMessage("Вы действительно хотите Избедать бой? (Избежать бой за 10 монет)")
                    .setCancelable(false)
                    .setPositiveButton("Ок",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                   
                                   if (MainActivity.moneyHr>=10){ MainActivity.moneyHr-=10; dialog.cancel();
                                   Intent intent = new Intent(Opponent.this, MainMenu.class);
                       	         finish();}                                
                                   else
                                	   dialog.cancel();                              
                                }
                            })                    
                    .setNegativeButton("Отмена!",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                        int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
			alert.show();
          break;
	        
	    case R.id.button2:
		      // TODO Call second activity	 
	    	Intent intent = new Intent(Opponent.this, MainActivity.class);
	        startActivity(intent);
	        finish();
		    default:
		      break;
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
