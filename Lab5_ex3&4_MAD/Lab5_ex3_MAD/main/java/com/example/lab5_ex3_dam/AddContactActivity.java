package com.example.lab5_ex3_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private EditText emailEditText;
    private EditText linkedinEditText;
    private EditText photoEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        linkedinEditText = findViewById(R.id.linkedinEditText);
        photoEditText = findViewById(R.id.photoEditText);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preluare si introducere info. contacte
                String name = nameEditText.getText().toString().trim();
                String surname = surnameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String linkedin = linkedinEditText.getText().toString().trim();
                String photo = photoEditText.getText().toString().trim();

                // Creare obiect nou tip Contact cu param.
                Contact newContact = new Contact(name, surname, phone, address, email, linkedin, Integer.parseInt(photo));

                // Trimitere contact nou la MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newContact", newContact);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
