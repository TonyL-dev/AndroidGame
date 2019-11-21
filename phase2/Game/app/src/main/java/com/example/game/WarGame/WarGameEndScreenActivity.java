package com.example.game.WarGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;
import com.example.game.SudokuGame.SudokuActivity;

/**
 * WargameEndScreenActivity where displays endgame result
 */
public class WarGameEndScreenActivity extends AppCompatActivity {

    Player newPlayer;

    PlayerDataBase playerDataBase;

    int temp;

    double timeInSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_game_end_screen);

        Bundle bundle = getIntent().getExtras();
        String stats = bundle.getString("points");
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);
        temp = (int) bundle.getSerializable("temp");
        timeInSeconds = (double) bundle.getSerializable("time");

        newPlayer.addTime(timeInSeconds - 3);

        TextView textView = findViewById(R.id.endGameStats);
        textView.setText(stats.concat(newPlayer.toString()));
        if (newPlayer.getColour() != 0)
            textView.setTextColor(newPlayer.getColour());

        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

        //If a Player backs out before continuing to the next game, the data will not be saved
        newPlayer.subtractPoints(temp);
        newPlayer.subtractTime();
        playerDataBase.storePlayerData(newPlayer);

        Button nextGame = findViewById(R.id.nextGame);
        nextGame.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if a Player continues to the next game, the data will be saved
                        newPlayer.addTime(timeInSeconds - 3);
                        newPlayer.addPoints(temp);
                        playerDataBase.storePlayerData(newPlayer);
                        //starts sudoku game
                        Intent intent = new Intent(v.getContext(), SudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("player", newPlayer);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
    }

}
