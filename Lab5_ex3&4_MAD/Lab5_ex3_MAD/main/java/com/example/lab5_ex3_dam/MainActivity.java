package com.example.lab5_ex3_dam;// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contacts;

    // Return view pt. fiecare obiect de tip Contact
    private ArrayAdapter<Contact> adapter;
    private ListView listView;

    private Button addContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();

        // Lista de contacte predefinite
        contacts.add(new Contact("Emma", "York", "123456789", "12 NYC St", "emmayork@example.com", "https://www.linkedin.com/in/emmeyork", R.drawable.emma_photo));
        contacts.add(new Contact("Mom", "", "111122444", "55 Flower St", "", "", R.drawable.mom_photo));
        contacts.add(new Contact("Hanna", "Montana", "987654321", "13 NYC St", "hanna.m@example.com", "https://www.linkedin.com/in/hannamontana", R.drawable.hanna_photo));
        contacts.add(new Contact("Gracie", "Adam", "516895813", "31 Star St", "graciead@example.com", "https://www.linkedin.com/in/gracieadam", R.drawable.gracie_photo));
        contacts.add(new Contact("Bro", "", "116654321", "67 Star St", "", "", R.drawable.bro_photo));
        contacts.add(new Contact("Dad", "", "254786201", "67 Star St", "", "", R.drawable.dad_photo));

        // Initializare list view si adapter
        adapter = new ArrayAdapter<>(this, R.layout.contact, R.id.nameTextView, contacts);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Initializare btn adaugare contact
        addContactButton = findViewById(R.id.addContactButton);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });

        // Initializare btn pt. pagina cu info.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contacts.get(position);
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                intent.putExtra("contact", contact);
                startActivity(intent);
            }
        });
    }

        // Adaugare contact nou la lista cu contacte
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK) {
                // Preluare contact nou din intent si adaugare la lista
                Contact newContact = data.getParcelableExtra("newContact");
                contacts.add(newContact);
                adapter.notifyDataSetChanged();
            }
        }
    }