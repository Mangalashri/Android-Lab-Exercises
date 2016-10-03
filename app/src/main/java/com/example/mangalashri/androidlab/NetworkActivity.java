package com.example.mangalashri.androidlab;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.data;
import static com.example.mangalashri.androidlab.R.id.textView;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        Button button = (Button)findViewById(R.id.button37);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check()){
                    Toast.makeText(NetworkActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();
                }
                else{
                    new MyAsyncTask().execute();

                }
            }
        });

    }
    boolean check(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] infos = connectivityManager.getAllNetworkInfo();
        for(int i=0;i<infos.length;i++){
            if(infos[i].getState() == NetworkInfo.State.CONNECTED){
                Toast.makeText(NetworkActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
    class MyAsyncTask extends AsyncTask {
        String web;
        @Override
        protected Object doInBackground(Object[] params) {
            try {
                URL url = new URL("http://www.vogella.com");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                web = new String(); String data= new String();
                while((data=reader.readLine())!=null){
                    web += data +"\n";
                }

                Log.d("down",web);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
              TextView textView = (TextView)findViewById(R.id.textView23);
             textView.setText(web);
            super.onPostExecute(o);
        }
    }
}
