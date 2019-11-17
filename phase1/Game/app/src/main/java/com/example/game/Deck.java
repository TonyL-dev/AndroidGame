package com.example.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class which consists 52 Cards
 */
class Deck {

    private List<Card> deck;

    /**
     * Construct the Deck
     */
    Deck() {
        deck = this.createCards();
    }

    /**
     * Add 52 cards to the Deck
     *
     * @return a list of Cards
     */
    private List<Card> createCards() {
        for (int denomination = 2; denomination <= 14; denomination++) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(suit, denomination, abbreviationName(denomination)));
            }
        }
        shuffle();
        return deck;
    }

    /**
     * Shuffles the Deck
     */
    private void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * An abbreviation for the card
     *
     * @param denomination denomination of the card
     * @return String format of the denomination
     */
    private String abbreviationName(int denomination) {
        String value;
        if (denomination >= 2 && denomination <= 10)
            value = String.valueOf(denomination);
        else if (denomination == 11)
            value = "J";
        else if (denomination == 12)
            value = "Q";
        else if (denomination == 13)
            value = "K";
        else if (denomination == 14)
            value = "A";
        else
            value = "NONE";
        //the value and the first letter of the suit
        return value;
    }

    public int numOfCards(){
        return deck.size();
    }

    /**
     * Get the next card in the deck
     *
     * @return the top card in the deck
     */
    Card getNextCard() {
        return deck.remove(0);
    }
}
