package com.example.game.WarGame;

/**
 * The Card class with methods accessing its value
 */
public class Card {

    private int denomination;
    private Suit suit;
    private String cardText;

    /**
     * construct Card with suit, denomination and cardText
     *
     * @param suit
     * @param denomination
     * @param cardText
     */
    Card(Suit suit, int denomination, String cardText) {
        this.suit = suit;
        this.denomination = denomination;
        this.cardText = cardText;
    }

    /**
     * get the Card's denomination
     *
     * @return denomination
     */
    int getDenomination() {
        return denomination;
    }

    /**
     * get the Card's suit
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Card's toString text
     *
     * @return cardText of suit
     */
    @Override
    public String toString() {
        return cardText + " of " + suit.toString();
    }
}
