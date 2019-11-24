package com.example.game.WarGame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.ChooseGame;
import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

/**
 * WargameEndScreenActivity where displays endgame result
 */
public class WarGameEndScreenActivity extends AppCompatActivity {

    /**
     * Player object
     */
    Player newPlayer;

    /**
     * PlayerDataBase where the player is stored
     */
    PlayerDataBase playerDataBase;


    int temp;

    /**
     * The time in seconds
     */
    double timeInSeconds;

    /**
     * Sets up the end screen
     * @param savedInstanceState a Bundle object
     */
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

        newPlayer.addTime(timeInSeconds);

        TextView textView = findViewById(R.id.endGameStats);
        textView.setText(stats.concat(newPlayer.toString()));
        if (newPlayer.getColour() != 0)
            textView.setTextColor(newPlayer.getColour());

        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

        //If a Player backs out before continuing to the next game, the data will not be saved
        //newPlayer.subtractPoints(temp);
        newPlayer.subtractTime();
        playerDataBase.storePlayerData(newPlayer);
    }

    /**
     * starts the next level of war game - 3 players
     * @param view a View object
     */
    public void startNewWarGame(View view){
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("numPlayers", 3);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Goes to the Choose Game menu
     * @param view a View object
     */
    public void goToMainMenu(View view){
        newPlayer.reset(); // resets Player statistics
        playerDataBase.storePlayerData(newPlayer);
        Intent intent = new Intent(this, ChooseGame.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
