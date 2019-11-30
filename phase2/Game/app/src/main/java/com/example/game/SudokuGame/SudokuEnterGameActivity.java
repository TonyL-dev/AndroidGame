package com.example.game.SudokuGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.PlayerPackage.Player;
import com.example.game.R;

/**
 * This class is called when the user choose Sudoku game in the main menu.
 */

public class SudokuEnterGameActivity extends AppCompatActivity {
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

    /*
    when user choose level 1 on the sudoku menu.
     */
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
