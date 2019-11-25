package com.example.game.SudokuGame;

import java.util.ArrayList;
import java.util.HashMap;

public class SudokuGameLibrary {

    public HashMap<ArrayList<Integer>, Integer> gameplaying;
    public int level;

    private static int[] lv4default9 = {0, 0, 4, 1, 9, 0, 2, 0, 0};
    private static int[] lv4default8 = {8, 0, 1, 4, 5, 6, 0, 0, 3};
    private static int[] lv4default7 = {0, 7, 0, 0, 0, 0, 0, 0, 0};
    private static int[] lv4default6 = {2, 4, 0, 8, 0, 0, 6, 9, 0};
    private static int[] lv4default5 = {0, 0, 0, 0, 0, 0, 0, 0, 4};
    private static int[] lv4default4 = {0, 0, 9, 6, 0, 4, 0, 5, 0};
    private static int[] lv4default3 = {0, 1, 6, 0, 0, 8, 0, 4, 9};
    private static int[] lv4default2 = {0, 0, 0, 9, 4, 0, 0, 0, 7};
    private static int[] lv4default1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[][] lv4 = {
            lv4default1, lv4default2, lv4default3, lv4default4, lv4default5, lv4default6,
            lv4default7, lv4default8, lv4default9};

    private static int[] lv3default9 = {0,0,5,8,0,0,0,4,0};
    private static int[] lv3default8 = {8,0,0,5,0,0,0,0,2};
    private static int[] lv3default7 = {0,0,1,0,9,4,0,8,0};
    private static int[] lv3default6 = {6,7,0,0,8,0,0,0,0};
    private static int[] lv3default5 = {5,0,0,3,0,7,0,0,6};
    private static int[] lv3default4 = {0,0,0,0,6,0,0,1,5};
    private static int[] lv3default3 = {0,9,0,4,5,0,1,0,0};
    private static int[] lv3default2 = {2,0,0,0,0,3,0,0,8};
    private static int[] lv3default1 = {0,4,0,0,0,8,3,0,0};
    private static int[][] lv3 = {
            lv3default1,lv3default2,lv3default3,lv3default4,lv3default5,lv3default6,lv3default7,
            lv3default8,lv3default9};

    private static int[] lv2default9 = {4,0,9,0,2,0,0,0,0};
    private static int[] lv2default8 = {2,0,7,0,0,0,3,0,0};
    private static int[] lv2default7 = {0,6,0,0,0,7,0,0,0};
    private static int[] lv2default6 = {1,0,0,2,0,3,0,7,9};
    private static int[] lv2default5 = {0,5,0,0,0,4,0,3,0};
    private static int[] lv2default4 = {0,8,0,6,0,0,0,0,4};
    private static int[] lv2default3 = {0,0,0,8,0,5,0,0,2};
    private static int[] lv2default2 = {0,0,4,7,0,0,8,0,0};
    private static int[] lv2default1 = {3,0,0,9,0,0,0,0,0};
    private static int[][] lv2 = {
            lv2default1,lv2default2,lv2default3,lv2default4,lv2default5,lv2default6,lv2default7,
            lv2default8,lv2default9};



    public SudokuGameLibrary(int level){
        if (level == 4){
            gameplaying = toHM(lv4);
        }else if(level == 3){
            gameplaying = toHM(lv3);
        }else if(level == 2){
            gameplaying = toHM(lv2);
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
