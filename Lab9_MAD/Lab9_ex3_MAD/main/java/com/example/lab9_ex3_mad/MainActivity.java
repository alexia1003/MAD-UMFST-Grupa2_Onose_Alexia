package com.example.lab9_ex3_mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText messageET;
    TextView receivedTV;
    ReceiverTask receiverTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageET = findViewById(R.id.message);
        receivedTV = findViewById(R.id.received);

        // Creare si executare task pt. receptionare mesaje
        receiverTask = new ReceiverTask(this);
        receiverTask.execute();

        // Btn trimitere mesaje
        Button sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(v);
            }
        });
    }

    // Met. trimitere mesaj
    public void send(View v) {
        // Obt. mesaj text view
        String message = messageET.getText().toString();

        // Creare si executare task pt. a trimite mesaj
        MessageSender messageSender = new MessageSender();
        messageSender.execute(message);

        //messageET.setText("");
        // Toast daca mesajul a fost trimis
        Toast.makeText(this, "Message sent: " + message, Toast.LENGTH_SHORT).show();
    }

    // Actualizare mesaj in text view de primire
    public void updateReceivedMessage(String message) {
        receivedTV.setText(message);
    }
}
