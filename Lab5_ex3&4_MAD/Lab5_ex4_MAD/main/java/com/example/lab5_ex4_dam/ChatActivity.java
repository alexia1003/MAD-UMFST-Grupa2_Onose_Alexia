package com.example.lab5_ex4_dam;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChatActivity extends AppCompatActivity {
    private TextView chatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        chatTextView = findViewById(R.id.chatTextView);
        displayChatHistory();
    }

    private void displayChatHistory() {
        File file = new File(getFilesDir(), "chat_history.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder chatHistory = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.append(line).append("\n");
            }
            reader.close();
            chatTextView.setText(chatHistory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
