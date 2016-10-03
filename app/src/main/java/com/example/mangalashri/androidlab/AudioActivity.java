package com.example.mangalashri.androidlab;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {
AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        Button button = (Button)findViewById(R.id.button11);
        Button button2 = (Button)findViewById(R.id.button12);
        Button button3 = (Button)findViewById(R.id.button13);
        Button button4 = (Button)findViewById(R.id.button14);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(audioManager.getRingerMode()){
                    case AudioManager.RINGER_MODE_NORMAL:
                        Toast.makeText(AudioActivity.this,"normal",Toast.LENGTH_SHORT).show();
                        break;
                    case AudioManager.RINGER_MODE_SILENT:
                        Toast.makeText(AudioActivity.this,"silent",Toast.LENGTH_SHORT).show();
                        break;
                    case AudioManager.RINGER_MODE_VIBRATE:
                        Toast.makeText(AudioActivity.this,"vibrate",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
