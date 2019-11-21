package com.example.game.WarGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Player;
import com.example.game.R;

/**
 *The WarGameActivity class where player plays WarGame
 */
public class WarGameActivity extends AppCompatActivity {

    private Player newPlayer;
    private WarGame game;
    private TextView cardsA, cardsB, cardPlayedA, cardPlayedB;

    private long start = System.nanoTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_game);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        game = new WarGame(newPlayer);

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
        int temp = game.getPlayerA().getScore();
        Intent intent = new Intent(this, WarGameEndScreenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("points", game.toString());
        bundle.putSerializable("player", newPlayer);
        bundle.putSerializable("temp", temp);
        bundle.putSerializable("time", timeInSeconds);
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
