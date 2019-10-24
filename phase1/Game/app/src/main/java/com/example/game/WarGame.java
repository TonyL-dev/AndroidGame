package com.example.game;

import java.util.ArrayList;

public class WarGame {

    Cards c;
    WarPlayer A;
    WarPlayer B;
    private int count = 0;
    private ArrayList<Card> temp = new ArrayList<>();

    public WarGame() {
        c = new Cards();
        A = new WarPlayer(c, "PersonA");
        B = new WarPlayer(c, "PersonB");
    }

    public void play() {
        System.out.println(A);
        System.out.println(B);

        int i = 0;
        while (i < A.getHand().size() && i < B.getHand().size()) {
            count = 0;

            System.out.println("A has Handsize " + A.getHand().size());
            System.out.println("B has Handsize " + B.getHand().size());

            compare(A.getHand().get(0), B.getHand().get(0));

            System.out.println("AfterRemove" + A);
            System.out.println("AfterRemove" + B);

            i = count;
        }
    }

    public void compare(Card a, Card b) {
        if (a.getDenomination() > b.getDenomination()) {
            A.addScore();
            A.getHand().add(a);
            A.getHand().add(b);
            A.removeHand(0);
            B.removeHand(0);
        } else if (a.getDenomination() < b.getDenomination()) {
            B.addScore();
            B.getHand().add(b);
            B.getHand().add(a);
            B.removeHand(0);
            A.removeHand(0);
        } else {
            compareMore();
        }
    }

    /**
     *
     */
    public void compareMore() {
        if (A.getHand().size() >= 3 && B.getHand().size() >= 3) {
            for (int i = 0; i < 3; i++) {
                temp.add(A.getHand().get(0));
                temp.add(B.getHand().get(0));
                A.removeHand(0);
                B.removeHand(0);
            }
            System.out.println(temp + "---------temp");
        } else {
            for (int i = 0; i < A.getHand().size() && i < B.getHand().size(); i++) {
                A.removeHand(0);
                B.removeHand(0);
            }
        }
        System.out.println("B4CompareMORE" + A);
        System.out.println("B4CompareMORE" + B);
        if (A.getHand().size() > 0 && B.getHand().size() > 0) {
            compare2(A.getHand().get(0), B.getHand().get(0));
        }
        System.out.println("CompareMORE" + A);
        System.out.println("CompareMORE" + B);
    }

    /**
     * @param a
     * @param b
     */
    public void compare2(Card a, Card b) {
        if (a.getDenomination() > b.getDenomination()) {
            A.addScore();
            A.getHand().addAll(temp);
            A.getHand().add(a);
            A.getHand().add(b);
            A.removeHand(0);
            B.removeHand(0);
            temp.clear();
        } else if (a.getDenomination() < b.getDenomination()) {
            B.addScore();
            B.getHand().addAll(temp);
            B.getHand().add(b);
            B.getHand().add(a);
            B.removeHand(0);
            A.removeHand(0);
            temp.clear();
        } else {
            compareMore();
        }
    }


    public String toString() {
        if (A.getHand().size() == 0 && B.getHand().size() > 0) {
            return ("A won!!! With a score of " + A.getScore() + "\nB has a score of " + B.getScore());
        } else if (B.getHand().size() == 0 && A.getHand().size() > 0) {
            return ("B won!!! With a score of " + B.getScore() + "\nA has a score of " + A.getScore());
        } else {
            return ("TIED---");
        }
    }
}
