package com.example.lab4ex2_dam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    Button introButton;
    Button chap1Button;
    Button chap2Button;
    Button chap3Button;
    Button chap4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introButton = findViewById(R.id.introButton);
        chap1Button = findViewById(R.id.chap1Button);
        chap2Button = findViewById(R.id.chap2Button);
        chap3Button = findViewById(R.id.chap3Button);
        chap4Button = findViewById(R.id.chap4Button);

        introButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Introduction_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("intro")
                        .commit();
            }
        });

        chap1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Chapter1_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("chap1")
                        .commit();
            }
        });

        chap2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Chapter2_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("chap2")
                        .commit();
            }
        });

        chap3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Chapter3_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("chap3")
                        .commit();
            }
        });

        chap4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, Chapter4_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("chap4")
                        .commit();
            }
        });
    }
}
