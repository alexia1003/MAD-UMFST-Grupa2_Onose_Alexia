package com.example.lab5_ex1_mad;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button hiBtn;
    private Button urlBtn;
    private Button telBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hiBtn = findViewById(R.id.hi_button);
        urlBtn = findViewById(R.id.url_button);
        telBtn = findViewById(R.id.tel_button);

        hiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextActivity.class);
                startActivity(intent);
            }
        });

        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        telBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 0744957136"));
                startActivity(intent);
            }
        });
    }
}
