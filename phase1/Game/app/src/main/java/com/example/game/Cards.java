package com.example.game;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {

    private ArrayList<Card> deck = new ArrayList<>();

    public Cards() {
        init();
        shuffle();
    }

    private void init() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getCards() {
        return deck;
    }
}
