package com.example.game;

import java.util.ArrayList;

//A War game player
class WarPlayer extends Player {

    private ArrayList<Card> hand;
    private int score = 0;

    WarPlayer(Deck cards) {
        super();

        hand = new ArrayList<>();
        addCards(cards);
        System.out.println(this.getName() + "---" + hand);
    }

    private void addCards(Deck deckOfCards) {
        //give half the deck to player
        for (int i = 0; i < 26; i++) {
            hand.add(deckOfCards.getNextCard());
        }
    }

    void addCards(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    //make immutable in the future?
    ArrayList<Card> getHand() {
        return hand;
    }

    Card getNextCard() {
        return hand.remove(0);
    }

    void addScore(int size) {
        score += size;
    }

    int getScore() {
        return score;
    }

}
