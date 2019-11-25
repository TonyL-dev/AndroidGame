package com.example.game.WarGame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.ChooseGame;
import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * The time in seconds
     */
    double timeInSeconds;

    private int indexForNumOfCards;
    private int indexForLastCardPlayed;

    private List<Integer> replayCardsRemaining;
    private List<String> replaysCardPlayed;
    private int numPlayers;

    private String textOutput;
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
        timeInSeconds = (double) bundle.getSerializable("time");
        numPlayers = (int) bundle.getSerializable("numPlayers");

        if (numPlayers == 3)
            findViewById(R.id.playNextLevel).setVisibility(View.GONE);

        replayCardsRemaining = (ArrayList) bundle.getSerializable("replayCardsRemaining");
        replaysCardPlayed = (ArrayList) bundle.getSerializable("replayCardsPlayed");

        newPlayer.addTime(timeInSeconds);

        TextView textView = findViewById(R.id.endGameStats);
        textView.setText(stats.concat(newPlayer.toString()));

        textOutput = stats.concat(newPlayer.toString());
        if (newPlayer.getColour() != 0)
            textView.setTextColor(newPlayer.getColour());

        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

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

    private int getNextNumCardsRemaining(){
        indexForNumOfCards++;
        return replayCardsRemaining.get(indexForNumOfCards - 1);
    }

    private String getNextCardPlayed(){
        indexForLastCardPlayed++;
        return replaysCardPlayed.get(indexForLastCardPlayed - 1);
    }

    public void replayGame(View view) {
        indexForLastCardPlayed = 0;
        indexForNumOfCards = 0;
        int time = replayCardsRemaining.size()/numPlayers*3000;
        if (numPlayers == 2)
            setContentView(R.layout.activity_war_game);
        else
            setContentView(R.layout.activity_war_game_two);
        findViewById(R.id.playButton).setEnabled(false);
        findViewById(R.id.skipButton).setEnabled(false);

        new CountDownTimer(time, 3000) {
            TextView cardPlayedA = findViewById(R.id.currentCardA);
            TextView cardPlayedB = findViewById(R.id.currentCardB);
            TextView cardPlayedC = findViewById(R.id.currentCardC);
            TextView cardsA = findViewById(R.id.cardRemainingA);
            TextView cardsB = findViewById(R.id.cardRemainingB);
            TextView cardC = findViewById(R.id.cardRemainingC);
            @Override
            public void onTick(long millisUntilFinished) {
                cardPlayedA.setText(getNextCardPlayed());
                cardPlayedB.setText(getNextCardPlayed());
                cardsA.setText("Cards remaining:" + getNextNumCardsRemaining());
                cardsB.setText("Cards remaining:" + getNextNumCardsRemaining());
                if (numPlayers == 3){
                    cardPlayedC.setText(getNextCardPlayed());
                    cardC.setText("Cards remaining:" + getNextNumCardsRemaining());
                }
            }

            @Override
            public void onFinish() {
                setContentView(R.layout.activity_war_game_end_screen);
                ((TextView) findViewById(R.id.endGameStats)).setText(textOutput);
                if (numPlayers == 3)
                    findViewById(R.id.playNextLevel).setVisibility(View.GONE);
            }
        }.start();
   }
}
