package com.example.lab5_ex3_dam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        Contact contact = getIntent().getParcelableExtra("contact");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);
        TextView linkedinTextView = findViewById(R.id.linkedinTextView);

        ImageView photoImageView = findViewById(R.id.photoImageView);
        int photoResourceId = contact.getPhotoResourceId();
        photoImageView.setImageResource(photoResourceId);

        nameTextView.setText(contact.getName() + " " + contact.getSurname());
        phoneTextView.setText(contact.getPhone());
        emailTextView.setText(contact.getEmail());
        addressTextView.setText(contact.getAddress());
        linkedinTextView.setText(contact.getLinkedin());

        Button callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + contact.getPhone()));
                startActivity(callIntent);
            }
        });

        Button editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(ContactActivity.this, EditContactActivity.class);
                editIntent.putExtra("contact", contact);
                startActivity(editIntent);
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteIntent = new Intent();
                deleteIntent.putExtra("deletedContact", contact);
                startActivity(deleteIntent);
                finish();
            }
        });

    }
}
