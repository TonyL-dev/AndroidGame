package com.example.game;

import java.util.ArrayList;

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
    int endpoint;
    static int points;


    public SudokuGame(Player player) {
        newPlayer = player;
    }

    public boolean check_row_availability(int a, int x, int y, int[][] gameboard) {
        //To check whether a user input is possible.
        //x is the column of the input,y is the row of the input.
        //!!!gameboard is a changing variable derived from the modifying funciotn.
        //gameboard =
        if( gameboard[x-1][y-1] != 0){
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if (gameboard[x - 1 ][i] == a) {
                return false;
            }
        }return true;
    }

    public boolean check_column_availablity(int a, int x, int y, int[][] gameboard){
        //To check whether a user input is possible.
        //x is the column of the input,y is the row of the input.
        //!!!gameboard is a changing variable derived from the modifying funciotn.

        //gameboard = ^……
        for (int i = 0; i < 9; i ++){
            if (gameboard[i][y-1] == a){
                return false;
            }
        }return true;
    }

    public static int endPoint(){
        // Take a gameboard as an input,
        int num = 0;
        //calculate the number of zero in the board and add to the int endpoint.
        if (num == 0){
            points = 81;
            //81 is just a placeholder, need an algorithm to convert it to a standarised score
        }else{
            points = 2;
            //convert the number of zero to a standarized score.
        }
        return points;
    }



}






