package com.example.lab9_ex2_mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        // Init. coada cereri pt. Volley
        mQueue = Volley.newRequestQueue(this);

        // Apelare "parse"
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        // Url-ul de la care se face cererea
        String url = "https://gist.github.com/alexia1003/c3e42d3bf52116e9b079780e8ca4f8c3/raw/data.json";

        // Cererea json
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Obt. array "employees" din json
                            JSONArray employeesArray = response.getJSONArray("employees");
                            // Parcurgere fiecare elem. array
                            for (int i = 0; i < employeesArray.length(); i++) {
                                JSONObject employee = employeesArray.getJSONObject(i);

                                // Extragere info. angajat
                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String email = employee.getString("mail");

                                // Afis. info. in text view
                                mTextViewResult.append("First Name: " + firstName + "\n" +
                                        "Age: " + age + "\n" +
                                        "Email: " + email + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        // Add. cerere in coada
        mQueue.add(request);
    }
}