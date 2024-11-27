package com.nazira.class224;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgPlay1;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPlay1 = findViewById(R.id.imgPlay1);

        imgPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              if (imgPlay1.getTag()!=null && imgPlay1.getTag().toString().contains("NOT_PLAYING")) {

                  if (mediaPlayer!=null) mediaPlayer.release();

                  mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.song_1);
                  mediaPlayer.start();

                  imgPlay1.setImageResource(R.drawable.stop);
                  imgPlay1.setTag("PLAYING_NOW");

                  mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                      @Override
                      public void onCompletion(MediaPlayer mediaPlayer) {

                          imgPlay1.setImageResource(R.drawable.play);
                          imgPlay1.setTag("NOT_PLAYING");
                      }
                  });

              }else {

                  if (mediaPlayer!=null) mediaPlayer.release();

                  imgPlay1.setImageResource(R.drawable.play);
                  imgPlay1.setTag("NOT_PLAYING");
              }




            }
        });

    }
}