package com.example.game;

import java.util.Arrays;

public class WarGame {

  Cards c;
  Person A;
  Person B;
  private int count = 0;

  public WarGame() {
    c = new Cards();
    A = new Person(c);
    B = new Person(c);
  }

  public void play() {
    System.out.println(Arrays.toString(A.getHand()));
    System.out.println(Arrays.toString(B.getHand()));
    for (int i = 0; i < A.getHand().length; ) {
      compare(A.getHand()[i], B.getHand()[i]);
      i = count;
    }
  }

  public void compare(int a, int b) {
    if (a > b) {
      A.addScore();
      count++;
    } else if (a < b) {
      B.addScore();
      count++;
    } else {
      count += 3;
    }
  }

  public String toString() {
    if (A.getScore() > B.getScore()) {
      return ("A won!!! With a score of " + A.getScore());
    } else if (A.getScore() < B.getScore()) {
      return ("B won!!! With a score of " + B.getScore());
    } else {
      return ("TIED---");
    }
  }

  public int getCount() {
    return count;
  }
}
