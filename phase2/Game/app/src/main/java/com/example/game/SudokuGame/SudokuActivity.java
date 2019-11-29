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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

import java.util.Objects;

public class SudokuActivity extends AppCompatActivity {

    public SudokuGame sudokuGame;
    Player newPlayer;
    PlayerDataBase playerDataBase;

    TableLayout sud;

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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int lv = (int) (bundle.getSerializable("lv"));

        if (lv == 4) {
            setContentView(R.layout.activity_sudoku_4);
        } else if (lv == 3) {
            setContentView(R.layout.activity_sudoku_3);
        } else if (lv == 2) {
            setContentView(R.layout.activity_sudoku_2);
        } else {
            setContentView(R.layout.activity_sudoku_1);
        }


        playerDataBase = new PlayerDataBase(this);


        newPlayer = (Player) bundle.getSerializable("player");

        // increments game number
        newPlayer.addLevel(3);


        playerDataBase.storePlayerData(newPlayer);

        // set background colour
        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

        sudokuGame = new SudokuGame(newPlayer, new SudokuGameLibrary(lv).gameplaying);

        sud = findViewById(R.id.sudokugame);

        b1 = findViewById(R.id.button);

        for (int a = 0, b = sud.getChildCount(); a < b; a++) {
            final TableRow row = (TableRow) sud.getChildAt(a);
            for (int i = 0, j = row.getChildCount(); i < j; i++) {
                final View input = row.getChildAt(i);
                if (input instanceof TextView) {
                    if (newPlayer.getColour() != 0) {
                        setTextcolor(((TextView) input));
//            ((TextView) input).setTextColor(newPlayer.getColour());
                    }
                }
                if (input instanceof EditText) {
                    if (newPlayer.getColour() != 0) {
                        setTextcolor(((EditText) input));
//            ((EditText)input).setTextColor(newPlayer.getColour());
                    }
                    ((EditText) input).addTextChangedListener(
                            new TextWatcher() {
                                @Override
                                public void beforeTextChanged(
                                        CharSequence charSequence, int i, int i1, int i2) {
                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                }

                                @Override
                                public void afterTextChanged(Editable editable) {
                                    hideKeyboard(input);
                                    int x = (int) (((String) input.getTag()).charAt(0)) - 48;
                                    int y = (int) (((String) input.getTag()).charAt(1)) - 48;
                                    if (!((EditText) input).getText().toString().equals("")
                                            && !sudokuGame.insert(Integer.valueOf(((EditText) input).getText().toString()), x, y,
                                            sudokuGame.sudoku)) {
                                        DialogInterface.OnClickListener r =
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        ((EditText) input).getText().clear();
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

        }


    }

    /**
     * method called when click the continue button.
     */
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

    public void setTextcolor(TextView tv) {
        tv.setTextColor(newPlayer.getColour());
    }

    @Override
    public String toString() {
        newPlayer.addPoints(getScore()); // add points to the total points of player
        String showPoints =
                "You have got " + getScore() * newPlayer.getMultiplier() + " points " + "in Sudoku game.";
        return showPoints;
    }
}
