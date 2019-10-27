package com.example.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WarGame {

    private WarPlayer playerA;
    private WarPlayer playerB;
    private Card[] lastCards = new Card[2];

    WarGame() {
        Deck deckOfCards = new Deck();
        playerA = new WarPlayer(deckOfCards, "PersonA");
        playerB = new WarPlayer(deckOfCards, "PersonB");
    }

    //how many cards you have left
    int getCardsRemainingA() {
        return playerA.getHand().size();
    }

    //how many cards playerB has left
    int getCardsRemainingB() {
        return playerB.getHand().size();
    }

    //checks if the game is over
    Boolean checkEndGame() {
        return playerA.getHand().size() == 0 || playerB.getHand().size() == 0;
    }

    private void setLastCardsPlayed(Card playerA, Card playerB) {
        lastCards[0] = playerA;
        lastCards[1] = playerB;
    }

    Card[] getLastCardsPlayed() {
        return lastCards;
    }

    //play out a single round of the game
    void play() {

        ArrayList<Card> cardsInMiddle = new ArrayList<>();
        Card cardA = playerA.getNextCard();
        Card cardB = playerB.getNextCard();

        cardsInMiddle.add(cardA);
        cardsInMiddle.add(cardB);

        //if there's a tie
        while (cardA.getDenomination() == cardB.getDenomination()) {
            //check to see if players have enough cards to continue
            //if not, give all of their cards to the other player
            if (playerA.getHand().size() < 3) {
                cardsInMiddle.addAll(playerA.getHand());
                playerA.getHand().clear();
                playerB.addCards(cardsInMiddle);
                return;
            } else if (playerB.getHand().size() < 3) {
                cardsInMiddle.addAll(playerB.getHand());
                playerB.getHand().clear();
                playerA.addCards(cardsInMiddle);
                return;
            }

            //add 2 cards directly to the pile
            cardsInMiddle.add(playerA.getNextCard());
            cardsInMiddle.add(playerA.getNextCard());
            cardsInMiddle.add(playerB.getNextCard());
            cardsInMiddle.add(playerB.getNextCard());

            cardA = playerA.getNextCard();
            cardB = playerB.getNextCard();

            cardsInMiddle.add(cardA);
            cardsInMiddle.add(cardB);
        }
        setLastCardsPlayed(cardA, cardB);

        if (cardA.getDenomination() > cardB.getDenomination()) {
            playerA.addCards(cardsInMiddle);
            playerA.addScore(cardsInMiddle.size() / 2);
        } else {
            playerB.addCards(cardsInMiddle);
            playerB.addScore(cardsInMiddle.size() / 2);
        }
    }

    @Override
    public String toString() {
        if (playerA.getScore() < playerB.getScore()) {
            return ("Player B won!!! With a score of " + playerB.getScore() + "\nYou have a score of " + playerA.getScore());
        } else if (playerA.getScore() > playerB.getScore()) {
            return ("You won!!! With a score of " + playerA.getScore() + "\nPlayer B has a score of " + playerB.getScore());
        } else {
            return ("TIED---");
        }
    }
}
