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

public class Latin extends ListActivity{
Button b;
String classes[]={"MainActivity"};
private final	String channel[]={"Nasyidfm","asculta-dance","DeepBasssine","Netyco","Rhema Radio","Jakarta Radio","3Sinhala Web Radio","Gomo FM","All Jazz Radio"," RADIO VIVA PORTUGAL","Russian FM","RADIO SOUND POP - BRASIL"};
private final	String source_channel[]={"http://radio.nasyidfm.com.my:8000/","http://asculta.danceeffect.ro:3333/","http://www.deepbassnine.com:16504/","http://radio2.netyco.com:8030/","http://rhemafm.japanserver.info:8002/","http://radiozone.indostreamserver.com:8052/","http://66.90.103.189:8888/","http://72.20.10.50:8000/","http://85.25.164.50/","http://173.236.29.50:8550/","http://radio.russianfm.de:8000/","http://s4.voscast.com:7746/"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Latin.this,android.R.layout.simple_list_item_1,channel));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		// TODO Auto-generated method stub

		super.onListItemClick(l, v, position, id);

		
		String clicked=source_channel[position];
		Intent i=new Intent(Latin.this,MainActivity.class);
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