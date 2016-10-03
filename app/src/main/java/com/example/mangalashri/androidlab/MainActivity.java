package com.example.mangalashri.androidlab;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float s =10;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.sizebutton2);
        final TextView textView = (TextView)findViewById(R.id.textView);

        textView.setTextSize(s);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s+=10;
                textView.setTextSize(s);
                if(s==60)
                    s=10;
            }
        });
        Button button1 = (Button)findViewById(R.id.colbutton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(c) {
                    case 0:
                        textView.setTextColor(Color.BLUE);
                        break;
                    case 1:
                        textView.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        textView.setTextColor(Color.GRAY);
                        break;
                    case 3:
                        textView.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        textView.setTextColor(Color.RED);
                        break;
                    case 5:
                        textView.setTextColor(Color.CYAN);
                        break;
                }
                c=(c+1)%6;
            }
        });
    }
}
