package com.example.onlineradio4;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
 
public class Startupscreen extends Activity {
 
    
	MediaPlayer ourSong;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ourSong=MediaPlayer.create(Startupscreen.this, R.raw.startup);
        SharedPreferences getPrefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music=getPrefs.getBoolean("checkbox", true);
        if(music==true)
        {
        	
        
        ourSong.start();
        }
      
 Thread timer=new Thread()
 {
	@Override
	public void run()
	{
		try
		{
			sleep(11000);
			
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			
			 Intent i = new Intent(Startupscreen.this, Tabbingit.class);
             startActivity(i);
		}
	}
 };
 timer.start();
   
 
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

	
 
}