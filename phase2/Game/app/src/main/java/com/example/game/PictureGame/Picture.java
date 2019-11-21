package com.example.game.PictureGame;

import android.graphics.Bitmap;

public class Picture {
    /** true if it is to be found, false if you do not need to find it */
    private boolean isHiddenImage;
    /** name of Picture*/
    private String name;
    /** Bitmap image of Picture*/
    private Bitmap image;

    /**
     * Constructs a new Picture object
     *
     * @param x  boolean for whether you need to find this Picture object or not
     * @param y  the description of the Bitmap
     * @param z  the Bitmap image of this Picture
     */

    Picture(boolean x, String y, Bitmap z) {
        isHiddenImage = x;
        name = y;
        image = z;
    }

    /** return isHiddenImage*/
    boolean getIsHiddenImage() {
        // return value of isHiddenImage
        return isHiddenImage;
    }

    /** return the name*/
    String getName() {
        // return name of this Picture
        return name;
    }

    /** return the Bitmap image*/
    public Bitmap getImage() {
        // return Bitmap of this image
        return image;
    }

    /** sets the isHiddenImage attribute*/
    void setIsHiddenImage(boolean x) {
        // set the isHiddenImage attribute of this picture
        isHiddenImage = x;
    }
}
