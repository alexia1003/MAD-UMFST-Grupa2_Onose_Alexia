package com.example.lab6_ex5_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button verifyFaceBtn = findViewById(R.id.btn_verify_face);
        Button generateOTPBtn = findViewById(R.id.btn_generate_otp);
        Button voteBtn = findViewById(R.id.btn_vote);
        Button adminBtn = findViewById(R.id.btn_admin_mode);


        verifyFaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFace();
            }
        });

        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateOTP();
            }
        });

        voteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote();
            }
        });
    }

    private void verifyFace() {
        //
    }

    private void generateOTP() {
        //
    }

    private void vote() {
        Intent intent = new Intent(MainActivity.this, VotingOptionsActivity.class);
        startActivity(intent);
    }

    public void switchToAdminMode(View view) {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}
