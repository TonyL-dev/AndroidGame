package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SudokuEndScreenActivity extends AppCompatActivity {
    SudokuGame sudokuGame;
    long endSudoku = System.nanoTime();
    TextView textView;
    public Player newPlayer;
    long time;


    public long get_time_used(SudokuGame sudokuGame){

        time = this.endSudoku - sudokuGame.startSudoku;
        return time;
    }

    public void totol_time(){
        newPlayer.addTime((double)time);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_end_screen);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        textView = findViewById(R.id.endState);
        get_time_used(sudokuGame);

    }

}

