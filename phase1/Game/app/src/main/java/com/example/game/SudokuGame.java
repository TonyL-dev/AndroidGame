package com.example.game;

public class SudokuGame {

    private Player newPlayer;
    SudokuGame sudokuGame;
    long startSudoku = System.nanoTime();
    int[] default9 = {0, 0, 4, 1, 9, 0, 2, 0, 0};
    int[] default8 = {8, 0, 1, 4, 5, 6, 0, 0, 3};
    int[] default7 = {0, 7, 0, 0, 0, 0, 0, 0, 0};
    int[] default6 = {2, 4, 0, 8, 0, 0, 6, 9, 0};
    int[] default5 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] default4 = {0, 0, 9, 6, 0, 4, 0, 5, 0};
    int[] default3 = {0, 1, 6, 0, 0, 8, 0, 4, 9};
    int[] default2 = {0, 0, 0, 9, 4, 0, 0, 0, 7};
    int[] default1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] initBoard = {default1, default2, default3, default4, default5, default6, default7, default8, default9};
    static int[][] board;


    public SudokuGame(Player player) {
        newPlayer = player;
    }

    public boolean check_row_availability(int a, int x, int y, int[][] gameboard) {
        //To check whether a user input is possible.
        //x is the column of the input,y is the row of the input.
        //!!!gameboard is a changing variable derived from the modifying funciotn.
        int i = 0;
        //gameboard =
        if( gameboard[y][x] != 0){
            return false;
        }
        while (i < 9) {
            if (gameboard[y ][i] == a) {
                return false;
            } else {
                i++;
            }
        }return true;
    }

    public boolean check_column_availablity(int a, int x, int y, int[][] gameboard){
        //To check whether a user input is possible.
        //x is the column of the input,y is the row of the input.
        //!!!gameboard is a changing variable derived from the modifying funciotn.

    }

    public boolean check_3x3_availability(int a, int x, int y, int[][] gameboard){
        //To check whether a user input is possible.
        //x is the column of the input,y is the row of the input.
        //!!!gameboard is a changing variable derived from the modifying funciotn.
    }
}






