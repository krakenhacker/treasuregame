package com.example.treasuregame;

import Models.Game;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.*;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GameActivity extends AppCompatActivity implements LocationListener {

    private TextView textViewGame;

    ObjectMapper objectMapper = new ObjectMapper();

    LocationManager locationManager;
    public int count=0;
    public int gameid=0;
    public Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = (Game) getIntent().getSerializableExtra("Game");
        textViewGame = findViewById(R.id.textViewGame);
        textViewGame.setText(game.toString());
        gameid = Math.toIntExact(game.getId());
        getLocation();
//        try {
//            game = objectMapper.readValue(gamestring, Game.class);
//            textView.findViewById(R.id.textView);
//            textView.setText(game.toString());
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        if (ContextCompat.checkSelfPermission(GameActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(GameActivity.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }



    }




    public void TerminateGame(View view) {
        count=0;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, GameActivity.this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        double puzzlelong = 2615509.495452444;
        double puzzlelat = 5027049.732337592;
        if ((Math.abs((puzzlelat - (Math.log(Math.tan(((90 + location.getLatitude()) * Math.PI) / 360)) / (Math.PI / 180)) * 20037508.34 / 180)) < 100) && Math.abs(puzzlelong - location.getLongitude() * 20037508.34 / 180) < 100) {
            Toast.makeText(this, "" + (Math.log(Math.tan(((90 + location.getLatitude()) * Math.PI) / 360)) / (Math.PI / 180)) * 20037508.34 / 180 + "," + location.getLongitude() * 20037508.34 / 180, Toast.LENGTH_SHORT).show();


            RequestQueue queue = Volley.newRequestQueue(this);

            String url = "http://10.0.2.2:8080/api/v1/gamepuzzles/bygameid/" + game.getId();

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            ObjectMapper objectMapper = new ObjectMapper();
//                            textViewResult.setText(game.toString());
                                textViewGame.setText(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textViewGame.setText(error.toString());
                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);

        }
    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}