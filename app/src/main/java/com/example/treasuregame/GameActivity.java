package com.example.treasuregame;

import Models.Game;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameActivity extends AppCompatActivity {
    private TextView textViewGame;

    ObjectMapper objectMapper = new ObjectMapper();
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Game game = (Game) getIntent().getSerializableExtra("Game");
        textViewGame = findViewById(R.id.textViewGame);
        textViewGame.setText(game.toString());
//        try {
//            game = objectMapper.readValue(gamestring, Game.class);
//            textView.findViewById(R.id.textView);
//            textView.setText(game.toString());
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void TerminateGame(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}