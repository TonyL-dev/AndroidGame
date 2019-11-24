package com.example.game.PictureGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import com.example.game.Player;
import com.example.game.PlayerDataBase;
import com.example.game.R;

import android.os.Handler;

import java.text.DecimalFormat;

/**
 * The PictureGameActivity where the Picture Game is played.
 * <p>
 * Learned how to time the start and end of each level from
 * https://developer.android.com/reference/java/lang/System
 */
public class PictureGameActivity extends AppCompatActivity {

    /** PictureGame object*/
    private PictureGame pictureGame;

    /** TextView for where the title and list of objects will be displayed*/
    private TextView textView, textView2;

    /** Initially the player starts on the first level*/
    private int level = 1;

    /** Player object*/
    private Player newPlayer;

    /** PlayerDataBase where the player is stored*/
    private PlayerDataBase playerDataBase;

    /** How the game's time for each level is determined. The timer starts at initialization.*/
    private long start = System.nanoTime();

    /** Decimal Format for the number of seconds rounded to two decimal places.*/
    private DecimalFormat df = new DecimalFormat("####0.00");

    /**
     * Created on run. Sets up the game board to have the appropriate pictures for the level.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_game);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        newPlayer = (Player) bundle.getSerializable("player");
        playerDataBase = new PlayerDataBase(this);

        pictureGame = new PictureGame(newPlayer, level);
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.listOfFruits);
        setGameBoard();

        ConstraintLayout relativeLayout = (ConstraintLayout) findViewById(R.id.linearLayout);

        textView.setText(pictureGame.picsToFind().toString());

        //sets text colour
        if (newPlayer.getColour() != 0) {
            textView.setTextColor(newPlayer.getColour());
            textView2.setTextColor(newPlayer.getColour());
        }

        //sets background colour
        if (newPlayer.getbackColour() != 0) {
            relativeLayout.setBackgroundColor(newPlayer.getbackColour());
        }

        //increments number of games
        newPlayer.addLevel(1);
        newPlayer.resetTime();
        playerDataBase.storePlayerData(newPlayer);

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
                String newFruits = pictureGame.foundHiddenImage(fruit).toString();

                // set textview to those new fruits
                if (newFruits.equals("")) {
                    // if the player has won the game
                    if (level == 3) { // end the pictureGame
                        determineTime(view);

                        //starts the next game
                        Intent intent = new Intent(this,
                                PictureEndScreenActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("player", newPlayer);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    } else { // if the PictureGame has more levels
                        determineTime(view);
                        level++;
                        nextLevel();
                    }
                } else {
                    // else keep playing
                    textView.setText(newFruits);
                    // hide the fruit that was found
                    view.setVisibility(View.INVISIBLE);
                }
            } else {
                newPlayer.subtractPoints();
            }
        }
    }

    /**
     * Determines the time taken for the level that was just completed.
     */
    private void determineTime(View view){
        view.setVisibility(View.INVISIBLE);
        findViewById(R.id.textView2).setVisibility(View.INVISIBLE);
        long end = System.nanoTime();
        long time = end - start;
        double timeInSeconds = (double) time / 1_000_000_000;
        double temp=timeInSeconds;

        for(int i=0;i<newPlayer.getTime();i++)
        {
            temp-= newPlayer.getTime(level-(i+1));
        }

        temp-=(level-1)*3;
        newPlayer.addTime(temp);

        textView.setText("You have " + newPlayer.getPoints() + " points now.\n\n"
                + "This round took you " + (df.format(newPlayer.getTime(level))) + " seconds.");
    }
    /**
     * Sets the game board based on which level the player is on.
     */
    private void setGameBoard() {

        if (level == 2) {
            findViewById(R.id.redBackground).setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.redBackground).setVisibility(View.INVISIBLE);
        }
        ((ImageView) findViewById(R.id.one)).
                setImageResource(pictureGame.getPictures()[0].getImage());
        findViewById(R.id.one).setTag(pictureGame.getPictures()[0].getName());

        ((ImageView) findViewById(R.id.two)).
                setImageResource(pictureGame.getPictures()[1].getImage());
        findViewById(R.id.two).setTag(pictureGame.getPictures()[1].getName());

        ((ImageView) findViewById(R.id.three)).
                setImageResource(pictureGame.getPictures()[2].getImage());
        findViewById(R.id.three).setTag(pictureGame.getPictures()[2].getName());

        ((ImageView) findViewById(R.id.four)).
                setImageResource(pictureGame.getPictures()[3].getImage());
        findViewById(R.id.four).setTag(pictureGame.getPictures()[3].getName());

        ((ImageView) findViewById(R.id.five)).
                setImageResource(pictureGame.getPictures()[4].getImage());
        findViewById(R.id.five).setTag(pictureGame.getPictures()[4].getName());

        ((ImageView) findViewById(R.id.six)).
                setImageResource(pictureGame.getPictures()[5].getImage());
        findViewById(R.id.six).setTag(pictureGame.getPictures()[5].getName());

        ((ImageView) findViewById(R.id.seven)).
                setImageResource(pictureGame.getPictures()[6].getImage());
        findViewById(R.id.seven).setTag(pictureGame.getPictures()[6].getName());

        ((ImageView) findViewById(R.id.eight)).
                setImageResource(pictureGame.getPictures()[7].getImage());
        findViewById(R.id.eight).setTag(pictureGame.getPictures()[7].getName());

        ((ImageView) findViewById(R.id.nine)).
                setImageResource(pictureGame.getPictures()[8].getImage());
        findViewById(R.id.nine).setTag(pictureGame.getPictures()[8].getName());

        ((ImageView) findViewById(R.id.ten)).
                setImageResource(pictureGame.getPictures()[9].getImage());
        findViewById(R.id.ten).setTag(pictureGame.getPictures()[9].getName());

        ((ImageView) findViewById(R.id.eleven)).
                setImageResource(pictureGame.getPictures()[10].getImage());
        findViewById(R.id.eleven).setTag(pictureGame.getPictures()[10].getName());

        ((ImageView) findViewById(R.id.twelve)).
                setImageResource(pictureGame.getPictures()[11].getImage());
        findViewById(R.id.twelve).setTag(pictureGame.getPictures()[11].getName());

        findViewById(R.id.one).setVisibility(View.VISIBLE);
        findViewById(R.id.two).setVisibility(View.VISIBLE);
        findViewById(R.id.three).setVisibility(View.VISIBLE);
        findViewById(R.id.four).setVisibility(View.VISIBLE);
        findViewById(R.id.five).setVisibility(View.VISIBLE);
        findViewById(R.id.six).setVisibility(View.VISIBLE);
        findViewById(R.id.seven).setVisibility(View.VISIBLE);
        findViewById(R.id.eight).setVisibility(View.VISIBLE);
        findViewById(R.id.nine).setVisibility(View.VISIBLE);
        findViewById(R.id.ten).setVisibility(View.VISIBLE);
        findViewById(R.id.eleven).setVisibility(View.VISIBLE);
        findViewById(R.id.twelve).setVisibility(View.VISIBLE);

    }

    /**
     * iterates the game to the next level. The transition also takes 3 seconds.
     */
    private void nextLevel() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                pictureGame = new PictureGame(newPlayer, level);
                setGameBoard();
                textView.setText(pictureGame.picsToFind().toString());
                findViewById(R.id.textView2).setVisibility(View.VISIBLE);
            }
        }, 3000);

    }
}