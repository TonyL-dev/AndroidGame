package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WarGameActivity extends AppCompatActivity {

    //player
    Player newPlayer;
    private WarGame game;

    long start = System.nanoTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_war_game);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        game = new WarGame(newPlayer);

        final TextView cardsA = findViewById(R.id.cardRemainingA);
        cardsA.setText("Cards remaining:" + game.getCardsRemainingA());

        final TextView cardsB = findViewById(R.id.cardRemainingB);
        cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingB()));

        final TextView cardPlayedA = findViewById(R.id.currentCardA);
        final TextView cardPlayedB = findViewById(R.id.currentCardB);

        if (newPlayer.getColour()!=0) {
            cardsA.setTextColor(newPlayer.getColour());
            cardsB.setTextColor(newPlayer.getColour());
            cardPlayedA.setTextColor(newPlayer.getColour());
            cardPlayedB.setTextColor(newPlayer.getColour());
        }

        Button button = (Button) findViewById(R.id.playButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!game.checkEndGame())
                    game.play();
                else {
                    openScoreScreen();
                }
                cardsA.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingA()));
                cardsB.setText("Cards remaining:" + String.valueOf(game.getCardsRemainingB()));
                cardPlayedA.setText(game.getLastCardsPlayed()[0].toString());
                cardPlayedB.setText(game.getLastCardsPlayed()[1].toString());
            }
        });

        Button skip = (Button) findViewById(R.id.skipButton);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreScreen();
            }
        });
    }

    //open the screen to display who won and transition to the next game
    public void openScoreScreen() {
        long end = System.nanoTime();
        long time = end - start;
        double timeInSeconds = (double) time / 1_000_000_000;
        newPlayer.addTime(timeInSeconds);
        Intent intent = new Intent(this, WarGameEndScreen.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("points", game.toString());
        bundle.putSerializable("player", newPlayer);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
