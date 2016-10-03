package com.example.mangalashri.androidlab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.mangalashri.androidlab.R.id.textView;

public class BroadcastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
             /*   ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar2);
                int l= intent.getIntExtra("level",0);
                progressBar.setProgress(l);
                TextView textView = (TextView)findViewById(R.id.textView17);
                textView.setText(""+l);*/
                Toast.makeText(context,"I'm playing with "+intent.getStringExtra("name"),Toast.LENGTH_LONG).show();
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("play"));
        Button button = (Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("play");
                intent.putExtra("name","mangalashri");
                sendBroadcast(intent);
            }
        });
    }
}
