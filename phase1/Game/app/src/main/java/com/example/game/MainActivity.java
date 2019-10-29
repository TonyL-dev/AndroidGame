package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  String username, password, colour, multiplier, numberOfFruits;

  EditText userNameInput;
  EditText passwordInput;
  EditText colourInput;
  EditText scoreMultiplier;
  EditText numFruits;

  Button submitButton;

  Player newPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userNameInput = (EditText) findViewById(R.id.userNameInput);
    passwordInput = (EditText) findViewById(R.id.passwordInput);
    colourInput = (EditText) findViewById(R.id.colourInput);
    scoreMultiplier = (EditText) findViewById(R.id.scoreMultiply);
    numFruits = (EditText) findViewById(R.id.numFruits);

    submitButton = (Button) findViewById(R.id.button);

  }

  public void createPlayer(View view) {
    username = userNameInput.getText().toString();
    password = passwordInput.getText().toString();
    colour = colourInput.getText().toString();
    multiplier = scoreMultiplier.getText().toString();
    numberOfFruits = numFruits.getText().toString();
    newPlayer = new Player(username, password, colour, multiplier, numberOfFruits);
    ((EditText) findViewById(R.id.userNameInput)).setText("");
    ((EditText) findViewById(R.id.passwordInput)).setText("");
    ((EditText) findViewById(R.id.colourInput)).setText("");
    ((EditText) findViewById(R.id.scoreMultiply)).setText("");
    ((EditText) findViewById(R.id.numFruits)).setText("");
  }

  public void playPictureGame(View view){
    if (newPlayer==null)
      newPlayer = new Player();
    Intent intent = new Intent(this, PictureGameActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("player", newPlayer);
    intent.putExtras(bundle);
    startActivity(intent);
  }

  public void playWarGame(View view) {
    Intent intent = new Intent(this, WarGameActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("player", newPlayer);
    intent.putExtras(bundle);
    startActivity(intent);
  }

  public void playSudoku(View view) {
    Intent intent = new Intent(this, SudokuActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("player", newPlayer);
    intent.putExtras(bundle);
    startActivity(intent);
  }

  public void endSudoku(View view){
    // click on the continue button of Sudoku and will go to this interface.
    Intent intent = new Intent(this, SudokuEndScreenActivity.class);
    startActivity(intent);


  }
}
