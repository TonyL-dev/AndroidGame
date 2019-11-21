package com.example.game.SudokuGame; // 复制过去的时候这个改成自己的pkg name。

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/** the chessboard used to display the numbers. */
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
  float w; // width of one tile
  float h; // height of one tile
  Paint sPaint;

  public SudokuGameBoard(Context context) {
    super(context);
  }

  public SudokuGameBoard(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
    sPaint = new Paint();
  }

  /**
   * Change the array list to Hash Map, this is for checking the invalidity of user input in the
   * game board.
   *
   * @param s
   * @return a hashmap containing the [row,column] as a key, the number on that tile as a value.
   */
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

  /**
   * measure the height and width of the board.
   *
   * @param widthMeasureSpec
   * @param heightMeasureSpec
   */
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    w = MeasureSpec.getSize(widthMeasureSpec) / 9;
    h = MeasureSpec.getSize(heightMeasureSpec) / 9;
  }

  /**
   * draw 9 vertical lines.
   *
   * @param canvas
   */
  public void drawVerticalLine(Canvas canvas) {
    for (int i = 0; i < 9; i++) {
      canvas.drawLine(i * w, getHeight(), i * w, 0, sPaint);
    }
  }

  /*
  draw horizontal lines.
   */
  public void drawHorizontalLine(Canvas canvas) {
    sPaint.setAntiAlias(true);
    for (int j = 0; j < 9; j++) {
      canvas.drawLine(0, j * h, getWidth(), j * h, sPaint);
    }
  }

  /** draw the default number on the game board. These are the numbers that cannot be modified. */
  public void drawDefaultNum(Canvas canvas) {
    sPaint.setColor(Color.BLUE);
    sPaint.setTextAlign(Paint.Align.CENTER);
    sPaint.setTextSize(60);
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        String num = Integer.toString(sudo[i][j]);
        if (!num.equals("0")) {
          float x = w * j + 60;
          float y = 89 + h * i;
          canvas.drawText(num, x, y, sPaint);
        }
      }
    }
  }

  /** draw the game board. */
  @Override
  public void onDraw(Canvas canvas) {
    drawHorizontalLine(canvas);
    drawVerticalLine(canvas);
    drawDefaultNum(canvas);
    canvas.save();
    super.onDraw(canvas);
  }
}
