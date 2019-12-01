package com.example.game.WarGame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.PlayerPackage.ChooseGame;
import com.example.game.PlayerPackage.Player;
import com.example.game.PlayerPackage.PlayerDataBase;
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
    private Player newPlayer;

    /**
     * PlayerDataBase where the player is stored
     */
    private PlayerDataBase playerDataBase;

    /**
     * The time in seconds
     */
    double timeInSeconds;

    /**
     * Index for the current place in the array for the number of cards
     */
    private int indexForNumOfCards;

    /**
     * Index for the current place in the array for the last card that was played
     */
    private int indexForLastCardPlayed;

    /**
     * List of all number of cards remaining for the entire level
     */
    private List<Integer> replayCardsRemaining;

    /**
     * List of all number of last cards played by all players for the entire level
     */
    private List<String> replaysCardPlayed;

    /**
     * The number of players
     */
    private int numPlayers;

    /**
     * The text that is displayed after the game is finished to inform user how they did
     */
    private String textOutput;

    /**
     * Textview for the different cards and the counts of remaining cards
     */
    private TextView cardsA, cardsB, cardsC, cardPlayedA, cardPlayedB, cardPlayedC;

    /**
     * Sets up the end screen
     *
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


        replayCardsRemaining = (ArrayList) bundle.getSerializable("replayCardsRemaining");
        replaysCardPlayed = (ArrayList) bundle.getSerializable("replayCardsPlayed");

        newPlayer.addTime(timeInSeconds);
        textOutput = stats.concat(newPlayer.toString());

        endScreenStartUp();
    }

    /**
     * Does the necessary things to the screen that is not related to getting things out of the
     * intent such as setting text, background color, buttons. (Mainly for readability of code)
     */
    private void endScreenStartUp() {
        //user can't play beyond 3 players
        if (numPlayers == 3)
            findViewById(R.id.playNextLevel).setVisibility(View.GONE);

        TextView textView = findViewById(R.id.endGameStats);
        textView.setText(textOutput);

        if (newPlayer.getColour() != 0)
            textView.setTextColor(newPlayer.getColour());

        if (newPlayer.getBackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getBackColour());
        }

        newPlayer.addTime(timeInSeconds);
    }

    /**
     * starts the next level of war game - 3 players
     *
     * @param view a View object
     */
    public void startNewWarGame(View view) {
        Intent intent = new Intent(this, WarGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("numPlayers", 3);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Goes to the Choose Game menu
     *
     * @param view a View object
     */
    public void goToMainMenu(View view) {
        newPlayer.reset(); // resets Player statistics
        playerDataBase.storePlayerData(newPlayer);
        Intent intent = new Intent(this, ChooseGame.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Returns how many cards this player has: organized so for 2 players the first num is always
     * the user and the second num is always the AI (same logic for 3 players)
     *
     * @return the number of cards this player has
     */
    private int getNextNumCardsRemaining() {
        indexForNumOfCards++;
        return replayCardsRemaining.get(indexForNumOfCards - 1);
    }

    /**
     * Returns the text version of the next card played: organized so for 2 players the first card
     * is always the user and the second card is always the AI (same logic for 3 players)
     *
     * @return the text version of the next card to be played
     */
    private String getNextCardPlayed() {
        indexForLastCardPlayed++;
        return replaysCardPlayed.get(indexForLastCardPlayed - 1);
    }

    /**
     * Updates all the strings on screen
     */
    private void updateStrings() {
        ((TextView) findViewById(R.id.currentCardA)).setText(getNextCardPlayed());
        ((TextView) findViewById(R.id.currentCardB)).setText(getNextCardPlayed());
        ((TextView) findViewById(R.id.cardRemainingA)).setText("Cards remaining:" + getNextNumCardsRemaining());
        ((TextView) findViewById(R.id.cardRemainingB)).setText("Cards remaining:" + getNextNumCardsRemaining());
        if (numPlayers == 3) {
            ((TextView) findViewById(R.id.currentCardC)).setText(getNextCardPlayed());
            ((TextView) findViewById(R.id.cardRemainingC)).setText("Cards remaining:" + getNextNumCardsRemaining());
        }
    }

    /**
     * Replays the last level played. Pauses for 3 seconds for each round
     *
     * @param view a View object
     */
    public void replayGame(View view) {
        indexForLastCardPlayed = 0;
        indexForNumOfCards = 0;
        int time = replayCardsRemaining.size() / numPlayers * 3000;

        if (numPlayers == 2)
            setContentView(R.layout.activity_war_game);
        else {
            setContentView(R.layout.activity_war_game_two);
        }

        if (newPlayer.getColour() != 0) {
            cardsA = findViewById(R.id.cardRemainingA);
            cardsA.setTextColor(newPlayer.getColour());
            cardsB = findViewById(R.id.cardRemainingB);
            cardsB.setTextColor(newPlayer.getColour());
            cardPlayedA = findViewById(R.id.currentCardA);
            cardPlayedA.setTextColor(newPlayer.getColour());
            cardPlayedB = findViewById(R.id.currentCardB);
            cardPlayedB.setTextColor(newPlayer.getColour());
            if (numPlayers!=2)
            {
                cardsC = findViewById(R.id.cardRemainingC);
                cardsC.setTextColor(newPlayer.getColour());
                cardPlayedC = findViewById(R.id.currentCardC);
                cardPlayedC.setTextColor(newPlayer.getColour());
            }
        }

        //disable the play and skip button so they can't be clicked
        findViewById(R.id.playButton).setEnabled(false);
        findViewById(R.id.skipButton).setEnabled(false);

        new CountDownTimer(time, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateStrings();
            }

            @Override
            public void onFinish() {
                setContentView(R.layout.activity_war_game_end_screen);
                ((TextView) findViewById(R.id.endGameStats)).setText(textOutput);
                ((TextView) findViewById(R.id.endGameStats)).setTextColor(newPlayer.getColour());

                //disable the option to play the next level (which doesn't exist)
                if (numPlayers == 3)
                    findViewById(R.id.playNextLevel).setVisibility(View.GONE);
            }
        }.start();
    }
}
