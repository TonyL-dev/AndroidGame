package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class PictureGameActivity extends AppCompatActivity {

    private PictureGame pictureGame;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_game);

        pictureGame = new PictureGame();
        textView = findViewById(R.id.listOfFruits);
        textView.setText(pictureGame.fruitsToFind());

    }

    public void imageClick(View view) {
        // runs when image is clicked on
        String fruit = view.getTag().toString();
        boolean isHiddenImage = pictureGame.isHiddenImage(fruit);

        if (isHiddenImage) {
            // if player finds an image

            // find the updated set of fruits to look for
            String newFruits = pictureGame.foundHiddenImage(fruit);
            // set textview to those new fruits
            textView.setText(newFruits);
            // hide the fruit that was found
            view.setVisibility(View.INVISIBLE);
        }

    }
}