package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void playWarGame(View view) {
    Intent intent = new Intent(this, WarGameActivity.class);
    startActivity(intent);
  }

  public void playPictureGame(View view){
    Intent intent = new Intent(this, PictureGameActivity.class);
    startActivity(intent);
  }
}
