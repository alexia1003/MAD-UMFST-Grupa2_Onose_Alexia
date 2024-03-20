package com.example.lab6_ex1_mad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPercent = batteryLevel / (float) scale;

        if (batteryPercent < 0.15) {
            Toast.makeText(context, "Battery is low!", Toast.LENGTH_SHORT).show();
        }
    }
}
