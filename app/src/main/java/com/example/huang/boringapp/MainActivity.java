package com.example.huang.boringapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;
    VideoView videos;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.button);
        play.setOnClickListener(this);
        Button pause = (Button) findViewById(R.id.button2);
        pause.setOnClickListener(this);
        Button test = (Button) findViewById(R.id.button3);
        test.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.textView);
        tv.setOnClickListener(this);
        videos = (VideoView) findViewById(R.id.videoView);
        videos.setVideoPath("/data/video.mp3");

    }


    @Override
    public void onClick(View v) {
        int resId = R.raw.music;
        switch(v.getId()){
            case R.id.button:
                if(mp != null){
                    mp.release();
                }
                mp = MediaPlayer.create(this, resId);
                mp.start();
                break;
            case R.id.button2:
                if(mp.isPlaying()){
                    mp.pause();
                } else {
                    mp.start();
                }
                break;
            case R.id.button3:
                videos.start();
                break;


        }
    }
}
