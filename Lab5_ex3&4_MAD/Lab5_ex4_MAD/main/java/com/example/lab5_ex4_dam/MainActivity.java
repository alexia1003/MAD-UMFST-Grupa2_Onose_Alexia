package com.example.lab5_ex4_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText messageEditText1;
    private EditText messageEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText1 = findViewById(R.id.messageEditText1);
        messageEditText2 = findViewById(R.id.messageEditText2);
    }

    public void sendMessage(View view) {
        String message1 = messageEditText1.getText().toString();
        String message2 = messageEditText2.getText().toString();
        saveMessageToFile("User1: " + message1, "User2: " + message2);
        Intent intent = new Intent(this, ChatActivity.class);
        // Adaugare mesaje la intent
        intent.putExtra("message1", message1);
        intent.putExtra("message2", message2);
        startActivity(intent);
    }

    private void saveMessageToFile(String message1, String message2) {
        File file = new File(getFilesDir(), "chat_history.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(message1).append("\n");
            writer.append(message2).append("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
