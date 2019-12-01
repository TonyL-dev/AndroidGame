package com.example.game.WarGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.PlayerPackage.Player;
import com.example.game.PlayerPackage.PlayerDataBase;
import com.example.game.R;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
     * The entire list of all last cards played for the whole game
     */
    private List<String> replayCardsPlayed;

    /**
     * The entire list of how many cards players had remaining after every round for the whole game
     */
    private List<Integer> replayCardsRemaining;

    /**
     * Created on run. Sets up the game to have the appropriate cards displayed
     *
     * @param savedInstanceState a Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);
        numOfPlayers = (int) bundle.getSerializable("numPlayers");

        setUpWarGameScreen();
    }

    /**
     * Sets up the war screen by choosing the right activity, setting up all the TextViews to be used,
     * and updating the background if necessary
     */
    private void setUpWarGameScreen() {
        //choosing which layout to display
        if (numOfPlayers == 2)
            setContentView(R.layout.activity_war_game);
        else
            setContentView(R.layout.activity_war_game_two);

        replayCardsPlayed = new LinkedList<>();
        replayCardsRemaining = new LinkedList<>();


        //increments number of games
        newPlayer.addLevel(2);

        playerDataBase.storePlayerData(newPlayer);

        game = new WarGame(newPlayer, numOfPlayers);

        //set up the user's hand
        cardsA = findViewById(R.id.cardRemainingA);
        cardsA.setText("Cards remaining:" + game.getCardsRemaining(0));
        cardPlayedA = findViewById(R.id.currentCardA);
        replayCardsRemaining.add(game.getCardsRemaining(0));
        replayCardsPlayed.add("No card");


        //setup for the second player's hand
        cardsB = findViewById(R.id.cardRemainingB);
        cardsB.setText("Cards remaining:" + game.getCardsRemaining(1));
        cardPlayedB = findViewById(R.id.currentCardB);
        replayCardsRemaining.add(game.getCardsRemaining(1));
        replayCardsPlayed.add("No card");

        //setup for the third player's hand
        if (numOfPlayers == 3) {
            cardsC = findViewById(R.id.cardRemainingC);
            cardsC.setText("Cards remaining:" + game.getCardsRemaining(2));

            replayCardsRemaining.add(game.getCardsRemaining(2));
            replayCardsPlayed.add("No card");
            cardPlayedC = findViewById(R.id.currentCardC);
        }

        //set text colour
        if (newPlayer.getColour() != 0) {
            cardsA.setTextColor(newPlayer.getColour());
            cardsB.setTextColor(newPlayer.getColour());
            cardPlayedA.setTextColor(newPlayer.getColour());
            cardPlayedB.setTextColor(newPlayer.getColour());

            if (numOfPlayers == 3) {
                cardsC.setTextColor(newPlayer.getColour());
                cardPlayedC.setTextColor(newPlayer.getColour());
            }
        }

        //set background colour
        if (newPlayer.getBackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getBackColour());
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

        System.out.println(timeInSeconds);
        Intent intent;
        Bundle bundle = new Bundle();

        intent = new Intent(this, WarGameEndScreenActivity.class);
        bundle.putSerializable("points", game.toString());
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("time", timeInSeconds);
        bundle.putSerializable("numPlayers", game.getNumOfPlayers());
        bundle.putSerializable("replayCardsPlayed", (Serializable) replayCardsPlayed);
        bundle.putSerializable("replayCardsRemaining", (Serializable) replayCardsRemaining);
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
        updateText();

    }

    /**
     * Update the texts on screen and automatically add the information to the replay vars as well
     */
    private void updateText() {
        cardsA.setText("Cards remaining:" + String.valueOf(game.getCardsRemaining(0)));
        replayCardsRemaining.add(game.getCardsRemaining(0));
        cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemaining(1)));
        replayCardsRemaining.add(game.getCardsRemaining(1));

        cardPlayedA.setText(game.getLastCardsPlayed()[0].toString());
        replayCardsPlayed.add(game.getLastCardsPlayed()[0].toString());

        cardPlayedB.setText(game.getLastCardsPlayed()[1].toString());
        replayCardsPlayed.add(game.getLastCardsPlayed()[1].toString());

        if (numOfPlayers == 3) {
            cardsC.setText("Cards remaining:" + String.valueOf(game.getCardsRemaining(2)));
            replayCardsRemaining.add(game.getCardsRemaining(2));

            cardPlayedC.setText(game.getLastCardsPlayed()[2].toString());
            replayCardsPlayed.add(game.getLastCardsPlayed()[2].toString());
        }
    }
}

