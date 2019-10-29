package com.example.game;

import java.io.Serializable;
import java.util.ArrayList;

//The player player
public class Player implements Serializable {
    //TODO: Statistic variables

    private int points;

    private ArrayList<Double> time = new ArrayList<Double>();

    private String name;

    private String password;

    public Player() {
        this.name = "Default";
        this.password = "1234";
    }

    public Player(String username, String password) {
        this.name = username;
        this.password = password;
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
        this.points += 100;
    }

    public void addPoints(int newPoints) {
        this.points += newPoints;
    }

    public void subtractPoints() {
        this.points -= 100;
    }

    public void addTime(double additionalTime) {
        this.time.add(additionalTime);
    }

    public String toString(){
        int gameNum = this.time.size();
        double totalGameTime = 0;
        for(double gameTime: time)
            totalGameTime += gameTime;
        return "\n\n This game took you " + getTime(gameNum) + " seconds." +
                "\n In total you have taken " + totalGameTime + " seconds! You got this!";
    }
}
