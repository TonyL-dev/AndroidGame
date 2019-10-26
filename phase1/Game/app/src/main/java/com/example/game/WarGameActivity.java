package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WarGameActivity extends AppCompatActivity {

  //player
  Player newPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_war_game);

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    newPlayer = (Player) bundle.getSerializable("player");

    try {
      Thread.sleep(3000);
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }

    System.out.println(newPlayer.getPoints());
    WarGame x = new WarGame();
    x.play();

    TextView textView = findViewById(R.id.textView3);
    textView.setText(x.toString());

  }
}
