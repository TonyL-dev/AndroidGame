package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SudokuEndScreenActivity extends AppCompatActivity {

  public Player newPlayer;
  TextView textView;
  PlayerDataBase playerDataBase;

  int temp;

  double timeInSeconds;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sudoku_end_screen);
    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    newPlayer = (Player) bundle.getSerializable("player");
    String sudokupoint = bundle.getString("points");
    temp = (int) bundle.getSerializable("temp");
    timeInSeconds = (double) bundle.getSerializable("time");
    playerDataBase = new PlayerDataBase(this);

    newPlayer.addTime(timeInSeconds);

    textView = findViewById(R.id.endState);
    textView.setTextSize(23);

    //show the points and time used by user in Sudoku and that in the 3 games in total.
    textView.setText(sudokupoint + newPlayer.toString());

    //get the color user want for numbers they write on the board and change it accordingly.
    if (newPlayer.getColour() != 0) textView.setTextColor(newPlayer.getColour());
    if (newPlayer.getbackColour() != 0) {
      getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
    }

    newPlayer.subtractPoints(temp);
    newPlayer.subtractTime();
    playerDataBase.clearUserData();
    playerDataBase.storePlayerData(newPlayer);

    Button nextGame = findViewById(R.id.button3);
    nextGame.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            newPlayer.reset();
            playerDataBase.clearUserData();
            playerDataBase.storePlayerData(newPlayer);
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivity(intent);
          }
        });
  }
}
