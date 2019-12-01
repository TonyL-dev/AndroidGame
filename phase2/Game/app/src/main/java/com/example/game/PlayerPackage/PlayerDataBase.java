package com.example.game.PlayerPackage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * A database that saves player information for future usage and logins.
 * <p>
 * Learned how to use SharedPreferences from
 * https://developer.android.com/reference/android/content/SharedPreferences
 * https://developer.android.com/reference/android/content/Context.html#getSharedPreferences
 * https://developer.android.com/reference/android/content/SharedPreferences.Editor
 */
public class PlayerDataBase {

    private static final String name = "playerDetails";

    private SharedPreferences playerLocalDatabase;

    /**
     * construct default PlayerDataBase
     */
    public PlayerDataBase(Context context) {
        playerLocalDatabase = context.getSharedPreferences(name, 0);
    }

    /**
     * stores the Player data in SharedPreferences
     *
     * @param player player object whose data will be stored
     */
    public void storePlayerData(Player player) {

        String key_username = player.getName();
        String key_password = key_username + " password";
        String key_points = key_username + " points";
        String key_multiplier = key_username + " multiplier";
        String key_colour = key_username + " colour";
        String key_backColour = key_username + " backColour";
        String key_gameNum = key_username + " gameNum";
        String key_time = key_username + " time";


        SharedPreferences.Editor playerLocalDatabaseEditor = playerLocalDatabase.edit();
        playerLocalDatabaseEditor.putString(key_username, player.getName());
        playerLocalDatabaseEditor.putInt(key_points, player.getPoints());
        playerLocalDatabaseEditor.putString(key_password, player.getPassword());
        playerLocalDatabaseEditor.putInt(key_multiplier, player.getMultiplier());
        playerLocalDatabaseEditor.putInt(key_colour, player.getColour());
        playerLocalDatabaseEditor.putInt(key_backColour, player.getBackColour());
        playerLocalDatabaseEditor.putInt(key_gameNum, player.getGameNum());
        playerLocalDatabaseEditor.putFloat(key_time, player.getTotalTime());
        playerLocalDatabaseEditor.commit();
    }

    /**
     * verifies if someone logging in is a previous Player or not
     *
     * @param prevUser username that the user enters
     * @return playerInfo data found in the SharedPreferences based on the parameters
     */
    String[] verify(String prevUser) {
        String[] playerInfo = new String[2];

        String key_username = prevUser;
        String key_password = key_username + " password";

        String username = playerLocalDatabase.getString(key_username, "");
        String password = playerLocalDatabase.getString(key_password, "");

        playerInfo[0] = username;
        playerInfo[1] = password;
        return playerInfo;
    }

    /**
     * creates and returns a Player with all the previous details and statistics when the
     * Player logged out initially
     *
     * @param prevUser username the user enters
     * @return player returns new player that is creates from stored data
     */
    Player getPlayer(String prevUser) {

        String key_username = prevUser;
        String key_password = key_username + " password";
        String key_points = key_username + " points";
        String key_multiplier = key_username + " multiplier";
        String key_colour = key_username + " colour";
        String key_backColour = key_username + " backColour";
        String key_gameNum = key_username + " gameNum";
        String key_time = key_username + " time";

        String username = playerLocalDatabase.getString(key_username, "");
        String password = playerLocalDatabase.getString(key_password, "");
        int multiplier = playerLocalDatabase.getInt(key_multiplier, -1);
        int colour = playerLocalDatabase.getInt(key_colour, -1);
        int backColour = playerLocalDatabase.getInt(key_backColour, -1);
        int gameNum = playerLocalDatabase.getInt(key_gameNum, -1);
        int points = playerLocalDatabase.getInt(key_points, -1);
        double time = playerLocalDatabase.getFloat(key_time, -1);

        Player player = new Player(username, password, colour, multiplier, backColour,
                gameNum, points, time);
        return player;
    }
}

