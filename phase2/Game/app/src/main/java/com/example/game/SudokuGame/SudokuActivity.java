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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

public class SudokuActivity extends AppCompatActivity {

  public SudokuGame sudokuGame;
  Player newPlayer;
  PlayerDataBase playerDataBase;

  EditText t1,
      t2,
      t3,
      t4,
      t5,
      t6,
      t7,
      t8,
      t9,
      t10,
      t11,
      t12,
      t13,
      t14,
      t15,
      t16,
      t17,
      t18,
      t19,
      t20,
      t21,
      t22,
      t23,
      t24,
      t25,
      t26,
      t27,
      t28,
      t29,
      t30,
      t31,
      t32,
      t33,
      t34,
      t35,
      t36,
      t37,
      t38,
      t39,
      t40,
      t41,
      t42,
      t43,
      t44,
      t45,
      t46,
      t47,
      t48,
      t49,
      t50,
      t51,
      t52,
      t53;
  Button b1;

  long startSudoku = System.nanoTime();

  public static void hideKeyboard(View view) {
    if (view != null) {
      InputMethodManager inputManager =
          (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      if (inputManager != null) {
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
      }
    }
  }

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sudoku);

    Intent intent = getIntent();
    Bundle bundle = intent.getExtras();
    newPlayer = (Player) bundle.getSerializable("player");
    // increments game number
    newPlayer.addLevel();

    playerDataBase = new PlayerDataBase(this);

    playerDataBase.storePlayerData(newPlayer);

    // set background colour
    if (newPlayer.getbackColour() != 0) {
      getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
    }

    sudokuGame = new SudokuGame(newPlayer, SudokuGameBoard.toHM(SudokuGameBoard.sudo));

    b1 = findViewById(R.id.button);

    t1 = findViewById(R.id.editText1);
    t2 = findViewById(R.id.editText2);
    t3 = findViewById(R.id.editText3);
    t4 = findViewById(R.id.editText4);
    t5 = findViewById(R.id.editText5);
    t6 = findViewById(R.id.editText6);
    t7 = findViewById(R.id.editText7);
    t8 = findViewById(R.id.editText8);
    t9 = findViewById(R.id.editText9);
    t10 = findViewById(R.id.editText10);
    t11 = findViewById(R.id.editText11);
    t12 = findViewById(R.id.editText12);
    t13 = findViewById(R.id.editText13);
    t14 = findViewById(R.id.editText14);
    t15 = findViewById(R.id.editText15);
    t16 = findViewById(R.id.editText16);
    t17 = findViewById(R.id.editText17);
    t18 = findViewById(R.id.editText18);
    t19 = findViewById(R.id.editText19);
    t20 = findViewById(R.id.editText20);
    t21 = findViewById(R.id.editText21);
    t22 = findViewById(R.id.editText22);
    t23 = findViewById(R.id.editText23);
    t24 = findViewById(R.id.editText24);
    t25 = findViewById(R.id.editText25);
    t26 = findViewById(R.id.editText26);
    t27 = findViewById(R.id.editText27);
    t28 = findViewById(R.id.editText28);
    t29 = findViewById(R.id.editText29);
    t30 = findViewById(R.id.editText30);
    t31 = findViewById(R.id.editText31);
    t32 = findViewById(R.id.editText32);
    t33 = findViewById(R.id.editText33);
    t34 = findViewById(R.id.editText34);
    t35 = findViewById(R.id.editText35);
    t36 = findViewById(R.id.editText36);
    t37 = findViewById(R.id.editText37);
    t38 = findViewById(R.id.editText38);
    t39 = findViewById(R.id.editText39);
    t40 = findViewById(R.id.editText40);
    t41 = findViewById(R.id.editText41);
    t42 = findViewById(R.id.editText42);
    t43 = findViewById(R.id.editText43);
    t44 = findViewById(R.id.editText44);
    t45 = findViewById(R.id.editText45);
    t46 = findViewById(R.id.editText46);
    t47 = findViewById(R.id.editText47);
    t48 = findViewById(R.id.editText48);
    t49 = findViewById(R.id.editText49);
    t50 = findViewById(R.id.editText50);
    t51 = findViewById(R.id.editText51);
    t52 = findViewById(R.id.editText52);
    t53 = findViewById(R.id.editText53);

    EditText[] inputs = {
      t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20,
      t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39,
      t40, t41, t42, t43, t44, t45, t46, t47, t48, t49, t50, t51, t52, t53
    };

    // set text colour
    for (EditText input : inputs) {
      if (newPlayer.getColour() != 0) {
        input.setTextColor(newPlayer.getColour());
      }
    }

    for (final EditText input : inputs) {
      input.addTextChangedListener(
          new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
              hideKeyboard(input);
              int x = (int) (((String) input.getTag()).charAt(0)) - 48;
              int y = (int) (((String) input.getTag()).charAt(1)) - 48;
              if (!input.getText().toString().equals("")
                  && !sudokuGame.insert(
                      Integer.valueOf(input.getText().toString()), x, y, sudokuGame.sudoku)) {
                DialogInterface.OnClickListener r =
                    new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                        input.getText().clear();
                      }
                    };
                AlertDialog.Builder builder = new AlertDialog.Builder(SudokuActivity.this);
                builder.setMessage("Invalid Number").setPositiveButton("ok", r);
                AlertDialog alert = builder.create();
                alert.show();
              }
            }
          });
    }
  }

  /** method called when click the continue button. */
  public void endSudoku(View view) {
    long endSudoku = System.nanoTime();
    long time = endSudoku - startSudoku;
    double timeInSeconds = (double) time / 1_000_000_000;
    int temp = getScore();
    Intent intent = new Intent(this, SudokuEndScreenActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("points", toString());
    bundle.putSerializable("player", newPlayer);
    bundle.putSerializable("temp", temp);
    bundle.putSerializable("time", timeInSeconds);
    intent.putExtras(bundle);
    startActivity(intent);
    System.out.println(SudokuGameBoard.toHM(SudokuGameBoard.sudo));
  }

  /**
   * return the score user gained in sudoku game.
   *
   * @return score
   */
  public int getScore() {
    int pt = 0;
    for (Integer value : sudokuGame.sudoku.values()) {
      if (value <= 9 && value > 0) {
        pt += 1;
      }
    }

    return pt - 29;
  }

  @Override
  public String toString() {
    newPlayer.addPoints(getScore()); // add points to the total points of player
    String showPoints =
        "You have got " + getScore() * newPlayer.getMultiplier() + " points " + "in Sudoku game.";
    return showPoints;
  }
}
