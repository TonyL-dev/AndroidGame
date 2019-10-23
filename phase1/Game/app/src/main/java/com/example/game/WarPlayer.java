package com.example.game;

import java.util.ArrayList;

//A War game player
public class WarPlayer extends Player {

  private ArrayList<Integer> hand;
  private Cards deckOfCards;
  private int score = 0;
  private String Name;

  public WarPlayer(Cards cards, String name) {
    super();
    Name = name;
    deckOfCards = cards;
    hand = new ArrayList<>();
    addCards();
  }

  public void addCards() {
    if (deckOfCards.getCards()[0] != 0) {
      for (int i = 0; i < deckOfCards.getCards().length / 2; i++) {
        hand.add(deckOfCards.getCards()[i]);
        deckOfCards.getCards()[i] = 0;
      }
    } else
      for (int i = 0; i < deckOfCards.getCards().length / 2; i++) {
        hand.add(deckOfCards.getCards()[i + deckOfCards.getCards().length / 2]);
        deckOfCards.getCards()[i + deckOfCards.getCards().length / 2] = 0;
      }
  }

  public ArrayList<Integer> getHand() {
    return hand;
  }

  public ArrayList<Integer> removeHand(int i) {
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
