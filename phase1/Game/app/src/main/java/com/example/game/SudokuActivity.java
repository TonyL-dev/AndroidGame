package com.example.game;

import android.content.Intent;
import android.media.AudioTrack;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

//WarGame那里还要link到这个界面 （在WarGameEndScreen class里）（好像可以直接在xml里搞）
//虽然写上了但我感觉不需要newPlayer这个variable

public class SudokuActivity extends AppCompatActivity {

    Player newPlayer;
    private SudokuGame sudokuGame;


    public SudokuActivity() {
        SudokuGame sudokuGame = new SudokuGame();
        long start = System.nanoTime(); //pictureGame把这行写在constructor外面了但我觉得在里面
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        //上面两行是主页面
        //好像下面这三行的意思是有这个才能得到从wargame得到的信号
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        sudokuGame = new SudokuGame();
        //？上面这行在constructor里写还是在这里写 还是都要写这俩是不一样的
    }

    private void buttonClicked(View view){
        //runs when the "continue" button on the top right of game board is clicked.



    }
}

