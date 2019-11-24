package com.example.game.WarGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class which consists 52 Cards
 */
class Deck {

    /**
     * the deck of cards
     */
    private List<Card> deck;

    /**
     * Construct the Deck
     */
    Deck() {
        deck = new ArrayList<>();
        deck = this.createCards();
    }

    /**
     * Add 52 cards to the Deck and then shuffle them
     *
     * @return a list of shuffled Cards
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

    /**
     * Return the number of cards in the deck
     * @return number of cards in the deck
     */
    int numOfCards(){
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
