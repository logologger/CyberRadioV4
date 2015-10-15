package com.example.onlineradio4;
//import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class India extends ListActivity{
Button b;
String classes[]={"MainActivity"};
private final	String channel[]={"Mast FM","Soma FM","Teen Taal","Indian Orthodox Radio","Apna Radio","ApniLsp Radio","RadioAfsana 24/7","EKNoor Radio","Madhur Sangeet Radio","1 FM","Planet RadioCity","Rjashiin","Khalsa FM","tamilislam FM","Sunaada FM","Desi Radio"};
private final	String source_channel[]={"http://64.202.98.32:6220/","http://steady.somafm.com:8850/","http://88.190.53.33:8000/","http://s9.viastreaming.net:9365/","http://www.apnaeradio.com:8100/","http://radio.apniisp.com:9006/","http://174.36.206.197:8198/","http://184.107.202.178:8242/","http://209.9.238.4:9620/","http://72.13.83.68:8017/","http://208.115.222.203:9962/","http://rjashi.in:9966/","http://108.163.223.242:8062/","http://87.117.205.144:8060/","http://188.138.16.143:8140/","http://radio1.desi-radio.com/"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(India.this,android.R.layout.simple_list_item_1,channel));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		// TODO Auto-generated method stub

		super.onListItemClick(l, v, position, id);

		
		String clicked=source_channel[position];
		Intent i=new Intent(India.this,MainActivity.class);
		i.putExtra("source",clicked);
		startActivity(i);

	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.listmenu, menu);
		return true;
		
	}




	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId())
		{
		case R.id.aboutus:
			Intent ii=new Intent("com.example.onlineradio4.ABOUT");
			startActivity(ii);
			break;
		case R.id.prefrences:
			Intent pp=new Intent("com.example.onlineradio4.PREFS");
			startActivity(pp);
			break;
		case R.id.exit:
			finish();
			break;
		}
return false;
	}
}