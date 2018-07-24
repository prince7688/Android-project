package com.example.hp.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    private  MediaPlayer mediaPlayer;
    private AudioManager maudiomanager;
    private MediaPlayer.OnCompletionListener mcompletelistner =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    AudioManager.OnAudioFocusChangeListener maudiofocuschangelistner =  new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focuschange) {
            if(focuschange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focuschange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mediaPlayer.pause();
                mediaPlayer.seekTo(10000);
            }
            else if(focuschange==AudioManager.AUDIOFOCUS_GAIN)
            {
                mediaPlayer.start();
            }
            else if(focuschange==AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);

        maudiomanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        ArrayList<Word> arrayList =new ArrayList<Word>();
        arrayList.add(new Word("ONE","lutti",R.drawable.number_one));
        arrayList.add(new Word("Two","otiiko",R.drawable.number_two));
        arrayList.add(new Word("Three","tolookosu",R.drawable.number_three));
        arrayList.add(new Word("Four","oyyisa",R.drawable.number_four));
        arrayList.add(new Word("Five","massokka",R.drawable.number_five));
        arrayList.add(new Word("Six","temmokka",R.drawable.number_six));
        arrayList.add(new Word("Seven","kenekaku",R.drawable.number_seven));
        arrayList.add(new Word("Eight","kawinta",R.drawable.number_eight));
        arrayList.add(new Word("Nine","wo’e",R.drawable.number_nine));
        arrayList.add(new Word("Ten","na’aacha",R.drawable.number_ten));

        Wordaddpter wordaddpter =new Wordaddpter(this,arrayList,R.color.number);
        ListView ls = (ListView)findViewById(R.id.list_item);
        ls.setAdapter(wordaddpter);
        View v = LayoutInflater.from(Numbers.this).inflate(R.layout.list_item, null);
        final ImageView iconimage =(ImageView)v.findViewById(R.id.playicon);
        ls.setOnItemClickListener(  new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();
                int result = maudiomanager.requestAudioFocus(maudiofocuschangelistner,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mediaPlayer = MediaPlayer.create(Numbers.this, R.raw.terimerisong);
                    mediaPlayer.start();
                    iconimage.setImageResource(R.drawable.pause);
                    mediaPlayer.setOnCompletionListener(mcompletelistner);
                }
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            maudiomanager.abandonAudioFocus(maudiofocuschangelistner);
        }
    }
}
