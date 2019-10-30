package com.example.game;

import java.util.ArrayList;
import java.util.Collections;

class Deck {

    private void shuffle() {
        Collections.shuffle(deck);
    }

    private ArrayList<Card> deck = new ArrayList<>();

    Deck() {
        deck = this.createCards();
    }

    private ArrayList<Card> createCards() {
        for (int denomination = 2; denomination <= 14; denomination++) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(suit, denomination, abbreviationName(denomination)));
            }
        }
        shuffle();
        return deck;
    }

    //An abbreviation for the card
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

    Card getNextCard() {
        return deck.remove(0);
    }
}
