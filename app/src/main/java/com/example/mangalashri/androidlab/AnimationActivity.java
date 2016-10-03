package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        Button button = (Button)findViewById(R.id.button33);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                ImageView imageView = (ImageView)findViewById(R.id.imageView2);
                imageView.startAnimation(animation);
            }
        });
        Button button1 = (Button)findViewById(R.id.button34);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                ImageView imageView = (ImageView)findViewById(R.id.imageView2);
                imageView.startAnimation(animation);
            }
        });
        Button button2 = (Button)findViewById(R.id.button35);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.zoom);
                ImageView imageView = (ImageView)findViewById(R.id.imageView2);
                imageView.startAnimation(animation);
            }
        });
        Button button3 = (Button)findViewById(R.id.button36);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                ImageView imageView = (ImageView)findViewById(R.id.imageView2);
                imageView.startAnimation(animation);
            }
        });
    }
}
