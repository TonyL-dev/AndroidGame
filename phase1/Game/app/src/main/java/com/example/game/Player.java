package com.example.game;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

//The player player
public class Player implements Serializable {
    private int points;

    private ArrayList<Double> time = new ArrayList<Double>();

    private String name;

    private String password;

    private static DecimalFormat df = new DecimalFormat("####0.00");

    private int colour=0;

    private int multiplier=1;

    private int numFruits;

    public Player() {
        this.name = "Default";
        this.password = "1234";
    }

    public Player(String username, String password, String colour, String multiplier,
                  String numFruits) {
        this.name = username;
        this.password = password;
        this.multiplier = Integer.parseInt(multiplier);
        this.numFruits = Integer.parseInt(numFruits);

        if (colour.equalsIgnoreCase("green"))
            this.colour = 0xFF00FF00;
        else if (colour.equalsIgnoreCase("red"))
            this.colour = 0xAAFF0000;
        else
            this.colour = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPoints() {
        return this.points;
    }

    public int getColour() {
        return this.colour;
    }

    public int getMultiplier() {
        return this.multiplier;
    }

    public int getNumFruits() {
        return this.numFruits;
    }

    public double getTime(int gameNum) {
        return this.time.get(gameNum - 1);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void addPoints() {
        this.points += this.multiplier;
    }

    public void addPoints(int newPoints) {
        this.points += newPoints*this.multiplier;
    }

    public void subtractPoints() {
        this.points -= this.multiplier;
    }

    public void addTime(double additionalTime) {
        this.time.add(additionalTime);
    }

    public String toString(){
        int gameNum = this.time.size();
        double totalGameTime = 0;
        for(double gameTime: time)
            totalGameTime += gameTime;
        return "\n\n You have " + getPoints() + " points now."+
                "\n\n This game took you " + df.format(getTime(gameNum)) + " seconds." +
                "\n In total you have taken " + df.format(totalGameTime) + " seconds! " +
                " You got this!";
    }
}
