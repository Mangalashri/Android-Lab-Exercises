package com.example.mangalashri.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        final EditText editText = (EditText)findViewById(R.id.editText16);
        final EditText editText1 = (EditText)findViewById(R.id.editText17);
        Button button = (Button)findViewById(R.id.button23);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(editText1.getText().toString(),null,editText.getText().toString(),null,null);
            }
        });
    }
}
