package com.example.treasuregame;

import Models.Game;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainActivity extends AppCompatActivity {
    private Button enterButton;
    private TextView textViewResult;

    private EditText gameCodeField;
    private RequestQueue requestQueue;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.EnterCodeLabel);
        enterButton = findViewById(R.id.EnterButton);
        gameCodeField = findViewById(R.id.GameCodeField);

    }


    public void StartGame(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        this.code = gameCodeField.getText().toString();
        String url = "http://10.0.2.2:8080/api/v1/gamepusers/code/" + code;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            Game game = objectMapper.readValue(response, Game.class);
//                            textViewResult.setText(game.toString());
                            startActivity(new Intent(getApplicationContext(), GameActivity.class).putExtra("Game", game));
                        } catch (JsonProcessingException e) {
                            textViewResult.setText("Not Found");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewResult.setText(error.toString());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}