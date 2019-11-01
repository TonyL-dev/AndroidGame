package com.example.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class PictureGame {
    /** array of Picture objects*/
    private Picture[] pictures = new Picture[12];

    /** player*/
    private Player newPlayer;

    /** generates a HashMap of names and their respective Bitmap image*/
    private Map<String, Bitmap> pictureMap = new HashMap<String, Bitmap>() {{
        Bitmap bitmap;

        bitmap = BitmapFactory.decodeFile("drawable/apple.png");
        put("apple", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/banana.png");
        put("banana", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/blueberry.png");
        put("blueberry", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/cherry.png");
        put("cherry", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/coconut.png");
        put("coconut", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/grapefruit.png");
        put("grapefruit", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/peach.png");
        put("peach", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/tomato.png");
        put("tomato", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/lemon.png");
        put("lemon", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/cantaloupe.png");
        put("cantaloupe", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/pear.png");
        put("pear", bitmap);

        bitmap = BitmapFactory.decodeFile("drawable/strawberry.png");
        put("strawberry", bitmap);
    }};

    /**
     * Constructs a new PictureGame
     *
     * @param player   player object for this game
     * */
    PictureGame(Player player) {
        // in here create the array of pictures
        Random rand = new Random();
        newPlayer = player;

        int i = 0;
        int j = 0;

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
                j++;
            }
            Picture pic = new Picture(found, key, value);
            pictures[i] = pic;
            // increase i by 1
            i++;
        }

        if (j == 12) {
            int m = rand.nextInt(12);
            pictures[m].setIsHiddenImage(true);
        }
    }
    /** return string of remaining Picture objects to be found*/
    String fruitsToFind() {
        StringBuilder listOfFruits = new StringBuilder();

        for (Picture pic : pictures) {
            if (pic.getIsHiddenImage()) {
                listOfFruits.append(pic.getName() + "\n");
            }
        }
        return listOfFruits.toString();
    }

    /**
     * Return whether this is a hidden object or not
     * @param imageId the ID of the imageView
     */
    boolean isHiddenImage(String imageId) {
        // return whether this image is to be found or not
        for (Picture pic : pictures) {
            if (pic.getName().equals(imageId)) {
                // if this is the picture that has been clicked, return whether it is hidden or not
                return pic.getIsHiddenImage();
            }
        }
        // else return false
        return false;
    }

    /**
     * Return the new string of Picture objects to find
     *
     * @param imageId the ID of the imageView that has been found
     * */
    String foundHiddenImage(String imageId) {
        // runs when you found an image

        // sets the found picture .isHiddenImage to false since we don't need to find it anymore
        for (Picture pic : pictures) {
            if (pic.getName().equals(imageId)) {
                pic.setIsHiddenImage(false);
            }
        }

        newPlayer.addPoints();
        System.out.println(newPlayer.getPoints());
        // return new fruits to find
        return fruitsToFind();
    }

}
