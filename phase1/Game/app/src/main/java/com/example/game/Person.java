package com.example.game;

public class Person {

  private int[] hand;
  private Cards now;
  private int Score = 0;

  public Person(Cards cards) {
    now = cards;
    hand = new int[now.getCards().length / 2];
    addCards();
  }

  public void addCards() {
    if (now.getCards()[0] != 0) {
      for (int i = 0; i < hand.length; i++) {
        hand[i] = now.getCards()[i];
        now.getCards()[i] = 0;
      }
    } else
      for (int i = 0; i < hand.length; i++) {
        hand[i] = now.getCards()[i + 26];
        now.getCards()[i + 26] = 0;
      }
  }

  public int[] getHand() {
    return hand;
  }

  public void addScore() {
    Score += 1;
  }

  public int getScore() {
    return Score;
  }
}
