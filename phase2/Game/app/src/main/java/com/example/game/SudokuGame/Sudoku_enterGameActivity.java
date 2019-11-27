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

import java.io.Serializable;

public class Sudoku_enterGameActivity extends AppCompatActivity {
    Player newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sudoku_choose_game);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }
    }


    public void chooselv1(View view) {
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("lv", 1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void chooselv2(View view) {
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("lv", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void chooselv3(View view) {
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("lv", 3);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void chooselv4(View view) {
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("lv", 4);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
