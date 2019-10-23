package com.example.game;

import java.util.ArrayList;

public class Person {

  private ArrayList<Integer> hand;
  private Cards now;
  private int Score = 0;
  private String Name;

  public Person(Cards cards, String name) {
    Name = name;
    now = cards;
    hand = new ArrayList<>();
    addCards();
  }

  public void addCards() {
    if (now.getCards()[0] != 0) {
      for (int i = 0; i < now.getCards().length / 2; i++) {
        hand.add(now.getCards()[i]);
        now.getCards()[i] = 0;
      }
    } else
      for (int i = 0; i < now.getCards().length / 2; i++) {
        hand.add(now.getCards()[i + now.getCards().length / 2]);
        now.getCards()[i + now.getCards().length / 2] = 0;
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
    Score += 1;
  }

  public int getScore() {
    return Score;
  }

  public String toString() {
    return (Name + ": " + hand);
  }
}
