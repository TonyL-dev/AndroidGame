package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WarGameActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_war_game);

    WarGame x = new WarGame();
    x.play();

    Intent intent = getIntent();

    TextView textView = findViewById(R.id.textView3);
    textView.setText(x.toString());

  }
}
