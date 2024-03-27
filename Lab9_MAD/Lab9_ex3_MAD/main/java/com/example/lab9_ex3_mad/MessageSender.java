package com.example.lab9_ex3_mad;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String, Void, Void> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

// Trimite mesaj in fundal
protected Void doInBackground(String... voids) {

    String message = voids[0];

    try {
        // Creare si config. socket pt. conexiune
        //s = new Socket("172.20.10.8", 8000);
        s = new Socket("172.27.112.1", 8000);
        pw = new PrintWriter(s.getOutputStream());
        // Transmitere mesaj
        pw.write(message);
        pw.flush();
        pw.close();
        s.close();
    } catch(IOException e) {
        e.printStackTrace();
    }

    return null;
}

// Met. apelata dupa ce s-a trimis mesajul
    protected void onPostExecute(Void result) {
        try {
            if (pw != null) {
                pw.close();
            }
            if (s != null) {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
