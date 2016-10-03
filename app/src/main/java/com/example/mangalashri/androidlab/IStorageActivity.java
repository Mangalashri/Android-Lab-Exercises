package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istorage);
        final EditText editText =(EditText)findViewById(R.id.editText12);
        Button button = (Button)findViewById(R.id.button16);
        Button button1 = (Button)findViewById(R.id.button17);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("myfile.txt",MODE_WORLD_READABLE);
                    fileOutputStream.write(editText.getText().toString().getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput("myfile.txt");
                    int c = fileInputStream.read();
                    String s = new String();
                    while(c!=-1){
                        s = s + Character.toString((char)c);
                        c = fileInputStream.read();
                    }
                    TextView textView = (TextView)findViewById(R.id.textView16);
                    textView.setText(s);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
