package com.example.mangalashri.androidlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final EditText editText1 = (EditText)findViewById(R.id.editText2);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final String d[] = {"CSE", "ECE"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DetailsActivity.this,android.R.layout.simple_spinner_item,d);
        spinner.setAdapter(arrayAdapter);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0 ||editText1.length() == 0  ){
                    Toast.makeText(DetailsActivity.this,"Fill all",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(DetailsActivity.this,DisplayActivity.class);
                    intent.putExtra("name",editText.getText().toString());
                    intent.putExtra("roll",editText1.getText().toString());
                    intent.putExtra("dept",d[spinner.getSelectedItemPosition()]);
                    startActivity(intent);
                }
            }
        });
    }
}
