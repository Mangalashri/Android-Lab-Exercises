package com.example.mangalashri.androidlab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.mangalashri.androidlab.R.id.editText4;
import static com.example.mangalashri.androidlab.R.id.textView;

public class LoginActivity extends AppCompatActivity {
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button)findViewById(R.id.button6);
        gencaptcha();
        EditText editText = (EditText)findViewById(R.id.editText5);
        EditText editText1 = (EditText)findViewById(R.id.editText6);
        EditText editText2 = (EditText)findViewById(R.id.editText7);
        EditText editText3 = (EditText)findViewById(R.id.editText8);
        EditText editText4 = (EditText)findViewById(R.id.editText9);
        EditText editText5 = (EditText)findViewById(R.id.editText10);
        SharedPreferences sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        if(!sharedPreferences.getString("name","").equals("")){
            startActivity(new Intent(LoginActivity.this,DetailsActivity.class));
        }
        editText.setText(sharedPreferences.getString("name",""));
        editText4.setText(sharedPreferences.getString("pass",""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editText5);
                EditText editText1 = (EditText)findViewById(R.id.editText6);
                EditText editText2 = (EditText)findViewById(R.id.editText7);
                EditText editText3 = (EditText)findViewById(R.id.editText8);
                EditText editText4 = (EditText)findViewById(R.id.editText9);
                EditText editText5 = (EditText)findViewById(R.id.editText10);

                if(!Patterns.PHONE.matcher(editText1.getText().toString()).matches()){
                    Toast.makeText(LoginActivity.this,"phone not valid",Toast.LENGTH_SHORT).show();
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(editText2.getText().toString()).matches()){
                    Toast.makeText(LoginActivity.this,"email not valid",Toast.LENGTH_SHORT).show();
                }
                if(!editText4.getText().toString().equals(editText3.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Pass shud be same",Toast.LENGTH_SHORT).show();
                }
                if(editText.length() == 0 ||editText1.length() == 0 ||editText2.length() == 0 ||editText3.length() == 0  ){
                    Toast.makeText(LoginActivity.this,"Fill all",Toast.LENGTH_SHORT).show();
                }
                if(!editText5.getText().toString().equals(c)){

                    Log.d("cap",c);
                    Toast.makeText(LoginActivity.this,"Wrong captcha",Toast.LENGTH_SHORT).show();
                }
                SharedPreferences sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("name",editText.getText().toString());
                editor.putString("pass",editText4.getText().toString());
                editor.commit();

            }
        });
        Button button1 = (Button)findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gencaptcha();
            }
        });
    }

    private void gencaptcha() {
        String s = new String();
        int a = Math.abs(new Random().nextInt())%60;
        for(int i=0;i<5;i++) {
            if (a < 26) {
                s = s + (char)(65 + a);
            } else if (a < 52) {
                s = s + (char)(97 + (a - 26));
            } else {
                s = s + (char)(48 + (a - 52));
            }
            a = Math.abs(new Random().nextInt())%60;
        }
        c = s;
        TextView textView = (TextView) findViewById(R.id.textView15);
        textView.setText(s);
    }
}
