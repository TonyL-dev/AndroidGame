package com.example.game.WarGame;

/**
 * The Card class with methods accessing its value
 */
public class Card {

    /**
     * the denomination of the card
     */
    private int denomination;

    /**
     * the suit of the card
     */
    private Suit suit;

    /**
     * the shorthand version of the card name
     */
    private String cardText;

    /**
     * construct Card with suit, denomination and cardText
     *
     * @param suit         card suit
     * @param denomination card denomination
     * @param cardText     the shortened text version of the card
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
