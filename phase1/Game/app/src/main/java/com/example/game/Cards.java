package com.example.game;

import java.util.ArrayList;
import java.util.Collections;

class Cards {

    private ArrayList<Card> deck = new ArrayList<>();

    Cards() {
        init();
        shuffle();
    }

    private void init() {
        for (int suit = 1; suit <= 4; suit++) {
            for (int denomination = 1; denomination <= 13; denomination++) {
                deck.add(new Card(suit, denomination));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    ArrayList<Card> getCards() {
        return deck;
    }
}
