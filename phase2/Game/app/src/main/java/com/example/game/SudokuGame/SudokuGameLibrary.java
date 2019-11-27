package com.example.game.SudokuGame;

import java.util.ArrayList;
import java.util.HashMap;

public class SudokuGameLibrary {

    public HashMap<ArrayList<Integer>, Integer> gameplaying;
    public int level;

    private static int[] lv4row9 = {0, 0, 4, 1, 9, 0, 2, 0, 0};
    private static int[] lv4row8 = {8, 0, 1, 4, 5, 6, 0, 0, 3};
    private static int[] lv4row7 = {0, 7, 0, 0, 0, 0, 0, 0, 0};
    private static int[] lv4row6 = {2, 4, 0, 8, 0, 0, 6, 9, 0};
    private static int[] lv4row5 = {0, 0, 0, 0, 0, 0, 0, 0, 4};
    private static int[] lv4row4 = {0, 0, 9, 6, 0, 4, 0, 5, 0};
    private static int[] lv4row3 = {0, 1, 6, 0, 0, 8, 0, 4, 9};
    private static int[] lv4row2 = {0, 0, 0, 9, 4, 0, 0, 0, 7};
    private static int[] lv4row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[][] lv4 = {
            lv4row1, lv4row2, lv4row3, lv4row4, lv4row5, lv4row6,
            lv4row7, lv4row8, lv4row9};


    private static int[] lv3row9 = {0, 0, 5, 8, 0, 0, 0, 4, 0};
    private static int[] lv3row8 = {8, 0, 0, 5, 0, 0, 0, 0, 2};
    private static int[] lv3row7 = {0, 0, 1, 0, 9, 4, 0, 8, 0};
    private static int[] lv3row6 = {6, 7, 0, 0, 8, 0, 0, 0, 0};
    private static int[] lv3row5 = {5, 0, 0, 3, 0, 7, 0, 0, 6};
    private static int[] lv3row4 = {0, 0, 0, 0, 6, 0, 0, 1, 5};
    private static int[] lv3row3 = {0, 9, 0, 4, 5, 0, 1, 0, 0};
    private static int[] lv3row2 = {2, 0, 0, 0, 0, 3, 0, 0, 8};
    private static int[] lv3row1 = {0, 4, 0, 0, 0, 8, 3, 0, 0};
    private static int[][] lv3 = {
            lv3row1, lv3row2, lv3row3, lv3row4, lv3row5, lv3row6, lv3row7,
            lv3row8, lv3row9};

    private static int[] lv2row9 = {4, 0, 9, 0, 2, 0, 0, 0, 0};
    private static int[] lv2row8 = {2, 0, 7, 0, 0, 0, 3, 0, 0};
    private static int[] lv2row7 = {0, 6, 0, 0, 0, 7, 0, 0, 0};
    private static int[] lv2row6 = {1, 0, 0, 2, 0, 3, 0, 7, 9};
    private static int[] lv2row5 = {0, 5, 0, 0, 0, 4, 0, 3, 0};
    private static int[] lv2row4 = {0, 8, 0, 6, 0, 0, 0, 0, 4};
    private static int[] lv2row3 = {0, 0, 0, 8, 0, 5, 0, 0, 2};
    private static int[] lv2row2 = {0, 0, 4, 7, 0, 0, 8, 0, 0};
    private static int[] lv2row1 = {3, 0, 0, 9, 0, 0, 0, 0, 0};
    private static int[][] lv2 = {
            lv2row1, lv2row2, lv2row3, lv2row4, lv2row5, lv2row6, lv2row7,
            lv2row8, lv2row9};


    private static int[] lv1row9 = {9, 0, 0, 6, 0, 0, 0, 7, 5};
    private static int[] lv1row8 = {0, 0, 3, 0, 7, 0, 0, 0, 4};
    private static int[] lv1row7 = {7, 8, 0, 0, 2, 0, 0, 0, 0};
    private static int[] lv1row6 = {0, 4, 9, 0, 0, 0, 0, 0, 0};
    private static int[] lv1row5 = {0, 6, 0, 0, 0, 2, 0, 0, 3};
    private static int[] lv1row4 = {0, 0, 0, 0, 1, 8, 9, 5, 0};
    private static int[] lv1row3 = {0, 0, 0, 0, 0, 3, 0, 0, 0};
    private static int[] lv1row2 = {0, 0, 0, 0, 4, 0, 2, 0, 0};
    private static int[] lv1row1 = {1, 2, 6, 0, 8, 0, 0, 0, 0};

    private static int[][] lv1 = {
            lv1row1, lv1row2, lv1row3, lv1row4, lv1row5, lv1row6, lv1row7,
            lv1row8, lv1row9};


    public SudokuGameLibrary(int level) {
        if (level == 4) {
            gameplaying = toHM(lv4);
        } else if (level == 3) {
            gameplaying = toHM(lv3);
        } else if (level == 2) {
            gameplaying = toHM(lv2);
        } else {
            gameplaying = toHM(lv1);
        }
    }


    static HashMap<ArrayList<Integer>, Integer> toHM(int[][] s) {
        HashMap<ArrayList<Integer>, Integer> sudokuDesign = new HashMap<>();
        int y = 0;
        for (int[] i : s) {
            y = y + 1;
            int x = 0;
            for (int j : i) {
                x = x + 1;
                ArrayList<Integer> a = new ArrayList<>();
                a.add(y);
                a.add(x);
                sudokuDesign.put(a, j);
            }
        }

        return sudokuDesign;
    }

}
