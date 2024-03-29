package com.example.game;

import java.util.ArrayList;

/**
 * A War game player
 */
class WarPlayer extends Player {

    private ArrayList<Card> hand;
    private int score = 0;

    /**
     * construct WarPlayer
     *
     */
    WarPlayer() {
        super();

        hand = new ArrayList<>();
        //addCards(cards);
        //System.out.println(this.getName() + "---" + hand);
    }

    public void receiveCard(Card card){
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
    void addScore(int size) {
        score += size;
    }

    /**
     * get score of the player
     *
     * @return score
     */
    int getScore() {
        return score;
    }

}
