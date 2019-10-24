package com.example.game;

public class Card {

    private int denomination;
    private int suit;

    Card(int suit, int denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    int getDenomination() {
        return denomination;
    }

    public int getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String suitAsString;
        switch (suit) {
            case 1:
                suitAsString = "Spade";
                break;
            case 2:
                suitAsString = "Heart";
                break;
            case 3:
                suitAsString = "Club";
                break;
            case 4:
                suitAsString = "Diamond";
                break;
            default:
                suitAsString = "Empty";
        }
        return (denomination + " of " + suitAsString);
    }
}
