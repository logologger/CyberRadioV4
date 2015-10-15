package com.example.onlineradio4;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabbingit extends TabActivity{
	

			
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				super.onCreate(savedInstanceState);
				setContentView(R.layout.tabbed);
				TabHost tabHost = getTabHost();
		         
		        // Tab for Photos
		        TabSpec photospec = tabHost.newTabSpec("EUROPE");
		        // setting Title and Icon for the Tab
		     photospec.setIndicator("Europe", getResources().getDrawable(R.drawable.ic_launcher));
		        Intent photosIntent = new Intent(this, Europe.class);
		        photospec.setContent(photosIntent);
		         
		        // Tab for Songs
		        TabSpec songspec = tabHost.newTabSpec("INDIA");        
		        songspec.setIndicator("India-desi", getResources().getDrawable(R.drawable.ic_launcher));
		        Intent songsIntent = new Intent(this, India.class);
		        songspec.setContent(songsIntent);
		         
		        // Tab for Videos
		        TabSpec videospec = tabHost.newTabSpec("LATIN");
		      videospec.setIndicator("Others", getResources().getDrawable(R.drawable.ic_launcher));
		        Intent videosIntent = new Intent(this, Latin.class);
		        videospec.setContent(videosIntent);
		        
		        TabSpec listspec = tabHost.newTabSpec("LISTIT");
			      listspec.setIndicator("America", getResources().getDrawable(R.drawable.ic_launcher));
			        Intent listIntent = new Intent(this, makeit.class);
			        listspec.setContent(listIntent);
		        // Adding all TabSpec to TabHost
		        tabHost.addTab(photospec); // Adding photos tab
		        tabHost.addTab(songspec); // Adding songs tab
		        tabHost.addTab(videospec);
		        tabHost.addTab(listspec);// Adding videos tab
			}

}