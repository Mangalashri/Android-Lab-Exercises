package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText editText = (EditText)findViewById(R.id.editText3);
        final EditText editText1 = (EditText)findViewById(R.id.editText4);
        Button button = (Button)findViewById(R.id.button2);
        Button button1 = (Button)findViewById(R.id.button3);
        Button button2 = (Button)findViewById(R.id.button4);
        Button button3 = (Button)findViewById(R.id.button5);
        final TextView textView = (TextView)findViewById(R.id.textView11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText1.getText().toString());
                textView.setText(a + b +"");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText1.getText().toString());
                textView.setText(a - b +"");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText1.getText().toString());
                textView.setText(a * b +"");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText1.getText().toString());
                textView.setText(a / b +"");
            }
        });
    }
}
