package com.example.game.PictureGame;

import java.io.Serializable;

class Picture implements Serializable {

    /**
     * true if it is to be found, false if you do not need to find it
     */

    private boolean isHiddenImage;

    /**
     * name of Picture
     */

    private String name;

    /**
     * int image of Picture
     */

    private int image;

    /**
     * Constructs a new Picture object
     *
     * @param x boolean for whether you need to find this Picture object or not
     * @param y the description of the Bitmap
     * @param z the int image of this Picture
     */

    Picture(boolean x, String y, int z) {
        isHiddenImage = x;
        name = y;
        image = z;
    }

    /**
     * Return isHiddenImage
     *
     * @Return isHiddenImage
     */

    boolean getIsHiddenImage() {
        // return value of isHiddenImage
        return isHiddenImage;
    }

    /**
     * Return the duplicate copy of this Picture object
     *
     * @return duplicate of this Picture object
     */

    Picture getDuplicate() {
        return new Picture(isHiddenImage, name, image);
    }

    /**
     * Return the name
     * @return name
     */

    String getName() {
        // return name of this Picture
        return name;
    }

    /**
     * Return the drawable int
     * @return image
     */

    int getImage() {
        // return Bitmap of this image
        return image;
    }

    /**
     * sets the isHiddenImage attribute
     * @param x the new boolean to be set
     */

    void setIsHiddenImage(boolean x) {
        // set the isHiddenImage attribute of this picture
        isHiddenImage = x;
    }
}
