package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *The WarGameActivity class where player plays WarGame
 */
public class WarGameActivity extends AppCompatActivity {

    Player newPlayer;
    private WarGame game;
    TextView cardsA, cardsB, cardPlayedA, cardPlayedB;

    long start = System.nanoTime();

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
        cardsA.setText("Cards remaining:" + game.getCardsRemainingA());

        cardsB = findViewById(R.id.cardRemainingB);
        cardsB.setText("Cards remaining:" + game.getCardsRemainingB());

        cardPlayedA = findViewById(R.id.currentCardA);
        cardPlayedB = findViewById(R.id.currentCardB);

        if (newPlayer.getColour() != 0) {
            cardsA.setTextColor(newPlayer.getColour());
            cardsB.setTextColor(newPlayer.getColour());
            cardPlayedA.setTextColor(newPlayer.getColour());
            cardPlayedB.setTextColor(newPlayer.getColour());
        }
        if (newPlayer.getbackColour() != 0) {
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

        //    Button button = (Button) findViewById(R.id.playButton);
        //    button.setOnClickListener(
        //        new View.OnClickListener() {
        //          @Override
        //          public void onClick(View v) {
        //            if (!game.checkEndGame()) game.play();
        //            else {
        //              openScoreScreen();
        //            }
        //            cardsA.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingA()));
        //            cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingB()));
        //            cardPlayedA.setText(game.getLastCardsPlayed()[0].toString());
        //            cardPlayedB.setText(game.getLastCardsPlayed()[1].toString());
        //          }
        //        });
        //    Button skip = (Button) findViewById(R.id.skipButton);
        //    skip.setOnClickListener(
        //        new View.OnClickListener() {
        //          @Override
        //          public void onClick(View v) {
        //            openScoreScreen();
        //          }
        //        });
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
        cardsA.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingA()));
        cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingB()));
        cardPlayedA.setText(game.getLastCardsPlayed()[0].toString());
        cardPlayedB.setText(game.getLastCardsPlayed()[1].toString());
    }

    // open the screen to display who won and transition to the next game
    //  public void openScoreScreen() {
    //    long end = System.nanoTime();
    //    long time = end - start;
    //    double timeInSeconds = (double) time / 1_000_000_000;
    //    newPlayer.addTime(timeInSeconds);
    //    Intent intent = new Intent(this, WarGameEndScreenActivity.class);
    //    Bundle bundle = new Bundle();
    //    bundle.putSerializable("points", game.toString());
    //    bundle.putSerializable("player", newPlayer);
    //    intent.putExtras(bundle);
    //    startActivity(intent);
    //  }
}
