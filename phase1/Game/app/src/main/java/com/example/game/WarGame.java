package com.example.game;

import java.util.ArrayList;

public class WarGame {

    private WarPlayer playerA;
    private WarPlayer playerB;
    private ArrayList<Card> temp = new ArrayList<>();

    WarGame() {
        Cards deckOfCards = new Cards();
        playerA = new WarPlayer(deckOfCards, "PersonA");
        playerB = new WarPlayer(deckOfCards, "PersonB");
    }

    void play() {
        System.out.println(playerA);
        System.out.println(playerB);

        int i = 0;
        while (i < playerA.getHand().size() && i < playerB.getHand().size()) {
            System.out.println("PlayerA has Handsize " + playerA.getHand().size());
            System.out.println("PlayerB has Handsize " + playerB.getHand().size());

            compare(playerA.getHand().get(0), playerB.getHand().get(0));

            System.out.println("AfterRemove" + playerA);
            System.out.println("AfterRemove" + playerB);
        }
    }

    private void compare(Card playerACard, Card playerBCard) {
        if (playerACard.getDenomination() > playerBCard.getDenomination()) {
            playerA.addScore();
            playerA.getHand().add(playerACard);
            playerA.getHand().add(playerBCard);
            playerA.removeHand(0);
            playerB.removeHand(0);
        } else if (playerACard.getDenomination() < playerBCard.getDenomination()) {
            playerB.addScore();
            playerB.getHand().add(playerBCard);
            playerB.getHand().add(playerACard);
            playerB.removeHand(0);
            playerA.removeHand(0);
        } else {
            compareMore();
        }
    }

    /**
     *
     */
    private void compareMore() {
        if (playerA.getHand().size() >= 3 && playerB.getHand().size() >= 3) {
            for (int i = 0; i < 3; i++) {
                temp.add(playerA.getHand().get(0));
                temp.add(playerB.getHand().get(0));
                playerA.removeHand(0);
                playerB.removeHand(0);
            }
            System.out.println(temp + "---------temp");
        } else {
            for (int i = 0; i < playerA.getHand().size() && i < playerB.getHand().size(); i++) {
                playerA.removeHand(0);
                playerB.removeHand(0);
            }
        }
        System.out.println("B4CompareMORE" + playerA);
        System.out.println("B4CompareMORE" + playerB);
        if (playerA.getHand().size() > 0 && playerB.getHand().size() > 0) {
            compare2(playerA.getHand().get(0), playerB.getHand().get(0));
        }
        System.out.println("CompareMORE" + playerA);
        System.out.println("CompareMORE" + playerB);
    }

    /**
     * @param playerACard
     * @param playerBCard
     */
    private void compare2(Card playerACard, Card playerBCard) {
        if (playerACard.getDenomination() > playerBCard.getDenomination()) {
            playerA.addScore();
            playerA.getHand().addAll(temp);
            playerA.getHand().add(playerACard);
            playerA.getHand().add(playerBCard);
            playerA.removeHand(0);
            playerB.removeHand(0);
            temp.clear();
        } else if (playerACard.getDenomination() < playerBCard.getDenomination()) {
            playerB.addScore();
            playerB.getHand().addAll(temp);
            playerB.getHand().add(playerBCard);
            playerB.getHand().add(playerACard);
            playerB.removeHand(0);
            playerA.removeHand(0);
            temp.clear();
        } else {
            compareMore();
        }
    }


    @Override
    public String toString() {
        if (playerA.getHand().size() == 0 && playerB.getHand().size() > 0) {
            return ("Player B won!!! With a score of " + playerB.getScore() + "\nPlayer A has a score of " + playerA.getScore());
        } else if (playerB.getHand().size() == 0 && playerA.getHand().size() > 0) {
            return ("Player A won!!! With a score of " + playerA.getScore() + "\nPlayer B has a score of " + playerB.getScore());
        } else {
            return ("TIED---");
        }
    }
}
