package com.example.game;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.game.PictureGame.PictureGameActivity;
import com.example.game.SudokuGame.SudokuActivity;
import com.example.game.WarGame.WarGameActivity;

public class ChooseGame extends AppCompatActivity {

    //player
    private Player newPlayer;

    private PlayerDataBase playerDataBase;

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
        playerDataBase = new PlayerDataBase(this);

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
     * If a Player's game number is 1, then the player will start at the PictureActivity.
     */
    public void startPictureGame(View view){
        Intent intent = new Intent(this, PictureGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a Player's game number is 2, then the player will start at the WarGameActivity.
     */
    public void startWarGame(View view){
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If a Player's game number is 1, then the player will start at the SudokuActivity.
     */
    public void startSudokuGame(View view){
        Intent intent = new Intent(this, SudokuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
