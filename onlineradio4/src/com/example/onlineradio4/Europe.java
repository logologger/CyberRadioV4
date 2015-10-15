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

public class Europe extends ListActivity{
Button b;
String classes[]={"MainActivity"};
private final	String channel[]={"Dakta","French","Croatias","ENGLISH Hits","Horizon-fm UK","PQR-UK","Chillout radio GREECE","Spazio radio ITALY"};
private final	String source_channel[]={"http://www.dakta.com:8000/","http://www.radio-g.fr:8000/","http://78.129.143.9:8040/","http://tuner.hit104.com/","http://cp.internet-radio.org.uk:15614/","http://78.129.143.9:8040/","http://live.chilloutradio.gr:8999/ ","http://s6.mediastreaming.it:7190"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Europe.this,android.R.layout.simple_list_item_1,channel));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		// TODO Auto-generated method stub

		super.onListItemClick(l, v, position, id);

		
		String clicked=source_channel[position];
		Intent i=new Intent(Europe.this,MainActivity.class);
		i.putExtra("source",clicked);
		startActivity(i);

		//setContentView(R.layout.mixit);
		
	/*	b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String clicked="http://asculta.danceeffect.ro:3333/";
				Intent i=new Intent(makeit.this,MainActivity.class);
				i.putExtra("source",clicked);
				startActivity(i);
				
			}
		});
	*/
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