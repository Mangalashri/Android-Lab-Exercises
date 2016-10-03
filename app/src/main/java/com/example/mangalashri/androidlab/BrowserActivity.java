package com.example.mangalashri.androidlab;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.theme;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
       // WebView webView = (WebView)findViewById(R.id.webView);
      //  webView.loadUrl("http://google.com");
       // webView.loadDataWithBaseURL("","<h1>Hello word<h1>","text/html","UTF-8","");
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BrowserActivity.this,"You chose yes",Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BrowserActivity.this,"You chose no",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alert.create();
      //  alertDialog.show();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        String lang[] = {"C","CPP","JAVA","JSON","PYTHON","PHP"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(BrowserActivity.this,android.R.layout.simple_list_item_1,lang);
        autoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
