package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","ondestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","restart");
    }
}
