package com.example.mangalashri.androidlab;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class T2SActivity extends AppCompatActivity {
     TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2_s);
        textToSpeech = new TextToSpeech(T2SActivity.this, new  TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.UK);
            }
        });
        final EditText editText = (EditText)findViewById(R.id.editText11);
        Button button = (Button)findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}
