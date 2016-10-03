package com.example.mangalashri.androidlab;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        Button button = (Button)findViewById(R.id.button24);
        Button button1 = (Button)findViewById(R.id.button25);
        Button button2 = (Button)findViewById(R.id.button26);
        Button button3 = (Button)findViewById(R.id.button27);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView)findViewById(R.id.listView);
                ArrayList<String> arrayList = new ArrayList<String>();
                Set<BluetoothDevice> set = bluetoothAdapter.getBondedDevices();
                for (BluetoothDevice b: set
                     ) {
                    arrayList.add(b.getName());
                }
                ArrayAdapter a = new ArrayAdapter(BluetoothActivity.this,android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(a);
            }
        });
    }
}
