package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
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

    public void imageClick(View view){
        // runs when image is clicked on
        String fruit = view.getTag().toString();
        boolean isHiddenImage = pictureGame.isHiddenImage(fruit);

        if(isHiddenImage){
            String newFruits = pictureGame.foundHiddenImage(fruit);
            textView.setText(newFruits);
            view.setVisibility(View.INVISIBLE);
        }

    }
}