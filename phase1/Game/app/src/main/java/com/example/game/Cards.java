package com.example.game;

import java.util.Random;

public class Cards {

  private int cards[] = new int[52];

  public Cards() {
    init();
    shuffle();
  }

  public void init() {
    for (int i = 1; i <= cards.length; i++) {
      cards[i - 1] = (i % 13 != 0) ? i % 13 : 13;
    }
  }

  public void shuffle() {
    int n = cards.length;
    Random random = new Random();
    random.nextInt();
    for (int i = 0; i < n; i++) {
      int change = i + random.nextInt(n - i);
      swap(cards, i, change);
    }
  }

  private static void swap(int[] a, int i, int change) {
    int helper = a[i];
    a[i] = a[change];
    a[change] = helper;
  }

  public int[] getCards() {
    return cards;
  }
}
