package com.example.game;//复制过去的时候这个改成自己的pkg name。
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SudokuGameBoard extends View {

    //the chessboard used to display the numbers.
    float w; // width of one tile
    float h; //height of one tile

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
        for (int i = 0; i < 10; i++) {
            canvas.drawLine(i*w, getHeight(),i*w , 0, sPaint);
        }
    }

    public void drawHorizontalLine(Canvas canvas) {
        for (int j = 0; j < 10; j++) {
            canvas.drawLine(0, j*h ,getWidth(),j*h, sPaint);
        }
    }

    String default9 = "004190200";
    String default8 = "801456003";
    String default7 = "070000000";
    String default6 = "240800690";
    String default5 = "000000000";
    String default4 = "009604050";
    String default3 = "016008049";
    String default2 = "000940007";
    String default1 = "000000000";


    public void drawDefaultNum1(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = toString().valueOf(default1.charAt(i));
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 89, sPaint);
            }
        }
    }

    public void drawDefaultNum2(Canvas canvas) {
        sPaint.setColor(Color.BLUE);
        sPaint.setTextAlign(Paint.Align.CENTER);
        sPaint.setTextSize(60);
        for (int i = 0; i < 9; i++) {
            String num = toString().valueOf(default2.charAt(i));
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
            String num = toString().valueOf(default3.charAt(i));
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
            String num = toString().valueOf(default4.charAt(i));
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
            String num = toString().valueOf(default5.charAt(i));
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
            String num = toString().valueOf(default6.charAt(i));
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
            String num = toString().valueOf(default7.charAt(i));
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
            String num = toString().valueOf(default8.charAt(i));
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
            String num = toString().valueOf(default9.charAt(i));
            if (!num.equals("0")) {
                float x = 120*i +60;
                canvas.drawText(num, x, 1513, sPaint);
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





}