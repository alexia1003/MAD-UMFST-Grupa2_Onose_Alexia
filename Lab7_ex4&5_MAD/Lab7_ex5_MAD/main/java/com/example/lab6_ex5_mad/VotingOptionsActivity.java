package com.example.lab6_ex5_mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VotingOptionsActivity extends AppCompatActivity {

    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting_options_activity);

        option1RadioButton = findViewById(R.id.radio_option1);
        option2RadioButton = findViewById(R.id.radio_option2);
        option3RadioButton = findViewById(R.id.radio_option3);

        Button castVoteButton = findViewById(R.id.btn_send_vote);
        castVoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVote();
            }
        });
    }

    private void castVote() {
        if (option1RadioButton.isChecked()) {
            Toast.makeText(this, "You voted for Option 1", Toast.LENGTH_SHORT).show();
        } else if (option2RadioButton.isChecked()) {
            Toast.makeText(this, "You voted for Option 2", Toast.LENGTH_SHORT).show();
        } else if (option3RadioButton.isChecked()) {
            Toast.makeText(this, "You voted for Option 3", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Please select an option to vote.", Toast.LENGTH_SHORT).show();
        }
    }
}
