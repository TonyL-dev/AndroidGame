package com.example.game.SudokuGame;

import com.example.game.PlayerPackage.GeneralPlayer;

import java.util.ArrayList;
import java.util.HashMap;

class SudokuGame {

    /**
     * Hashmap for locating and changing the numbers on gameboard.
     */
    HashMap<ArrayList<Integer>, Integer> sudoku;

    private GeneralPlayer newPlayer;

    SudokuGame(GeneralPlayer player, HashMap<ArrayList<Integer>, Integer> sudoku) {
        this.newPlayer = player;
        this.sudoku = sudoku;
    }


    /**
     * get the game board in a arraylist of arraylist of int type. This is for the
     * convenience of checking.
     */
    private ArrayList<ArrayList<ArrayList<Integer>>> getSudokuDimension() {
        ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int a = 1; a <= 9; a = a + 3) {
            for (int b = 1; b <= 9; b = b + 3) {
                ArrayList<ArrayList<Integer>> bundle = getThreeByThree(a, b);
                ans.add(bundle);
            }
        }
        return ans;
    }


    /**
     * bound each adjacent 9 numbers into a bundle for checking.
     * @param a
     * @param b
     * @return
     */
    private ArrayList<ArrayList<Integer>> getThreeByThree(int a, int b) {
        ArrayList<ArrayList<Integer>> threebyhree = new ArrayList<>();
        for (int i = a; i <= a + 2; i++) {
            for (int j = b; j <= b + 2; j++) {
                ArrayList<Integer> bundle = new ArrayList<>();
                bundle.add(i);
                bundle.add(j);
                threebyhree.add(bundle);
            }
        }
        return threebyhree;
    }


    /**
     * check whether there is a conflict in the 3x3 board with the user input.
     * @param Input
     * @param x
     * @param y
     * @param s
     * @return
     */
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

    /**
     *   check whether there is a conflict in the column with the user input.
     */

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

    /**
     * check whether there is a conflict in the row with the user input.
     * @param Input
     * @param x
     * @param y
     * @param s
     * @return
     */
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
     * @param input
     * @return
     */
    boolean isInRange(int input) {
        return (1 <= input && input <= 9);
    }

    /**
     * if there is no conflicts, add the number entered by the user into the game board.
     */
    boolean insert(int input, int x, int y, HashMap<ArrayList<Integer>, Integer> s) {
        ArrayList<Integer> key = new ArrayList<Integer>();
        key.add(x);
        key.add(y);

        boolean rowCorrect = checkRow(input, x, y, s);
        boolean colCorrect = checkCol(input, x, y, s);
        boolean tbtCorrect = checkThreeByThree(input, x, y, s);
        boolean inrange = isInRange(input);

        if (rowCorrect && colCorrect && tbtCorrect && inrange) {
            s.put(key, input);

            return true;
        } else {
            return false;
        }
    }
}
