package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WarGameEndScreen extends AppCompatActivity {

    Player newPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_game);

        Bundle bundle = getIntent().getExtras();
        String stats = bundle.getString("points");
        newPlayer = (Player) bundle.getSerializable("player");

        TextView textView = findViewById(R.id.endGameStats);
        textView.setText(stats + newPlayer.toString());
        System.out.println(stats);
        System.out.println(newPlayer.getTime(2));
        System.out.println(newPlayer.getPoints());

        Button nextGame = findViewById(R.id.nextGame);
        nextGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this, WarGameEndScreen.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("points", game.toString());
                //bundle.putSerializable("player", newPlayer);
                //intent.putExtras(bundle);
                //startActivity(intent);
            }
        });
    }
}
