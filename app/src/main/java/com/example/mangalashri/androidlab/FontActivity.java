package com.example.mangalashri.androidlab;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
        TextView textView = (TextView)findViewById(R.id.textView21);
        TextView textView1 = (TextView)findViewById(R.id.textView22);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Amatic-Bold.ttf");
        textView.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        textView1.setTypeface(typeface1);
    }
}
