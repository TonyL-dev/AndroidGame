package com.example.game;//复制过去的时候这个改成自己的pkg name。
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;


public class SudokuGameBoard extends View {

    //the chessboard used to display the numbers.
    float w; // width of one tile
    float h; //height of one tile
    Player newplayer;


    static int[] default9 = {0,0,4,1,9,0,2,0,0};
    static int[] default8 = {8,0,1,4,5,6,0,0,3};
    static int[] default7 = {0,7,0,0,0,0,0,0,0};
    static int[] default6 = {2,4,0,8,0,0,6,9,0};
    static int[] default5 = {0,0,0,0,0,0,0,0,4};
    static int[] default4 = {0,0,9,6,0,4,0,5,0};
    static int[] default3 = {0,1,6,0,0,8,0,4,9};
    static int[] default2 = {0,0,0,9,4,0,0,0,7};
    static int[] default1 = {0,0,0,0,0,0,0,0,0};
    static int[][] sudo = {default1,default2,default3,default4,default5,default6,default7,default8,default9};

    Paint sPaint;





    public SudokuGameBoard(Context context) {
        super(context);
    }

    public SudokuGameBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        w = MeasureSpec.getSize(widthMeasureSpec) / 9;
        h = MeasureSpec.getSize(heightMeasureSpec) / 9;
    }


    public void drawVerticalLine(Canvas canvas) {
        for (int i = 0; i < 9; i++) {
            canvas.drawLine(i*w, getHeight(),i*w , 0, sPaint);
        }
    }

    public void drawHorizontalLine(Canvas canvas) {
        for (int j = 0; j < 9; j++) {
            canvas.drawLine(0, j*h ,getWidth(),j*h, sPaint);
        }
    }



    public void drawDefaultNum1(Canvas canvas) {

        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default1[i]);
            if (!num.equals("0")) {
            float x = 120 * i + 60;
            canvas.drawText(num, x, 89, sPaint);
            }
            }
    }

    public void drawDefaultNum2(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default2[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 267, sPaint);
            }
        }
    }

    public void drawDefaultNum3(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default3[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 445, sPaint);
            }
        }
    }

    public void drawDefaultNum4(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default4[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 623, sPaint);
            }
        }
    }

    public void drawDefaultNum5(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default5[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 801, sPaint);
            }
        }
    }
    public void drawDefaultNum6(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default6[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 979, sPaint);
            }
        }
    }

    public void drawDefaultNum7(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default7[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 1157, sPaint);
            }
        }
    }

    public void drawDefaultNum8(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = Integer.toString(default8[i]);
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 1335, sPaint);
            }
        }
    }

    public void drawDefaultNum9(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            int num = default9[i];
            if (num !=(0)) {
                float x = 120*i +60;
                String n = Integer.toString(num);
                canvas.drawText(n, x, 1513, sPaint);
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawHorizontalLine(canvas);
        drawVerticalLine(canvas);
        drawDefaultNum1(canvas);
        drawDefaultNum2(canvas);
        drawDefaultNum3(canvas);
        drawDefaultNum4(canvas);
        drawDefaultNum5(canvas);
        drawDefaultNum6(canvas);
        drawDefaultNum7(canvas);
        drawDefaultNum8(canvas);
        drawDefaultNum9(canvas);
        canvas.save();
        super.onDraw(canvas);
    }

    static HashMap<ArrayList<Integer>, Integer> toHM(int[][] s){
        HashMap<ArrayList<Integer>, Integer> sudokuDesign = new HashMap<>();
        int y = 0;
        for (int[] i :s){
            y = y + 1;
            int x = 0;
            for (int j:i){
                x = x + 1;
                ArrayList<Integer> a = new ArrayList<>();
                a.add(y);
                a.add(x);
//                int[] position = {y,x};
                sudokuDesign.put(a, j);
            }
        }
        return sudokuDesign;
    }





}