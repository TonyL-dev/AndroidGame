package com.example.game;

enum Suit {
    Clubs,
    Diamonds,
    Spades,
    Hearts
}

public class Card {

    private int denomination;
    private Suit suit;
    private String cardText;

    Card(Suit suit, int denomination, String cardText) {
        this.suit = suit;
        this.denomination = denomination;
        this.cardText = cardText;
    }

    int getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return cardText;
    }
}
