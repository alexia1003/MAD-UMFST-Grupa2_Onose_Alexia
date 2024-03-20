package com.example.lab6_ex2_mad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView TimeTextView;
    private Button startStopButton;
    private Button resetButton;

    private boolean isRunning = false;
    private int seconds = 0;
    private final Handler handler = new Handler();

    private final Runnable runnable = new Runnable() {
        @Override
    public void run() {
        seconds++;
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        TimeTextView.setText(String.format("%02d:%02d:%02d", h, m, s));
        handler.postDelayed((Runnable) this, 1000);
    }
};

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeTextView = findViewById(R.id.TimeTextView);
        startStopButton = findViewById(R.id.startStopButton);
        resetButton = findViewById(R.id.resetButton);

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    handler.removeCallbacks(runnable);
                    startStopButton.setText("Start");
                } else {
                    handler.post(runnable);
                    startStopButton.setText("Stop");
                }
                isRunning = !isRunning;
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                isRunning = false;
                seconds = 0;
                TimeTextView.setText("00:00:00");
                startStopButton.setText("Start");
            }
        });

    }
}