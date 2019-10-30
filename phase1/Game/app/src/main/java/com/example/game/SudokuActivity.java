package com.example.game;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class SudokuActivity extends AppCompatActivity {

    Player newPlayer;
    public SudokuGame sudokuGame;

    public SudokuActivity() {
        //SudokuGame sudokuGame = new SudokuGame();
        //这个constructor等看看SudokuGame的constructor是啥再说。
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
    }
    public void toEndScreen(View view) {
        Intent intent = new Intent(this, SudokuEndScreenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}


