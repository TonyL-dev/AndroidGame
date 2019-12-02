package com.example.game.PlayerPackage;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatistics implements Serializable {

    /**
     * The Player's points
     */
    private int points;

    /**
     * The Player's time for each game
     */
    private List<Double> time = new ArrayList<>();

    /**
     * The Player's game (that they are currently playing)
     */
    private int gameNum = 0;

    private static DecimalFormat df = new DecimalFormat("####0.00");

    /**
     * default constructor for PlayerStatistics
     */
    public PlayerStatistics(){
    }

    /**
     * constructor for PlayerStatistics to be used in Player class
     */
    public PlayerStatistics(int gameNum, int points, double time){
        this.gameNum = gameNum;
        this.points = points;
        this.time.add(time);
    }

    /**
     * get the player's points
     *
     * @return points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * get the player's game number (that they are on)
     *
     * @return gameNum
     */
    int getGameNum() {
        return this.gameNum;
    }

    /**
     * get the player's time for a specific game
     *
     * @param gameNum
     * @return time.get(gameNum - 1)
     */
    public double getTime(int gameNum) {
        return this.time.get(gameNum - 1);
    }

    /**
     * get the time list size
     *
     * @return time.size()
     */
    public double getTime() {
        return this.time.size();
    }

    /**
     * get the last time added
     *
     * @return this.time.get(time.size()-1)
     */
    public double getLastTime() {
        return this.time.get(time.size()-1);
    }

    /**
     * remove Player's most recent game time
     */
    public void subtractTime() {
        this.time.remove(this.time.size() - 1);
    }

    /**
     * get the player's total time
     *
     * @return sum
     */
    float getTotalTime() {
        float sum = 0;
        for (int i = 0; i < this.time.size(); i++)
            sum += this.time.get(i);
        return sum;
    }

    /**
     * add points to the Player's points (increment)
     */
    public void addPoints(int multiplier) {
        this.points += multiplier;
    }

    /**
     * add points to the Player's points
     *
     * @param newPoints
     */
    public void addPoints(int newPoints, int multiplier) {
        this.points += newPoints * multiplier;
    }

    /**
     * subtract points from the Player's points  (decrement)
     */
    public void subtractPoints(int multiplier) {
        this.points -= multiplier;
    }

    /**
     * subtract points from the Player's points
     *
     * @param subPoints
     */
    public void subtractPoints(int subPoints, int multiplier) {
        this.points -= subPoints * multiplier;
    }

    /**
     * add time of a game to the Player's total time
     *
     * @param additionalTime
     */
    public void addTime(double additionalTime) {
        this.time.add(additionalTime);
    }

    /**
     * reset game statistics after a Player finishes all 3 games
     */
    public void resetTime() {
        this.time.clear();
    }

    /**
     * reset game statistics after a Player finishes all 3 games
     */
    public void reset() {
        this.time.clear();
        this.points = 0;
        this.gameNum = 0;
    }

    /**
     * increment gameNum after a player finishes a level
     */
    public void addLevel(int level) {
        this.gameNum = level;
    }

    /**
     * String representation of the Player
     */
    public String toString() {
        System.out.println(time.get(0));
        if (time.size()>1)
            System.out.println(time.get(1));
        return "\nYou have " + getPoints() + " total points now." +
                "\nThe last level took " + df.format(getLastTime()) + " seconds." +
                "\n\nIn total you have taken " + df.format((this.getTotalTime())) + " seconds! ";
    }
}
