package com.example.game.SudokuGame;

import com.example.game.Player;

import java.util.ArrayList;
import java.util.HashMap;

class SudokuGame {

    // Hashmap for locating and changing the numbers on gameboard.
    HashMap<ArrayList<Integer>, Integer> sudoku;
    private Player newPlayer;

    SudokuGame(Player player, HashMap<ArrayList<Integer>, Integer> sudoku) {
        this.newPlayer = player;
        this.sudoku = sudoku;
    }


    private ArrayList<Integer> addToArray(int i, int j) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        a.add(j);
        return a;
    }

    /**
     * get the game board in a arraylist of arraylist of int type.
     */
    private ArrayList<ArrayList<ArrayList<Integer>>> getSudokuDimension() {
        ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int a = 1; a <= 9; a = a + 3) {
            for (int b = 1; b <= 9; b = b + 3) {
                ArrayList<ArrayList<Integer>> bundle = getThreeByThree(a, b);
                ans.add(bundle);
            }
        }
        System.out.println(ans);

        return ans;
    }


    private ArrayList<ArrayList<Integer>> getThreeByThree(int a, int b){
        ArrayList<ArrayList<Integer>> tbyt = new ArrayList<>();
        for (int i = a; i <= a + 2; i++) {
            for (int j = b; j <= b + 2; j++) {
                ArrayList<Integer> bundle = new ArrayList<>();
                bundle.add(i);
                bundle.add(j);
                tbyt.add(bundle);
            }
        }
        return tbyt;
    }


    //  check whether there is a conflict in the 3x3 board with the user input.
    private boolean checkThreeByThree(
            int Input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
        ArrayList<Integer> key = new ArrayList<>();
        key.add(x);
        key.add(y);
        ArrayList<ArrayList<ArrayList<Integer>>> dim = new ArrayList<>();
        dim = getSudokuDimension();

        for (ArrayList<ArrayList<Integer>> bundle : dim) {
            if (bundle.contains(key)) {
                for (ArrayList<Integer> k : bundle) {
                    if ((s.get(k) == Input) && (k != key)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // check whether there is a conflict in the column with the user input.
    private boolean checkCol(int Input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
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

    // check whether there is a conflict in the row with the user input.
    private boolean checkRow(int Input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
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
    boolean isInRange(int input) {
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
        }
        else {
            return false;
        }
    }
}
