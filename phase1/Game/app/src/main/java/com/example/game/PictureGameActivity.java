package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import java.text.DecimalFormat;

public class PictureGameActivity extends AppCompatActivity {

    private PictureGame pictureGame;
    TextView textView, textView2;

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
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.listOfFruits);
        textView.setText(pictureGame.fruitsToFind());
        if (newPlayer.getColour()!=0) {
            textView.setTextColor(newPlayer.getColour());
            textView2.setTextColor(newPlayer.getColour());
        }

        if (newPlayer.getbackColour()!=0) {
            textView.setBackgroundColor(newPlayer.getbackColour());
            textView2.setBackgroundColor(newPlayer.getbackColour());
            getWindow().getDecorView().setBackgroundColor(newPlayer.getbackColour());
        }

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
                    textView.setText("");
                    textView2.setText("");
                    textView.setTextSize(18);
                    textView.setText(newPlayer.toString());
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