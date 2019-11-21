package com.example.game;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

//temp

/**
 * The Player that plays through the games.
 */

public class Player implements Serializable {

    /** The Player's points*/
    private int points;

    /** The Player's time for each game*/
    private ArrayList<Double> time = new ArrayList<Double>();

    /** The Player's username*/
    private String name;

    /** The Player's password*/
    private String password;

    /** The Player's text colour*/
    private int colour = 0;

    /** The Player's score multiplier*/
    private int multiplier = 1;

    /** The Player's background colour*/
    private int backColour = 0;

    /** The Player's game (that they are currently playing)*/
    private int gameNum = 0;

    private static DecimalFormat df = new DecimalFormat("####0.00");

    /**
     * construct default Player
     */

    public Player() {
        this.name = "Default";
        this.password = "1234";
    }

    /**
     * construct a new Player
     *
     * @param username assign the Player a username
     * @param password assign the Player a password
     * @param colour assign the Player a text colour for the games
     * @param multiplier assign the Player a score multiplier for the games
     * @param backColour assign the Player a background colour for the games
     */
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

    /**
     * construct a new Player that was created before (login)
     *
     * @param username assign the Player a username
     * @param password assign the Player a password
     * @param colour assign the Player a text colour for the games
     * @param multiplier assign the Player a score multiplier for the games
     * @param backColour assign the Player a background colour for the games
     * @param gameNum assign the Player the game number they are playing through
     * @param points assign the Player the number of points they have earned so far
     * @param time assign the Player the total time they have taken for games they've played
     */
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

    /**
     * get the player's username
     *
     * @return name
     */
    String getName() {
        return this.name;
    }

    /**
     * get the player's password
     *
     * @return password
     */
    String getPassword() {
        return this.password;
    }

    /**
     * get the player's points
     *
     * @return points
     */
    int getPoints() {
        return this.points;
    }

    /**
     * get the player's text colour
     *
     * @return colour
     */
    public int getColour() {
        return this.colour;
    }

    /**
     * get the player's score multiplier
     *
     * @return multiplier
     */
    public int getMultiplier() {
        return this.multiplier;
    }

    /**
     * get the player's background colour
     *
     * @return backColour
     */
    public int getbackColour() {
        return this.backColour;
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
     *
     * @return time.get(gameNum-1)
     */
    double getTime(int gameNum) {
        return this.time.get(gameNum - 1);
    }

    /**
     * remove Player's most recent game time
     */
    public void subtractTime() {
        this.time.remove(this.time.size()-1);
    }

    /**
     * get the player's total time
     *
     * @return sum
     */
    float getTotalTime(){
        float sum = 0;
        for(int i = 0; i < this.time.size(); i++)
            sum += this.time.get(i);
        return sum;
    }

    /**
     * set the player's username
     *
     * @param newName
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * set the player's password
     *
     * @param newPassword
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * add points to the Player's points (increment)
     */
    public void addPoints() {
        this.points += this.multiplier;
    }

    /**
     * add points to the Player's points
     *
     * @param newPoints
     */
    public void addPoints(int newPoints) {
        this.points += newPoints * this.multiplier;
    }

    /**
     * subtract points from the Player's points  (decrement)
     */
    public void subtractPoints() {
        this.points -= this.multiplier;
    }

    /**
     * subtract points from the Player's points
     *
     * @param subPoints
     */
    public void subtractPoints(int subPoints) {
        this.points -= subPoints * this.multiplier;
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
    public void reset() {
        this.time.clear();
        this.points = 0;
        this.gameNum = 1;
    }

    /**
     * increment gameNum after a player finishes a level
     */
    public void addLevel() {
        this.gameNum++;
    }

    /**
     * String representation of the Player
     */
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
