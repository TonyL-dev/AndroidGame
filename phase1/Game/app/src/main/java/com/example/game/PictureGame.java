package com.example.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PictureGame {
    // list of ALL the pictures in the game
    private Picture[] pictures = new Picture[8];
    // to generate list of pictures
    private Random rand = new Random();
    // initialize HashMap of string and bitmap
    private Map<String, Bitmap> pictureMap  = new HashMap<String, Bitmap>() {{
        Bitmap bitmap;

        bitmap = BitmapFactory.decodeFile("picturegame/apple.png");
        put("apple", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/banana.png");
        put("banana", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/blueberry.png");
        put("blueberry", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/cherry.png");
        put("cherry", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/coconut.png");
        put("coconut", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/grapefruit.png");
        put("grapefruit", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/peach.png");
        put("peach", bitmap);

        bitmap = BitmapFactory.decodeFile("picturegame/tomato.png");
        put("tomato", bitmap);
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

    void play(){
        // play gamee
    }
    private boolean isHiddenImage(String imageId){
        // return whether this image is to be found or not
        for (Picture pic: pictures){
            if(pic.getName().equals(imageId)){
                // if this is the picture that has been clicked, return whether it is hidden or not
                return pic.getIsHiddenImage();
            }
        }
        // else return false
        return false;
    }
}
