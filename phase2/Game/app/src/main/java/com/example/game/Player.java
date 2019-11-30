package com.example.game;

import java.io.Serializable;

/**
 * The Player that plays through the games.
 */

public class Player implements Serializable, GeneralPlayer {

    private PlayerCustomizations custom;

    private PlayerStatistics stats = new PlayerStatistics();

    /**
     * construct default Player
     */

    public Player() {

    }

    /**
     * construct a new Player
     *
     * @param username   assign the Player a username
     * @param password   assign the Player a password
     * @param colour     assign the Player a text colour for the games
     * @param multiplier assign the Player a score multiplier for the games
     * @param backColour assign the Player a background colour for the games
     */
    public Player(String username, String password, String colour, String multiplier,
                  String backColour) {
        custom = new PlayerCustomizations(username, password, colour, multiplier, backColour);
    }

    /**
     * construct a new Player that was created before (login)
     *
     * @param username   assign the Player a username
     * @param password   assign the Player a password
     * @param colour     assign the Player a text colour for the games
     * @param multiplier assign the Player a score multiplier for the games
     * @param backColour assign the Player a background colour for the games
     * @param gameNum    assign the Player the game number they are playing through
     * @param points     assign the Player the number of points they have earned so far
     * @param time       assign the Player the total time they have taken for games they've played
     */
    public Player(String username, String password, int colour, int multiplier,
                  int backColour, int gameNum, int points, double time) {
        custom = new PlayerCustomizations(username, password, colour, multiplier, backColour);
        stats = new PlayerStatistics(gameNum, points, time);
    }

    /**
     * get the player's username
     *
     * @return name
     */
    String getName() {
        return custom.getName();
    }

    /**
     * get the player's password
     *
     * @return password
     */
    String getPassword() {
        return custom.getPassword();
    }

    /**
     * get the player's points
     *
     * @return points
     */
    public int getPoints() {
        return stats.getPoints();
    }

    /**
     * get the player's text colour
     *
     * @return colour
     */
    public int getColour() {
        return custom.getColour();
    }

    /**
     * get the player's score multiplier
     *
     * @return multiplier
     */
    public int getMultiplier() {
        return custom.getMultiplier();
    }

    /**
     * get the player's background colour
     *
     * @return backColour
     */
    public int getbackColour() {
        return custom.getbackColour();
    }

    /**
     * get the player's game number (that they are on)
     *
     * @return gameNum
     */
    int getGameNum() {
        return stats.getGameNum();
    }

    /**
     * get the player's time for a specific game
     *
     * @param gameNum
     * @return time.get(gameNum - 1)
     */
    public double getTime(int gameNum) {
        return stats.getTime(gameNum);
    }

    /**
     * get the time list size
     *
     * @return time.size()
     */
    public double getTime() {
        return stats.getTime();
    }

    /**
     * remove Player's most recent game time
     */
    public void subtractTime() {
        stats.subtractTime();
    }

    /**
     * get the player's total time
     *
     * @return sum
     */
    float getTotalTime() {
        return stats.getTotalTime();
    }

    /**
     * set the player's username
     *
     * @param newName
     */
    public void setName(String newName) {
        custom.setName(newName);
    }

    /**
     * set the player's password
     *
     * @param newPassword
     */
    public void setPassword(String newPassword) {
        custom.setPassword(newPassword);
    }

    /**
     * add points to the Player's points (increment)
     */
    public void addPoints() {
        stats.addPoints(custom.getMultiplier());
    }

    /**
     * add points to the Player's points
     *
     * @param newPoints
     */
    public void addPoints(int newPoints) {
        stats.addPoints(newPoints, custom.getMultiplier());
    }

    /**
     * subtract points from the Player's points  (decrement)
     */
    public void subtractPoints() {
        stats.subtractPoints(custom.getMultiplier());
    }

    /**
     * subtract points from the Player's points
     *
     * @param subPoints
     */
    public void subtractPoints(int subPoints) {
        stats.subtractPoints(subPoints, custom.getMultiplier());
    }

    /**
     * add time of a game to the Player's total time
     *
     * @param additionalTime
     */
    public void addTime(double additionalTime) {
        stats.addTime(additionalTime);
    }

    /**
     * reset game statistics after a Player finishes all 3 games
     */
    public void resetTime() {
        stats.resetTime();
    }

    /**
     * reset game statistics after a Player finishes all 3 games
     */
    public void reset() {
        stats.reset();
    }

    /**
     * increment gameNum after a player finishes a level
     */
    public void addLevel(int level) {
        stats.addLevel(level);
    }

    /**
     * String representation of the Player
     */
    public String toString() {
        return stats.toString();
    }
}
