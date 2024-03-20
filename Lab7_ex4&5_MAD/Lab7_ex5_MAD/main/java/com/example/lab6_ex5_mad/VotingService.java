package com.example.lab6_ex5_mad;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class VotingService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Voting process started", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Voting in progress...", Toast.LENGTH_LONG).show();

        stopSelf();

        return START_NOT_STICKY;
    }
}
