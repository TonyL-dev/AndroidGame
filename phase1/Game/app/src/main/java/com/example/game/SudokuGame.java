package com.example.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class SudokuGame {

  //Hashmap for locating and changing the numbers on gameboard.
  HashMap<ArrayList<Integer>, Integer> sudoku;
  private Player newPlayer;
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle1 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle2 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle3 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle4 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle5 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle6 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle7 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle8 = new ArrayList<ArrayList<Integer>>();
  private ArrayList<ArrayList<Integer>> ThreeByThreeBundle9 = new ArrayList<ArrayList<Integer>>();
  ArrayList<ArrayList<ArrayList<Integer>>> sudokuDimension =
      new ArrayList<ArrayList<ArrayList<Integer>>>(
          Arrays.asList(
              ThreeByThreeBundle1,
              ThreeByThreeBundle2,
              ThreeByThreeBundle3,
              ThreeByThreeBundle4,
              ThreeByThreeBundle5,
              ThreeByThreeBundle6,
              ThreeByThreeBundle7,
              ThreeByThreeBundle8,
              ThreeByThreeBundle9));

  SudokuGame(Player player, HashMap<ArrayList<Integer>, Integer> sudoku) {
    this.newPlayer = player;
    this.sudoku = sudoku;
  }


    /**
     * the 9 methods below bounds the adjacent 3x3 tiles together for checking.
     * @return bundles of tiles
     */
  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle1() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle2() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 4; i < 7; i++) {
      for (int j = 1; j < 4; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle3() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 7; i < 10; i++) {
      for (int j = 1; j < 4; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle4() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 1; i < 4; i++) {
      for (int j = 4; j < 7; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle5() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 4; i < 7; i++) {
      for (int j = 4; j < 7; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle6() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 7; i < 10; i++) {
      for (int j = 4; j < 7; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle7() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 1; i < 4; i++) {
      for (int j = 7; j < 10; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle8() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 4; i < 7; i++) {
      for (int j = 7; j < 10; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

  private ArrayList<ArrayList<Integer>> getThreeByThreeBundle9() {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 7; i < 10; i++) {
      for (int j = 7; j < 10; j++) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        ans.add(a);
      }
    }
    return ans;
  }

    /**
     *get the game board in a arraylist of arraylist of int type.
     */

  private ArrayList<ArrayList<ArrayList<Integer>>> getSudokuDimension() {
    ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<ArrayList<ArrayList<Integer>>>();
    ans.add(getThreeByThreeBundle1());
    ans.add(getThreeByThreeBundle2());
    ans.add(getThreeByThreeBundle3());
    ans.add(getThreeByThreeBundle4());
    ans.add(getThreeByThreeBundle5());
    ans.add(getThreeByThreeBundle6());
    ans.add(getThreeByThreeBundle7());
    ans.add(getThreeByThreeBundle8());
    ans.add(getThreeByThreeBundle9());
    return ans;
  }

//  check whether there is a conflict in the 3x3 board with the user input.
  private boolean checkThreeByThree(
      int Input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
    ArrayList<Integer> key = new ArrayList<>();
    key.add(x);
    key.add(y);
    ArrayList<ArrayList<ArrayList<Integer>>> dim = new ArrayList<>();
    dim = getSudokuDimension();

    for (ArrayList<ArrayList<Integer>> bundle : dim){
      if (bundle.contains(key)){
        for (ArrayList<Integer> k : bundle){
          if ((s.get(k) == Input) && (k != key)){
            return false;
          }
        }
      }
    }
    return true;
  }






  //check whether there is a conflict in the column with the user input.
  private boolean checkCol(int Input, int x, int y,HashMap<ArrayList<Integer>, Integer> s) {
    ArrayList<Integer> key = new ArrayList<>();
    key.add(x);
    key.add(y);
    for (ArrayList<Integer> position : s.keySet()) {
      if (position.get(0) == x && Input == s.get(position) && key != position) {
          return false;
        }
      }
    return true;
  }

  //check whether there is a conflict in the row with the user input.
  private boolean checkRow(int Input,int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
    ArrayList<Integer> key = new ArrayList<>();
    key.add(x);
    key.add(y);
    for (ArrayList<Integer> position : s.keySet()) {
      if (position.get(1) == y && position != key) {
        if (Input == (s.get(position))) {
          return false;
        }
      }
    }
    return true;
  }

    /**
     * check whether the number entered is in range of 1 to 9.
     */
  boolean isInRange(int input){
    return (1 <= input && input <= 9);
  }

    /**
     * if there is no conflicts, add the number entered by the user into the game board.
     */

  boolean insert(int Input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
    ArrayList<Integer> key = new ArrayList<Integer>();
    key.add(x);
    key.add(y);

    boolean rowCorrect = checkRow(Input, x, y, s);
    boolean colCorrect = checkCol(Input, x, y, s);
    boolean tbtCorrect = checkThreeByThree(Input, x, y, s);
    boolean inrange = isInRange(Input);

    if (rowCorrect && colCorrect && tbtCorrect && inrange) {
      s.put(key, Input);

      return true;
    } else {
      return false;
    }
    }
}
