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

    private int colour = 0;

    private int multiplier = 1;

    private int backColour = 0;

    private int gameNum = 0;

    public Player() {
        this.name = "Default";
        this.password = "1234";
    }

    public Player(String username, String password, String colour, String multiplier,
                  String backColour) {

        this.name = username;
        this.password = password;

        if (multiplier.equals(""))
            this.multiplier = 1;
        else if (Integer.parseInt(multiplier) <= 0)
            this.multiplier = 1;
        else
            this.multiplier = Integer.parseInt(multiplier);

        if (backColour.equalsIgnoreCase("blue"))
            this.backColour = 0xAA00BFFF;
        else if (backColour.equalsIgnoreCase("purple"))
            this.backColour = 0xAA9900FF;
        else
            this.backColour = 0;

        if (colour.equalsIgnoreCase("green"))
            this.colour = 0xFF00FF00;
        else if (colour.equalsIgnoreCase("red"))
            this.colour = 0xAAFF0000;
        else
            this.colour = 0;
    }

    public Player(String username, String password, int colour, int multiplier,
                  int backColour, int gameNum, int points, double time) {

        this.name = username;
        this.password = password;
        this.multiplier = multiplier;
        this.colour = colour;
        this.backColour = backColour;
        this.gameNum = gameNum;
        this.points = points;
        this.time.add(time);
    }

    public String getName() {
        return this.name;
    }

    String getPassword() {
        return this.password;
    }

    int getPoints() {
        return this.points;
    }

    int getColour() {
        return this.colour;
    }

    int getMultiplier() {
        return this.multiplier;
    }

    int getbackColour() {
        return this.backColour;
    }

    int getGameNum() {
        return this.gameNum;
    }

    private double getTime(int gameNum) {
        return this.time.get(gameNum - 1);
    }

    void subtractTime() {
        this.time.remove(this.time.size()-1);
    }

    float getTotalTime(){
        float sum = 0;
        for(int i = 0; i < this.time.size(); i++)
            sum += this.time.get(i);
        return sum;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    void addPoints() {
        this.points += this.multiplier;
    }

    void addPoints(int newPoints) {
        this.points += newPoints * this.multiplier;
    }

    void subtractPoints() {
        this.points -= this.multiplier;
    }

    void subtractPoints(int subPoints) {
        this.points -= subPoints * this.multiplier;
    }

    void addTime(double additionalTime) {
        this.time.add(additionalTime);
    }

    void reset() {
        this.time.clear();
        this.points = 0;
        this.gameNum = 1;
    }

    void addLevel() {
        this.gameNum++;
    }

    public String toString() {
        int gameNum = this.time.size();
        double totalGameTime = 0;
        for (double gameTime : time)
            totalGameTime += gameTime;
        return "\nYou have " + getPoints() + " points now." +
                "\n\nThis game took you " + df.format(getTime(gameNum)) + " seconds." +
                "\nIn total you have taken " + df.format(totalGameTime) + " seconds! ";
    }
}
