package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SudokuEndScreenActivity extends AppCompatActivity {

  TextView textView;
  public Player newPlayer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sudoku_end_screen);
    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    newPlayer = (Player) bundle.getSerializable("player");
    String sudokupoint = bundle.getString("points");
    textView = findViewById(R.id.endState);

    textView.setTextSize(23);
    textView.setText(sudokupoint + newPlayer.toString());

    if (newPlayer.getColour() != 0) textView.setTextColor(newPlayer.getColour());

    if (newPlayer.getbackColour() != 0) {
      getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
    }

    Button nextGame = findViewById(R.id.button3);
    nextGame.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivity(intent);
          }
        });
  }
    }


