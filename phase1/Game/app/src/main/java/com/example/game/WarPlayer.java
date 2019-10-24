package com.example.game;

import java.util.ArrayList;

//A War game player
public class WarPlayer extends Player {

    private ArrayList<Card> hand;
    private Cards deckOfCards;
    private int score = 0;
    private String name;

    WarPlayer(Cards cards, String name) {
        super();
        this.name = name;
        deckOfCards = cards;
        hand = new ArrayList<>();
        addCards();
        System.out.println(this.name + "---" + hand);
    }

    private void addCards() {
        for (int i = 0; i < 26; i++) {
            hand.add(deckOfCards.getCards().get(i));
        }
        deckOfCards.getCards().subList(0, 26).clear();
    }

    ArrayList<Card> getHand() {
        return hand;
    }

    ArrayList<Card> removeHand(int i) {
        hand.remove(i);
        return hand;
    }

    void addScore() {
        score += 1;
    }

    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return (this.name + ": " + hand);
    }
}
