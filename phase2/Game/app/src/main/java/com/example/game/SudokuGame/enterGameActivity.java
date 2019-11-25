package com.example.game.SudokuGame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

public class enterGameActivity extends AppCompatActivity {
    Player newPlayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sudoku_choose_game);
      Intent intent = getIntent();
      Bundle bundle = intent.getExtras();
      newPlayer = (Player) bundle.getSerializable("player");
  }

}
