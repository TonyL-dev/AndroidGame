package com.example.game.WarGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.EndScreenActivity;
import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

/**
 * The WarGameActivity class where player plays WarGame
 */
public class WarGameActivity extends AppCompatActivity {

    /**
     * Player object
     */
    private Player newPlayer;

    /**
     * Wargame object
     */
    private WarGame game;

    /**
     * Textview for the different cards and the counts of remaining cards
     */
    private TextView cardsA, cardsB, cardsC, cardPlayedA, cardPlayedB, cardPlayedC;

    /**
     * PlayerDataBase where the player is stored
     */
    PlayerDataBase playerDataBase;

    /**
     * Current number of players playing
     */
    private int numOfPlayers;

    /**
     * How the game's time for each level is determined. The timer starts at initialization.
     */
    private long start = System.nanoTime();

    /**
     * Created on run. Sets up the game to have the appropriate cards displayed
     *
     * @param savedInstanceState a Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_game);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);
        numOfPlayers = (int) bundle.getSerializable("numPlayers");

        //increments number of games
        newPlayer.addLevel(2);

        playerDataBase.storePlayerData(newPlayer);

        game = new WarGame(newPlayer, numOfPlayers);

        cardsA = findViewById(R.id.cardRemainingA);
        cardsA.setText("Cards remaining:" + game.getCardsRemaining(0));

        cardsB = findViewById(R.id.cardRemainingB);
        cardsB.setText("Cards remaining:" + game.getCardsRemaining(1));

        cardPlayedA = findViewById(R.id.currentCardA);
        cardPlayedB = findViewById(R.id.currentCardB);

        //set text colour
        if (newPlayer.getColour() != 0) {
            cardsA.setTextColor(newPlayer.getColour());
            cardsB.setTextColor(newPlayer.getColour());
            cardPlayedA.setTextColor(newPlayer.getColour());
            cardPlayedB.setTextColor(newPlayer.getColour());
        }

        //set background colour
        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }
    }

    /**
     * Go to score screen
     *
     * @param view whichever buttons triggers endgame
     */
    public void openScoreScreen(View view) {
        long end = System.nanoTime();
        long time = end - start;
        double timeInSeconds = (double) time / 1_000_000_000;
        Intent intent;
        Bundle bundle = new Bundle();
        //Choosing whether the game needs to go to the next level screen or end game screen
        if (numOfPlayers == 2)
            intent = new Intent(this, WarGameEndScreenActivity.class);
        else {
            intent = new Intent(this, EndScreenActivity.class);
        }
        bundle.putSerializable("points", game.toString());
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("time", timeInSeconds);
        bundle.putSerializable("numPlayers", game.getNumOfPlayers());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * play a round of the game
     *
     * @param view the play button
     */
    public void playRound(View view) {
        if (!game.checkEndGame()) game.play();
        else {
            openScoreScreen(view);
        }
        cardsA.setText("Cards remaining:" + String.valueOf(game.getCardsRemaining(0)));
        cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemaining(1)));
        cardPlayedA.setText(game.getLastCardsPlayed()[0].toString());
        cardPlayedB.setText(game.getLastCardsPlayed()[1].toString());
    }
}
