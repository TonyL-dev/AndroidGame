package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;

public class PlayerDataBase {

    public static final String name = "playerDetails";

    public SharedPreferences playerLocalDatabase;

    public PlayerDataBase(Context context) {
        playerLocalDatabase = context.getSharedPreferences(name, 0);
    }

        public void storePlayerData(Player player) {
            SharedPreferences.Editor userLocalDatabaseEditor = playerLocalDatabase.edit();
            userLocalDatabaseEditor.putString("username", player.getName());
            userLocalDatabaseEditor.putInt("points", player.getPoints());
            userLocalDatabaseEditor.putString("password", player.getPassword());
            userLocalDatabaseEditor.putInt("multiplier", player.getMultiplier());
            userLocalDatabaseEditor.putInt("colour", player.getColour());
            userLocalDatabaseEditor.putInt("backColour", player.getbackColour());
            userLocalDatabaseEditor.putInt("gameNum", player.getGameNum());
            userLocalDatabaseEditor.putFloat("time", player.getTotalTime());
            userLocalDatabaseEditor.commit();
        }

        public void clearUserData() {
            SharedPreferences.Editor userLocalDatabaseEditor = playerLocalDatabase.edit();
            userLocalDatabaseEditor.clear();
            userLocalDatabaseEditor.commit();
        }

        public String [] verify() {

        String [] playerInfo = new String[2];
        String username = playerLocalDatabase.getString("username", "");
        String password = playerLocalDatabase.getString("password", "");

        playerInfo[0]=username;
        playerInfo[1]=password;
        return playerInfo;
        }

        public Player getPlayer() {

            String username = playerLocalDatabase.getString("username", "");
            String password = playerLocalDatabase.getString("password", "");
            int multiplier = playerLocalDatabase.getInt("multiplier", -1);
            int colour = playerLocalDatabase.getInt("colour", -1);
            int backColour = playerLocalDatabase.getInt("backColour", -1);
            int gameNum = playerLocalDatabase.getInt("gameNum", -1);
            int points = playerLocalDatabase.getInt("points", -1);
            double time = playerLocalDatabase.getFloat("time", -1);

            Player player = new Player(username, password, colour, multiplier, backColour,
                    gameNum, points, time);
            return player;
        }
    }

