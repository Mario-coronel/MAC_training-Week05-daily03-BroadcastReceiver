package com.example.admin.broadcasting;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private IntentFilter intentFilter;
    public static final String CUSTOME_BROADCAST = "com.mario.action.CUSTOM_BROADCAST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(CUSTOME_BROADCAST);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);

    }


    public void sendCustomeBroadcast(View view) {
        Intent myBroadcastIntent = new Intent(this, MyReceiver.class);
        myBroadcastIntent.setAction(CUSTOME_BROADCAST);
        sendBroadcast(myBroadcastIntent);

    }

}
