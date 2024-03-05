package com.example.lab4ex1_dam;

import static java.lang.String.valueOf;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button addButton;
    Button subButton;
    Button divButton;
    Button mulButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        divButton = findViewById(R.id.divButton);
        mulButton = findViewById(R.id.mulButton);
        resultTextView = findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(editText1.getText().toString());
                float number2 = Float.parseFloat(editText2.getText().toString());

                float result = number1 + number2;
                resultTextView.setText(valueOf(result));
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(editText1.getText().toString());
                float number2 = Float.parseFloat(editText2.getText().toString());

                float result = number1 - number2;
                resultTextView.setText(valueOf(result));
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(editText1.getText().toString());
                float number2 = Float.parseFloat(editText2.getText().toString());

                float result = number1 / number2;
                resultTextView.setText(valueOf(result));
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(editText1.getText().toString());
                float number2 = Float.parseFloat(editText2.getText().toString());

                float result = number1 * number2;
                resultTextView.setText(valueOf(result));
            }
        });

    }
}
