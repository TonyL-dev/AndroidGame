package com.example.game;

import android.graphics.Bitmap;

public class Picture {
    // true if it is to be found, false if you do not need to find it
    private boolean isHiddenImage;
    // name of the image
    private String name;
    // the picture that represents this picture
    private Bitmap image;

    Picture(boolean x, String y, Bitmap z){
        isHiddenImage = x;
        name = y;
        image = z;
    }

    public boolean getIsHiddenImage(){
        // return value of isHiddenImage
        return isHiddenImage;
    }
    public String getName(){
        // return name of this Picture
        return name;
    }
    public Bitmap getImage(){
        // return Bitmap of this image
        return image;
    }
    public void setIsHiddenImage(boolean x){
        isHiddenImage = x;
    }
}
