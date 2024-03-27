package com.example.lab9_ex3_mad;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverTask extends AsyncTask<Void, String, Void> {

    MainActivity activity;

    // Constructor care primeste activitatea principala ca param.
    public ReceiverTask(MainActivity activity) {
        this.activity = activity;
    }

    // Met. receptionare mesaje in fundal
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //Creare server socket pt. asteptarea conexiunilor
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                // Asteptare conexiune
                Socket socket = serverSocket.accept();
                // Creare reader citire mesaj primit
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Citire mesajului
                String receivedMessage = bufferedReader.readLine();
                // Publicare mesaj pt. ais. in UI
                publishProgress(receivedMessage);
                // Inchide socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Met. apelata pe thread Ui pt. actualizare mesaj afisat
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        activity.updateReceivedMessage(values[0]);
    }
}
