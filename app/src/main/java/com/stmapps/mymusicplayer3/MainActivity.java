package com.stmapps.mymusicplayer3;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int posInSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void playSong (View view) {
        if ( mp == null) {
            mp = MediaPlayer.create(this, R.raw.song03);
            mp.start();
            Toast.makeText(this, "play", Toast.LENGTH_SHORT).show();
        } else if( !mp.isPlaying()) {
            mp.seekTo(posInSong);
            mp.start();
            Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
        }
    }

    public void pauseSong(View view) {
        if ( mp != null) {
            mp.pause();
            posInSong = mp.getCurrentPosition();
            Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show();
        }
    }

    public void stopSong(View view) {
        if ( mp != null) {
            mp.stop();
            mp=null;
            Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show();
        }
    }
}
