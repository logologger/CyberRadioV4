package com.example.onlineradio4;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;



import java.io.File;
import java.io.IOException;






import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.media.MediaPlayer.OnBufferingUpdateListener;

import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaRecorder.OnInfoListener;

import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import android.widget.ProgressBar;



public class MainActivity extends Activity implements OnClickListener {
	protected PowerManager.WakeLock mWakeLock;
	
	


    private ProgressBar playSeekBar;

    public String s="http://asculta.danceeffect.ro:3333/";

 
private ImageButton buttonPlay;



private String s_c;

    private MediaPlayer player;
	private static final String AUDIO_RECORDER_FILE_EXT_3GP = ".3gp";
	private static final String AUDIO_RECORDER_FILE_EXT_MP4 = ".mp4";
	private static final String AUDIO_RECORDER_FOLDER = "AudioRecorder";
	private MediaRecorder recorder = null;
	private int currentFormat = 0;



    @Override

    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();
     

        Intent intent=getIntent();
       s_c=intent.getExtras().getString("source");

        initializeUIElements();



        initializeMediaPlayer();

    }
    



    private void initializeUIElements() {



        playSeekBar = (ProgressBar) findViewById(R.id.progressBar1);

        playSeekBar.setMax(100);

        playSeekBar.setVisibility(View.INVISIBLE);



        buttonPlay = (ImageButton) findViewById(R.id.imageButton1);

        buttonPlay.setOnClickListener(this);






    }



    @Override
	public void onClick(View v) {

        if (player.isPlaying()) {

            stopPlaying();

        } else {

            startPlaying();

        }

    }



    private void startPlaying() {



buttonPlay.setBackgroundResource(R.drawable.stop);
        playSeekBar.setVisibility(View.VISIBLE);



        player.prepareAsync();



        player.setOnPreparedListener(new OnPreparedListener() {



            @Override
			public void onPrepared(MediaPlayer mp) {

                player.start();

            }

        });



    }



    private void stopPlaying() {

    	buttonPlay.setBackgroundResource(R.drawable.start);
        if (player.isPlaying()) {

            player.stop();

            player.release();

            initializeMediaPlayer();

        }




        playSeekBar.setVisibility(View.INVISIBLE);

    }



    private void initializeMediaPlayer() {

        player = new MediaPlayer();

        try {

            player.setDataSource(s_c);

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

        } catch (IllegalStateException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }



        player.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {



            @Override
			public void onBufferingUpdate(MediaPlayer mp, int percent) {

                playSeekBar.setSecondaryProgress(percent);

                Log.i("Buffering", "" + percent);

            }

        });

    }



    @Override

    protected void onPause() {

        super.onPause();

        if (player.isPlaying()) {

            player.stop();

        }

    }
   
    @Override
    public void onDestroy() {
        this.mWakeLock.release();
        super.onDestroy();
    }




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.main, menu);
		return true;
		
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig); 
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
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
