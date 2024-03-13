package com.example.lab5_ex3_dam;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private EditText emailEditText;
    private EditText linkedinEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact_activity);

        // Initializare EditText
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        linkedinEditText = findViewById(R.id.linkedinEditText);

        // Preluare obiecte contact de la activitatea anterioara
        Contact contact = getIntent().getParcelableExtra("contact");

        // Scriere in EditText info. actualizate
        nameEditText.setText(contact.getName());
        surnameEditText.setText(contact.getSurname());
        phoneEditText.setText(contact.getPhone());
        addressEditText.setText(contact.getAddress());
        emailEditText.setText(contact.getEmail());
        linkedinEditText.setText(contact.getLinkedin());
    }
}
