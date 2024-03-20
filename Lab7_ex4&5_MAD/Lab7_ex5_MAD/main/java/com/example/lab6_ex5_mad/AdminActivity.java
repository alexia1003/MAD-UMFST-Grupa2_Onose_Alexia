package com.example.lab6_ex5_mad;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        Button createScheduleVotingBtn = findViewById(R.id.btn_create_schedule_voting);
        createScheduleVotingBtn.setOnClickListener(view -> createAndScheduleVoting());
    }

    private void createAndScheduleVoting() {
        scheduleVotingEvent(5);
    }

    private void scheduleVotingEvent(int seconds) {
        long currentTimeMillis = System.currentTimeMillis();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.add(Calendar.SECOND, seconds);

        Intent intent = new Intent(this, VotingService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            Toast.makeText(this, "Voting scheduled successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to schedule voting", Toast.LENGTH_SHORT).show();
        }
    }
}
