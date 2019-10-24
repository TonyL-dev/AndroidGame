package com.example.game;

import java.util.ArrayList;

//A War game player
public class WarPlayer extends Player {

    private ArrayList<Card> hand;
    private Cards deckOfCards;
    private int score = 0;
    private String Name;

    public WarPlayer(Cards cards, String name) {
        super();
        Name = name;
        deckOfCards = cards;
        hand = new ArrayList<>();
        addCards();
        System.out.println(Name + "---" + hand);
    }

    public void addCards() {
        for (int i = 0; i < 26; i++) {
            hand.add(deckOfCards.getCards().get(i));
        }
        for (int i = 0; i < 26; i++) {
            deckOfCards.getCards().remove(0);
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> removeHand(int i) {
        hand.remove(i);
        return hand;
    }

    public void addScore() {
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return (Name + ": " + hand);
    }
}
