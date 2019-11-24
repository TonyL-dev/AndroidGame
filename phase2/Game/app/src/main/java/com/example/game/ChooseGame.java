package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.PictureGame.PictureGameActivity;
import com.example.game.SudokuGame.SudokuActivity;
import com.example.game.WarGame.WarGameActivity;

public class ChooseGame extends AppCompatActivity {

    /** Player object*/
    private Player newPlayer;

    /** TextView to display which games are available to play*/
    private TextView newTextView, newTextView2, newTextView3, newTextView4;

    /**
     *Created on run. Looks for input to create player.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        newTextView = findViewById(R.id.textView5);
        newTextView2 = findViewById(R.id.textView6);
        newTextView3 = findViewById(R.id.textView7);
        newTextView4 = findViewById(R.id.textView8);

        //sets text colour
        if (newPlayer.getColour() != 0) {
            newTextView.setTextColor(newPlayer.getColour());
            newTextView2.setTextColor(newPlayer.getColour());
            newTextView3.setTextColor(newPlayer.getColour());
            newTextView4.setTextColor(newPlayer.getColour());
        }

        //set background colour
        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }
    }

    /**
     * If a user chooses to play PictureGame, then the player will start at the PictureGameActivity.
     */
    public void startPictureGame(View view){
        Intent intent = new Intent(this, PictureGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a user chooses to play WarGame, then the player will start at the WarGameActivity.
     */
    public void startWarGame(View view){
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("numPlayers", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a user chooses to play SudukoGame, then the player will start at the Choose_Sudoku_Game.
     */
    public void startSudokuGame(View view){
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
