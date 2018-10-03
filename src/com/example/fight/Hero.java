package com.example.fight;

import com.example.fight.R;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class Hero extends Activity implements OnClickListener, android.view.View.OnClickListener {

	Button button1;
	Button button2;
	Button button3;
	Button button4;
	TextView hpHero;
	TextView chkrithero;
	TextView krithero;
	TextView dmghero;
	TextView uppdate;
	TextView money;
	static int hpbl,dmgbl;
	
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.hero);
	    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    button1 = (Button) findViewById(R.id.button1);
	    button1.setOnClickListener(this);
	    
	    button2 = (Button) findViewById(R.id.button2);
	    button2.setOnClickListener(this);
	    
	    button3 = (Button) findViewById(R.id.button3);
	    button3.setOnClickListener(this);
	    
	    button4 = (Button) findViewById(R.id.button4);
	    button4.setOnClickListener(this);
	    button4.setEnabled(false);
	    if (MainActivity.uphero>=10){
			button4.setEnabled(true);
		}
	    
	    hpHero = (TextView) findViewById(R.id.textView1);
	    hpHero.setText("Здоровье: "+MainMenu.Health);
	    
	    uppdate = (TextView) findViewById(R.id.textView7);
	    uppdate.setText("Улучшения: "+MainActivity.uphero);
	    	    
	    chkrithero = (TextView) findViewById(R.id.textView5);
	    chkrithero.setText("Шанс крита: "+MainMenu.KritChanse+"%");
	    
	    dmghero = (TextView) findViewById(R.id.textView2);
	    dmghero.setText("Урон"+MainMenu.Dmgl+"-"+MainMenu.Damage);
	    
	    krithero = (TextView) findViewById(R.id.textView6);
	    krithero.setText("Максимальный урон крита "+MainMenu.KriticalHit);
	    
	    money = (TextView) findViewById(R.id.textView8);
	    money.setText("Деньги: "+MainActivity.moneyHr);
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {
		    case R.id.button1:
		      // TODO Call second activity	      	    
		        Intent intent = new Intent(this, MainMenu.class);		        
		        finish();
		      break;
		      
		    case R.id.button3:
		    	if (MainActivity.uphero>0 && dmgbl<10){
		    		MainMenu.Damage+=1;
		    		MainActivity.uphero-=1;
		    		dmgbl+=1;
					dmghero.setText("Урон 1 - "+MainMenu.Damage);
					uppdate.setText("Улучшения: "+MainActivity.uphero);
		    	}
					else
						button3.setEnabled(false);
					break;
					
		    	case R.id.button2:
					if (MainActivity.uphero>0 && hpbl<100){
						MainMenu.Health+=5;
						MainActivity.uphero-=1;	
						hpbl+=5;
						hpHero.setText("Здоровье: "+MainMenu.Health);
						uppdate.setText("Улучшения: "+MainActivity.uphero);
		    	}
					else 
						button2.setEnabled(false);					
					break;
					case R.id.button4:
						if (MainActivity.uphero>=10){
							MainActivity.uphero-=10;
							Opponent.bonush+=110;
							Opponent.bonusc+=5;
							Opponent.bonusd+=10;
							Opponent.bonusk+=10;
							dmgbl=0;
							hpbl=0;
							button2.setEnabled(true);
							button3.setEnabled(true);
							uppdate.setText("Улучшения: "+MainActivity.uphero);
						}
						else						
								button4.setEnabled(false);
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
