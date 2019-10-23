package com.example.game;

import java.util.ArrayList;

public class WarGame {

  Cards c;
  Person A;
  Person B;
  private int count = 0;
  private ArrayList<Integer> temp = new ArrayList<>();

  public WarGame() {
    c = new Cards();
    A = new Person(c, "PersonA");
    B = new Person(c, "PersonB");
  }

  public void play() {
    System.out.println(A);
    System.out.println(B);

    int i = 0;
    while (i < A.getHand().size() && i < B.getHand().size()) {
      count = 0;

      System.out.println(A.getHand().size() + "Asize");
      System.out.println(B.getHand().size() + "Bsize");

      compare(A.getHand().get(0), B.getHand().get(0));

      System.out.println("AfterRemove" + A);
      System.out.println("AfterRemove" + B);

      i = count;
    }
  }

  public void compare(int a, int b) {
    if (a > b) {
      A.addScore();
      A.getHand().add(a);
      A.getHand().add(b);
      A.removeHand(0);
      B.removeHand(0);
    } else if (a < b) {
      B.addScore();
      B.getHand().add(b);
      B.getHand().add(a);
      B.removeHand(0);
      A.removeHand(0);
    } else {
      compareMore();
    }
  }

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
    compare2(A.getHand().get(0), B.getHand().get(0));
    System.out.println("CompareMORE" + A);
    System.out.println("CompareMORE" + B);
  }

  public void compare2(int a, int b) {
    if (a > b) {
      A.addScore();
      A.getHand().addAll(temp);
      A.getHand().add(a);
      A.getHand().add(b);
      A.removeHand(0);
      B.removeHand(0);
      temp.removeAll(temp);
    } else if (a < b) {
      B.addScore();
      B.getHand().addAll(temp);
      B.getHand().add(b);
      B.getHand().add(a);
      B.removeHand(0);
      A.removeHand(0);
      temp.removeAll(temp);
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
