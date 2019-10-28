package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import java.text.DecimalFormat;

public class PictureGameActivity extends AppCompatActivity {

    private PictureGame pictureGame;
    TextView textView;

    //player
    private Player newPlayer;

    long start = System.nanoTime();

    DecimalFormat df = new DecimalFormat("####0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_game);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");

        pictureGame = new PictureGame(newPlayer);
        textView = findViewById(R.id.listOfFruits);
        textView.setText(pictureGame.fruitsToFind());
    }

    public void imageClick(View view) {
        // runs when image is clicked on

        if (view.getTag() != null) {
            String fruit = view.getTag().toString();
            boolean isHiddenImage = pictureGame.isHiddenImage(fruit);

            if (isHiddenImage) {
                // if player finds an image

                // find the updated set of fruits to look for
                String newFruits = pictureGame.foundHiddenImage(fruit);
                // set textview to those new fruits

                if (newFruits.equals("")) {
                    // if the player has won the game
                    long end = System.nanoTime();
                    long time = end - start;
                    double timeInSeconds = (double) time / 1_000_000_000;
                    newPlayer.addTime(timeInSeconds);
                    textView.setText("\nYou won the game! " +
                            "\nMoving on to the next level in 3 seconds" +
                            "\n\nTime taken to complete this game: " + df.format(timeInSeconds) +
                            " seconds");
                    Intent intent = new Intent(this, WarGameActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("player", newPlayer);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    // else keep playing
                    textView.setText(newFruits);
                }
                // hide the fruit that was found
                view.setVisibility(View.INVISIBLE);
            } else
                newPlayer.subtractPoints();
        }


    }
}