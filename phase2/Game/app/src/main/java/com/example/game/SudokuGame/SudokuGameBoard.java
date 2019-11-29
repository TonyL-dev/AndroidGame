package com.example.game.SudokuGame;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * the chessboard used to display the numbers.
 */
public class SudokuGameBoard extends View {

    // the determined the numbers on the board at the start of the game.
    static int[] default9 = {0, 0, 4, 1, 9, 0, 2, 0, 0};
    static int[] default8 = {8, 0, 1, 4, 5, 6, 0, 0, 3};
    static int[] default7 = {0, 7, 0, 0, 0, 0, 0, 0, 0};
    static int[] default6 = {2, 4, 0, 8, 0, 0, 6, 9, 0};
    static int[] default5 = {0, 0, 0, 0, 0, 0, 0, 0, 4};
    static int[] default4 = {0, 0, 9, 6, 0, 4, 0, 5, 0};
    static int[] default3 = {0, 1, 6, 0, 0, 8, 0, 4, 9};
    static int[] default2 = {0, 0, 0, 9, 4, 0, 0, 0, 7};
    static int[] default1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[][] sudo = {
            default1, default2, default3, default4, default5, default6, default7, default8, default9
    };
    Paint sPaint;

    public SudokuGameBoard(Context context) {
        super(context);
    }

    public SudokuGameBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sPaint = new Paint();
    }
}