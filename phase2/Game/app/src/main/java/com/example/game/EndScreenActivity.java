package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.WarGame.WarGameActivity;

public class EndScreenActivity extends AppCompatActivity {
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
     * sets up the screen that displays the end of game stats
     * @param savedInstanceState a Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        String stats = bundle.getString("points"); //result of the previous game played including points

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
        newPlayer.subtractPoints(temp);
        newPlayer.subtractTime();
        playerDataBase.storePlayerData(newPlayer);
    }

    /**
     * Sets up the view to go to the Choose Game menu
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
