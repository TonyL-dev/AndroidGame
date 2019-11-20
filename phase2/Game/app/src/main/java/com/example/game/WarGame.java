package com.example.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * WarGame class
 */
public class WarGame {

    private WarPlayer playerA;
    private WarPlayer playerB;
    private Card[] lastCards = new Card[2];
    private Player newPlayer;

    /**
     * construct Wargame with deck and player
     *
     * @param newPlayer who is playing Wargame
     */

    //hahsdhashdhisahidashhdas
    WarGame(Player newPlayer) {
        Deck deckOfCards = new Deck();
        playerA = new WarPlayer(deckOfCards);
        playerB = new WarPlayer(deckOfCards);
        this.newPlayer = newPlayer;
    }

    /**
     * how many cards playerA have left
     *
     * @return playerA's hand size
     */
    int getCardsRemainingA() {
        return playerA.getHand().size();
    }

    /**
     * how many cards playerB have left
     *
     * @return playerB's hand size
     */
    int getCardsRemainingB() {
        return playerB.getHand().size();
    }

    /**
     * checks if the game is over
     *
     * @return True if either player's hand is 0
     */
    Boolean checkEndGame() {
        return playerA.getHand().size() == 0 || playerB.getHand().size() == 0;
    }

    /**
     * Record the last card of playerA and playerB
     *
     * @param playerA playerA's last card
     * @param playerB playerB's last card
     */
    private void setLastCardsPlayed(Card playerA, Card playerB) {
        lastCards[0] = playerA;
        lastCards[1] = playerB;
    }

    /**
     * @return lastCards
     */
    Card[] getLastCardsPlayed() {
        return lastCards;
    }

    /**
     * get playerA
     *
     * @return playerA
     */
    WarPlayer getPlayerA() {
        return playerA;
    }

    /**
     * play out a single round of the game
     */
    void play() {

        ArrayList<Card> cardsInMiddle = new ArrayList<>();
        Card cardA = playerA.getNextCard();
        Card cardB = playerB.getNextCard();

        cardsInMiddle.add(cardA);
        cardsInMiddle.add(cardB);

        //if there's a tie
        while (cardA.getDenomination() == cardB.getDenomination()) {
            //check to see if players have enough cards to continue
            //if not, give all of their cards to the other player
            if (playerA.getHand().size() < 3) {
                cardsInMiddle.addAll(playerA.getHand());
                playerA.getHand().clear();
                playerB.addCards(cardsInMiddle);
                return;
            } else if (playerB.getHand().size() < 3) {
                cardsInMiddle.addAll(playerB.getHand());
                playerB.getHand().clear();
                playerA.addCards(cardsInMiddle);
                return;
            }

            //add 2 cards directly to the pile
            cardsInMiddle.add(playerA.getNextCard());
            cardsInMiddle.add(playerA.getNextCard());
            cardsInMiddle.add(playerB.getNextCard());
            cardsInMiddle.add(playerB.getNextCard());

            cardA = playerA.getNextCard();
            cardB = playerB.getNextCard();

            cardsInMiddle.add(cardA);
            cardsInMiddle.add(cardB);
        }
        setLastCardsPlayed(cardA, cardB);

        if (cardA.getDenomination() > cardB.getDenomination()) {
            playerA.addCards(cardsInMiddle);
            playerA.addScore(cardsInMiddle.size() / 2);
        } else {
            playerB.addCards(cardsInMiddle);
            playerB.addScore(cardsInMiddle.size() / 2);
        }
    }

    /**
     * Prints out who won the War Game and adds points to the Player
     *
     * @return String result of the game
     */
    @Override
    public String toString() {
        newPlayer.addPoints(playerA.getScore());
        if (playerA.getScore() < playerB.getScore()) {
            return ("Player B won!!! With a score of " + playerB.getScore() *
                    newPlayer.getMultiplier() + "\nYou have a score of " + playerA.getScore()
                    * newPlayer.getMultiplier());
        } else if (playerA.getScore() > playerB.getScore()) {
            return ("You won!!! With a score of " + playerA.getScore() * newPlayer.getMultiplier()
                    + "\nPlayer B has a score of " + playerB.getScore() * newPlayer.getMultiplier());
        } else {
            return ("TIED---");
        }
    }
}
