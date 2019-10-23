package com.example.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PictureGame {
    // list of ALL the pictures in the game
    private Picture[] pictures = new Picture[10];
    // to generate list of pictures
    private Random rand = new Random();
    // initialize HashMap of string and bitmap
    private Map<String, Bitmap> pictureMap  = new HashMap<String, Bitmap>() {{
        // creating apple
        Bitmap bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("apple", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("key2", bitmap);
    }};

    PictureGame(){
        // in here create the array of pictures
        int i = 0;
        for (Map.Entry<String, Bitmap> entry : pictureMap.entrySet()) {

            String key = entry.getKey(); // the name of the image
            Bitmap value = entry.getValue(); // the image
            int n = rand.nextInt(3); // this gives a 33% chance of having an image be found
            boolean found;
            // if n = 0, then we want this image to be found
            if (n == 0) {
                found = true;
            } else {
                found = false;
            }
            Picture pic = new Picture(found, key, value);
            pictures[i] = pic;
            // increase i by 1
            i++;
        }
    }
}
