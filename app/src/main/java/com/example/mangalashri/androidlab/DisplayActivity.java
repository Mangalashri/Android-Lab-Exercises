package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView textView = (TextView)findViewById(R.id.textView6);
        TextView textView1 = (TextView)findViewById(R.id.textView7);
        TextView textView2 = (TextView)findViewById(R.id.textView8);
        textView.setText(getIntent().getStringExtra("name"));
        textView1.setText(getIntent().getStringExtra("roll"));
        textView2.setText(getIntent().getStringExtra("dept"));
    }
}
