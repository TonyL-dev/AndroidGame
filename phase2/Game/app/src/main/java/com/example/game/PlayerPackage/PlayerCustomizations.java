package com.example.game.PlayerPackage;

import java.io.Serializable;

public class PlayerCustomizations implements Serializable {

    /**
     * The Player's username
     */
    private String name;

    /**
     * The Player's password
     */
    private String password;

    /**
     * The Player's text colour
     */
    private int colour = 0;

    /**
     * The Player's score multiplier
     */
    private int multiplier = 1;

    /**
     * The Player's background colour
     */
    private int backColour = 0;

    public PlayerCustomizations(String username, String password, String colour, String multiplier,
                                String backColour){

        this.name = username;
        this.password = password;

        if (multiplier.equals(""))
            this.multiplier = 1;
        else if (Integer.parseInt(multiplier) <= 0)
            this.multiplier = 1;
        else
            this.multiplier = Integer.parseInt(multiplier);

        if (backColour.equalsIgnoreCase("blue"))
            this.backColour = 0xFF0C3688;
        else if (backColour.equalsIgnoreCase("purple"))
            this.backColour = 0xAA9900FF;
        else
            this.backColour = 0;

        if (colour.equalsIgnoreCase("green"))
            this.colour = 0xFF00FF00;
        else if (colour.equalsIgnoreCase("orange"))
            this.colour = 0xAAFF8000;
        else
            this.colour = 0;
    }

    /**
     * construct a new Player that was created before (login)
     *
     * @param username   assign the Player a username
     * @param password   assign the Player a password
     * @param colour     assign the Player a text colour for the games
     * @param multiplier assign the Player a score multiplier for the games
     * @param backColour assign the Player a background colour for the games
     */
    public PlayerCustomizations(String username, String password, int colour, int multiplier,
                  int backColour) {

        this.name = username;
        this.password = password;
        this.multiplier = multiplier;
        this.colour = colour;
        this.backColour = backColour;
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
}
