package com.example.fight;



import java.util.ArrayList;
import java.util.Random;

import android.R.string;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity implements OnClickListener{
	ArrayList<CheckBox> alCB;
	TextView textView1;
	TextView textView2;
	TextView textView3;
	CheckBox d_head;
	CheckBox d_upbody;
	CheckBox d_lbody;
	CheckBox d_legs;
	Button button3;
	Button button1;
	Button button2;
	RadioGroup radiogroup;
	int[] p1def,p2def;
	int p1at,p2at;
	int p2hp,krit2,dmg2,kritch2,krit,dmg,kritch,p1hp,upp;
	static int uphero;
	static int moneyHr=50;
	String str;
	private int countCheck = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);		
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 alCB = new ArrayList<CheckBox>();
		 krit = MainMenu.KriticalHit;
		 kritch = MainMenu.KritChanse;
		 dmg = MainMenu.Damage;
		 p1hp = MainMenu.Health;
		 p2hp = Opponent.hp;
		 krit2 = Opponent.kritt;
		 dmg2 = Opponent.damage;
		kritch2 = Opponent.chkrit;
		upp = Opponent.upgrade;
		 
		button1 = (Button) findViewById(R.id.hit);
        button1.setOnClickListener(this);
        
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        
        
        d_head = (CheckBox)findViewById(R.id.d_head);
        d_head.setOnClickListener(this);
        alCB.add(d_head);
        d_upbody = (CheckBox)findViewById(R.id.d_upbody);
        d_upbody.setOnClickListener(this);
        alCB.add(d_upbody);
        d_lbody = (CheckBox)findViewById(R.id.d_lbody);
        d_lbody.setOnClickListener(this);
        alCB.add(d_lbody);
        d_legs = (CheckBox)findViewById(R.id.d_legs);
        d_legs.setOnClickListener(this);
        alCB.add(d_legs);
        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(" "+p1hp);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(" "+p2hp);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Мы нанесли "+0+ "  ||  Нам нанесли "+0);
        
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    		
    		@Override
    		public void onCheckedChanged(RadioGroup group, int checkedId) {
    			// TODO Auto-generated method stub
    			switch (checkedId) {

    			case R.id.radio0: p1at = 0;
    				
    			break;
    			case R.id.radio1: p1at = 1;
    				
    				break;
    			case R.id.radio2: p1at = 2;
    				
    				break;
    			case R.id.radio3: p1at = 3;
    				
    				break;

    			default:
    				break;
    			}
    		}
    	});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	


	@Override
	public void onClick(View v) {
		
	    //Intent intent = new Intent(MainActivity.this, MainMenu.class);
	   // startActivity(intent);
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.hit:			
			p1def = new int[4];
			if(d_head.isChecked()) p1def[0] = 1;
			if(d_upbody.isChecked()) p1def[1] = 1;
			if(d_lbody.isChecked()) p1def[2] = 1;
			if(d_legs.isChecked()) p1def[3] = 1;
			////////////////////////////////////////////////////
			///////////////////////////////////////////////////
	
		
			/////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		
			Random rnd = new Random();
			Random rnd2 = new Random();
	        p2at=rnd.nextInt(4);
	        int dtmp=rnd2.nextInt(5);
		switch (dtmp){
		case 0: p2def = new int [] {1,1,0,0}; break;
		case 1: p2def = new int [] {1,0,1,0}; break;
		case 2: p2def = new int [] {1,0,0,1}; break;
		case 3: p2def = new int [] {0,1,1,0}; break;
		case 4: p2def = new int [] {0,1,0,1}; break;
		case 5: p2def = new int [] {0,0,1,1}; break;
		}
		
		
		
		//______________________________
		//p1 to p2
		int d1=0,d2=0;
		if ((p1hp>0) && (p2hp>0))
		{

		if (p2def[p1at]==0) {d1 =damage(MainMenu.Dmgl,dmg,kritch,krit); p2hp -= d1 ;}
		//p2 to p1
		if (p1def[p2at]==0) {d2 =damage(1,dmg2,kritch2,krit2); p1hp -= d2 ;}		
		}
		if (p1hp>0)
			
		textView1.setText(" "+p1hp);
		else
		{textView1.setText("Нокаут");
		button2.setVisibility(button2.VISIBLE);
		button1.setVisibility(button1.INVISIBLE);
		str="Ну ты чё действительно как фуфел? Сходи передохни и опять в бой";
		}
		if (p2hp>0)
		textView2.setText(" "+p2hp);
		else
		{textView2.setText("Нокаут");
		button2.setVisibility(button2.VISIBLE);
		button1.setVisibility(button1.INVISIBLE);
		uphero += upp;
		moneyHr+=Opponent.moneyOp;
		str="Чётко подрался, теперь сходи передохни и улучши свои навыки";
		}
	    
		textView3.setText("Мы нанесли "+d1+ "  ||  Нам нанесли "+d2);  
	    				break;
			
		
		case R.id.button2:
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("Изменение характеристик")
					.setMessage(str)
					.setCancelable(false)
					.setNegativeButton("ОК",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									Intent intent = new Intent(MainActivity.this, MainMenu.class);							       
									dialog.cancel();
									finish();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
			break;
			
		
		case R.id.d_head:
			checkCheck(d_head);
			break;
		case R.id.d_upbody:
			checkCheck(d_upbody);
			break;
		case R.id.d_lbody:
			checkCheck(d_lbody);
			break;
		case R.id.d_legs:
			checkCheck(d_legs);
			break;
		default:
	}
}
	private void checkCheck(CheckBox cb){
		if(cb.isChecked()){
			countCheck++;
			blockCheck();
		}else{
			countCheck--;
			blockCheck();
		}
	}
	
	private void blockCheck(){
		for (CheckBox cb : alCB) {
			if(cb.isChecked()==false && countCheck==2){
				cb.setClickable(false);
			}else{
				cb.setClickable(true);
			}
		}
	}
	private int damage(int basic_dmg_l, int basic_dmg_h, int crit_chance, int crit_dmg)
	{
		Random rnd1 = new Random();
		Random rnd2 = new Random();
		int dmg = (rnd1.nextInt(basic_dmg_h - basic_dmg_l + 1) + basic_dmg_l);
		if (rnd2.nextInt(100)+1 <= crit_chance) 
			return (dmg + crit_dmg);
		else 
			return dmg;	
	}
	
	/*private int state(static int health,static int damage, static int chkrit, static int dmgkrit)
	{
		Random rnd = new Random();
		health=rnd.nextInt(101)+100;
		damage=rnd.nextInt(50)+10;
		chkrit=rnd.nextInt(30)+1;
		dmgkrit=rnd.nextInt(30)+1;
	}
	*/
	
	@Override
	public void onBackPressed(){
		
	}
	
}
