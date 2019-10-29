package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  String username, password;

  EditText userNameInput;
  EditText passwordInput;

  Button submitButton;

  Player newPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userNameInput = (EditText) findViewById(R.id.userNameInput);
    passwordInput = (EditText) findViewById(R.id.passwordInput);

    submitButton = (Button) findViewById(R.id.button);
  }

  public void createPlayer(View view) {
    username = userNameInput.getText().toString();
    password = passwordInput.getText().toString();
    newPlayer = new Player(username, password);
    ((EditText) findViewById(R.id.userNameInput)).setText("");
    ((EditText) findViewById(R.id.passwordInput)).setText("");
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
}
