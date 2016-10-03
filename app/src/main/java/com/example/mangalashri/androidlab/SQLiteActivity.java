package com.example.mangalashri.androidlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteActivity extends AppCompatActivity {
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        final EditText editText = (EditText)findViewById(R.id.editText13);
        final EditText editText1 = (EditText)findViewById(R.id.editText14);
        final EditText editText2 = (EditText)findViewById(R.id.editText15);

        Button button = (Button)findViewById(R.id.button18);
        Button button1 = (Button)findViewById(R.id.button19);
        Button button2 = (Button)findViewById(R.id.button20);
        Button button3 = (Button)findViewById(R.id.button21);
        Button button4 = (Button)findViewById(R.id.button22);

        database =openOrCreateDatabase("student",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS STUDENT(ROLL VARCHAR, NAME VARCHAR, MARK VARCHAR);");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length() ==0 || editText1.getText().toString().length() ==0 ||editText2.getText().toString().length() ==0)
                    show("Error","Fill all fields");
                else{
                    String roll = editText.getText().toString();
                    String name =editText1.getText().toString();
                    String mark = editText2.getText().toString();
                    database.execSQL("INSERT INTO STUDENT VALUES('"+roll+"','"+name+"','"+mark+"');");
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()==0)
                    show("Error","Enter roll");
                else {
                    database.execSQL("DELETE FROM STUDENT WHERE ROLL='"+editText.getText().toString()+"';");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()==0)
                    show("Error","Enter roll");
                else {
                    database.execSQL("UPDATE STUDENT SET NAME='"+editText1.getText().toString()+"',MARK='"+editText2.getText().toString()+"' WHERE ROLL='"+editText.getText().toString()+"';");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length()==0)
                    show("Error","Enter roll");
                else {
                    Cursor c = database.rawQuery("SELECT * from STUDENT WHERE ROLL='"+editText.getText().toString()+"';",null);
                    if(c.moveToFirst()){
                        editText1.setText(c.getString(1));
                        editText2.setText(c.getString(2));
                    }
                    else{
                        show("Error","Invalid roll");
                    }
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = database.rawQuery("SELECT * from STUDENT;",null);
                StringBuffer s = new StringBuffer();
                while(c.moveToNext()){
                    s.append("Roll: "+c.getString(0)+"\n");
                    s.append("Name: "+c.getString(1)+"\n");
                    s.append("Mark: "+c.getString(2)+"\n\n");

                }
                show("Details", s.toString());
            }
        });
    }

    private void show(String error, String s) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(error);
        b.setMessage(s);
        b.setCancelable(true);
        b.show();
    }
}
