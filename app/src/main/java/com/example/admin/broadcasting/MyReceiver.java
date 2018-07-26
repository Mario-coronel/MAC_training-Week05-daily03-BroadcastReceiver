package com.example.admin.broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static final String TAG = MyReceiver.class.getSimpleName() + "_TAG";



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: broadcast received");
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
                break;
            case MainActivity.CUSTOME_BROADCAST:
                Toast.makeText(context, "got the sticky  "+MainActivity.CUSTOME_BROADCAST, Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power Adapter connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power Adapter Disconnected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "Battery Low, plug it in", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_BATTERY_OKAY:
                Toast.makeText(context, "Dont worry now the battery is OK", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
