package com.example.game;

public class Card {

    private int denomination;
    private int suit;

    public Card(int a, int b) {
        suit = a;
        denomination = b;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getSuit() {
        return suit;
    }

    public String toString() {
        String x;
        switch (suit) {
            case 1:
                x = "Spade";
                break;
            case 2:
                x = "Heart";
                break;
            case 3:
                x = "Club";
                break;
            case 4:
                x = "Diamond";
                break;
            default:
                x = "Empty";
        }
        return (denomination + " of " + x);
    }
}
