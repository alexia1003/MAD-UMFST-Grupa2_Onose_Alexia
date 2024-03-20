package com.example.lab6_ex4_mad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ParticipantService participantService;
    private List<Participant> participantList;
    private List<Participant> filteredList;

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText scoreEditText;
    private Button addParticipantButton;
    private Button updateParticipantButton;
    private Button deleteParticipantButton;
    private Button filterButton;
    private Button sortButton;
    private ListView participantListView;
    private Spinner sortCriteriaSpinner;
    private Spinner sortOrderSpinner;

    private Participant selectedParticipant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        participantService = new ParticipantService();
        participantList = new ArrayList<>();
        filteredList = new ArrayList<>();

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        scoreEditText = findViewById(R.id.scoreEditText);
        addParticipantButton = findViewById(R.id.addParticipantButton);
        updateParticipantButton = findViewById(R.id.updateParticipantButton);
        deleteParticipantButton = findViewById(R.id.deleteParticipantButton);
        filterButton = findViewById(R.id.filterButton);
        sortButton = findViewById(R.id.sortButton);
        participantListView = findViewById(R.id.participantListView);
        sortCriteriaSpinner = findViewById(R.id.sortCriteriaSpinner);
        sortOrderSpinner = findViewById(R.id.sortOrderSpinner);

        addParticipantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addParticipant();
            }
        });

        updateParticipantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateParticipant();
            }
        });

        deleteParticipantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteParticipant();
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterParticipants();
            }
        });

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortParticipants();
            }
        });

        ArrayAdapter<Participant> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, participantList);
        participantListView.setAdapter(adapter);

        participantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedParticipant = participantList.get(position);
                setSelectedParticipant(selectedParticipant);
            }
        });

        ArrayAdapter<CharSequence> criteriaAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_criteria_array, android.R.layout.simple_spinner_item);
        criteriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortCriteriaSpinner.setAdapter(criteriaAdapter);

        ArrayAdapter<CharSequence> orderAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_order_array, android.R.layout.simple_spinner_item);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortOrderSpinner.setAdapter(orderAdapter);
    }

    private void addParticipant() {
        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String scoreStr = scoreEditText.getText().toString().trim();

        if (name.isEmpty() || surname.isEmpty() || scoreStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int score = Integer.parseInt(scoreStr);

        Participant participant = new Participant(name, surname, score);
        participantService.addParticipant(participant);
        participantList.add(participant);

        ArrayAdapter<Participant> adapter = (ArrayAdapter<Participant>) participantListView.getAdapter();
        adapter.notifyDataSetChanged();

        clearFields();
        Toast.makeText(MainActivity.this, "Participant added successfully", Toast.LENGTH_SHORT).show();
    }

    private void updateParticipant() {
        if (selectedParticipant == null) {
            Toast.makeText(MainActivity.this, "No participant selected", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String scoreStr = scoreEditText.getText().toString().trim();

        if (name.isEmpty() || surname.isEmpty() || scoreStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int score = Integer.parseInt(scoreStr);

        selectedParticipant.setName(name);
        selectedParticipant.setSurname(surname);
        selectedParticipant.setScore(score);

        ArrayAdapter<Participant> adapter = (ArrayAdapter<Participant>) participantListView.getAdapter();
        adapter.notifyDataSetChanged();

        clearFields();
        Toast.makeText(MainActivity.this, "Participant updated successfully", Toast.LENGTH_SHORT).show();
    }

    private void deleteParticipant() {
        if (selectedParticipant == null) {
            Toast.makeText(MainActivity.this, "No participant selected", Toast.LENGTH_SHORT).show();
            return;
        }

        participantService.deleteParticipant(selectedParticipant);
        participantList.remove(selectedParticipant);

        ArrayAdapter<Participant> adapter = (ArrayAdapter<Participant>) participantListView.getAdapter();
        adapter.notifyDataSetChanged();

        clearFields();
        Toast.makeText(MainActivity.this, "Participant deleted successfully", Toast.LENGTH_SHORT).show();
    }

    private void filterParticipants() {
        filteredList.clear();

        for (Participant participant : participantList) {
            if (participant.getScore() < 5) {
                filteredList.add(participant);
            }
        }

        ArrayAdapter<Participant> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, filteredList);
        participantListView.setAdapter(adapter);

        clearFields();
    }

    private void sortParticipants() {
        String criteria = sortCriteriaSpinner.getSelectedItem().toString();
        String order = sortOrderSpinner.getSelectedItem().toString();

        Comparator<Participant> comparator = null;

        if (criteria.equals(getString(R.string.sort_criteria_name))) {
            comparator = Comparator.comparing(Participant::getName);
        } else if (criteria.equals(getString(R.string.sort_criteria_score))) {
            comparator = Comparator.comparingInt(Participant::getScore);
        }

        if (comparator != null) {
            if (order.equals(getString(R.string.sort_order_descending))) {
                comparator = comparator.reversed();
            }
            Collections.sort(participantList, comparator);

            ArrayAdapter<Participant> adapter = (ArrayAdapter<Participant>) participantListView.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }

    private void setSelectedParticipant(Participant participant) {
        selectedParticipant = participant;
        nameEditText.setText(participant.getName());
        surnameEditText.setText(participant.getSurname());
        scoreEditText.setText(String.valueOf(participant.getScore()));
    }

    private void clearFields() {
        nameEditText.getText().clear();
        surnameEditText.getText().clear();
        scoreEditText.getText().clear();
        selectedParticipant = null;
    }
}
