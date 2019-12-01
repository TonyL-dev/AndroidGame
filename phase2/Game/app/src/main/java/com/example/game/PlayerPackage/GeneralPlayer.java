package com.example.game.PlayerPackage;

/** Interface implemented for Player and WarPlayer. Could be further developed when new types
 * of players are added in future updates to the game
 */
public interface GeneralPlayer {

     /**
      * get the player's points
      *
      * @return points
      */
     int getPoints();

     /**
      * adds to the player's total points
      *
      * @param addPoints
      */
     void addPoints(int addPoints);

}
