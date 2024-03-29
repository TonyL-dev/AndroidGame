package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import java.text.DecimalFormat;

/**
 * The PictureGameActivity where the Picture Game is played.
 *
 * Learned how to time the start and end of each level from
 * https://developer.android.com/reference/java/lang/System
 */
public class PictureGameActivity extends AppCompatActivity {

    private PictureGame pictureGame;
    private TextView textView, textView2;

    //player
    private Player newPlayer;

    private PlayerDataBase playerDataBase;

    long start = System.nanoTime();

    private DecimalFormat df = new DecimalFormat("####0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_game);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);

        pictureGame = new PictureGame(newPlayer);
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.listOfFruits);

        ConstraintLayout relativeLayout = (ConstraintLayout) findViewById(R.id.linearLayout);

        textView.setText(pictureGame.fruitsToFind());

        //sets text colour
        if (newPlayer.getColour() != 0) {
            textView.setTextColor(newPlayer.getColour());
            textView2.setTextColor(newPlayer.getColour());
        }

        //sets background colour
        if (newPlayer.getbackColour() != 0) {
            relativeLayout.setBackgroundColor(newPlayer.getbackColour());
        }

    }

    /**
     * runs when an imageView has been clicked
     *
     * @param view the imageView that has been clicked
     */
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
                    textView.setText("");
                    textView2.setText("");
                    textView.setTextSize(18);
                    textView.setText(newPlayer.toString());

                    //increments number of games
                    newPlayer.addLevel();

                    //starts the next game
                    playerDataBase.storePlayerData(newPlayer);
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
                view.setVisibility(View.GONE);
            } else
                newPlayer.subtractPoints();
        }

    }
}