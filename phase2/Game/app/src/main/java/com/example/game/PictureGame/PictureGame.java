package com.example.game.PictureGame;

import java.util.Random;

import com.example.game.Player;
import com.example.game.R;

class PictureGame {
    /**
     * array of Picture objects
     */
    private Picture[] pictures = new Picture[12];

    /**
     * player
     */
    private Player newPlayer;

    private Object[][] levelOne = {{"apple", R.drawable.apple},
            {"banana", R.drawable.banana},
            {"blueberry", R.drawable.blueberry},
            {"cherry", R.drawable.cherry},
            {"coconut", R.drawable.coconut},
            {"grapefruit", R.drawable.grapefruit},
            {"peach", R.drawable.peach},
            {"tomato", R.drawable.tomato},
            {"lemon", R.drawable.lemon},
            {"cantaloupe", R.drawable.cantaloupe},
            {"pear", R.drawable.pear},
            {"strawberry", R.drawable.strawberry}};

    private Object[][] levelTwo = {{"apple", R.drawable.apple},
            {"balloon", R.drawable.balloon},
            {"car", R.drawable.car},
            {"cherry", R.drawable.cherry},
            {"chair", R.drawable.chair},
            {"fire extinguisher", R.drawable.fireextinguisher},
            {"lady bug", R.drawable.ladybug},
            {"tomato", R.drawable.tomato},
            {"plate", R.drawable.plate},
            {"rose", R.drawable.rose},
            {"shoe", R.drawable.shoe},
            {"spoon", R.drawable.spoon}};

    private Object[][] levelThree = {{"38 - 33", R.drawable.five},
            {"square root of 121", R.drawable.eleven},
            {"21 x 2", R.drawable.fortytwo},
            {"15 + 4", R.drawable.nineteen},
            {"3 x 32", R.drawable.ninetysix},
            {"63 / 9", R.drawable.seven},
            {"2 x 37", R.drawable.seventyfour},
            {"24 x 3", R.drawable.seventytwo},
            {"8 x 8", R.drawable.sixtyfour},
            {"65 / 5", R.drawable.thirteen},
            {"square root of 144", R.drawable.twelve},
            {"7 x 3", R.drawable.twentyone}};

    /**
     * Constructs a new PictureGame
     *
     * @param player player object for this game
     */
    PictureGame(Player player, int level) {
        // in here create the array of pictures
        Random rand = new Random();
        newPlayer = player;
        Object[][] levelPictures;

        int i = 0;
        int j = 0;

        if (level == 1) {
            levelPictures = levelOne;
        } else if (level == 2) {
            levelPictures = levelTwo;
        } else {
            levelPictures = levelThree;
        }

        for (Object[] imagePair : levelPictures) {

            String key = imagePair[0].toString(); // the name of the image
            int value = (int) imagePair[1]; // the image

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


    /**
     * return string of remaining Picture objects to be found
     */
    StringBuilder picsToFind() {
        StringBuilder listOfFruits = new StringBuilder();

        for (Picture pic : pictures) {
            if (pic.getIsHiddenImage()) {
                listOfFruits.append(pic.getName() + "\n");
            }
        }
        return listOfFruits;
    }

    /**
     * Return whether this is a hidden object or not
     *
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
     * Return the new string of Picture objects to find and adds points to the Player
     *
     * @param imageId the ID of the imageView that has been found
     */
    StringBuilder foundHiddenImage(String imageId) {
        // runs when you found an image

        // sets the found picture .isHiddenImage to false since we don't need to find it anymore
        for (Picture pic : pictures) {
            if (pic.getName().equals(imageId)) {
                pic.setIsHiddenImage(false);
            }
        }

        newPlayer.addPoints();
        // return new fruits to find
        return picsToFind();
    }

    /**
     * Returns the pictures in the Picture list
     */
    Picture[] getPictures() {
        return pictures;
    }

}
