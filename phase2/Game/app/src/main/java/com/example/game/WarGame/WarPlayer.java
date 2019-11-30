package com.example.game.WarGame;

import com.example.game.PlayerPackage.GeneralPlayer;

import java.util.ArrayList;

/**
 * A War game player
 */
public class WarPlayer implements GeneralPlayer {

    /**
     * the hard of the player
     */
    private ArrayList<Card> hand;

    /**
     * the player's score
     */
    private int score = 0;

    /**
     * The Player's username
     */
    private String name;

    /**
     * The Player's password
     */
    private String password;

    /**
     * construct WarPlayer
     */
    WarPlayer() {
        this.name = "Default";
        this.password = "1234";

        hand = new ArrayList<>();
    }

    /**
     * Receive a card to put in their deck
     *
     * @param card the card being received
     */
    void receiveCard(Card card) {
        hand.add(card);
    }

    /**
     * Give the player half of the game deck
     *
     * @param deckOfCards GameDeck
     */
    private void addCards(Deck deckOfCards) {
        //give half the deck to player
        for (int i = 0; i < 26; i++) {
            hand.add(deckOfCards.getNextCard());
        }
    }

    /**
     * add a list of cards being dealt to hand
     *
     * @param cards a list of cards being dealt
     */
    void addCards(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    //make immutable in the future?

    /**
     * get the player's card
     *
     * @return hand
     */
    ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * get the player's next card in hand
     *
     * @return top card of the player's hand
     */
    Card getNextCard() {
        return hand.remove(0);
    }

    /**
     * add score to the player
     *
     * @param size number
     */
    @Override
    public void addPoints(int size) {
        score += size;
    }

    /**
     * get score of the player
     *
     * @return score
     */
    @Override
    public int getPoints() {
        return score;
    }

}
