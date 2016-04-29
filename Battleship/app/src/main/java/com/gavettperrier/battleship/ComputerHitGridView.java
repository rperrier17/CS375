package com.gavettperrier.battleship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Rachel on 4/29/2016.
 */
public class ComputerHitGridView extends View {
    private int[][] compHitGrid = new int[10][10];

    public ComputerHitGridView(Context context, AttributeSet attr){

        super(context, attr);
        //Initialize the compHitGird to all 0 to start...same numbering system
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                compHitGrid[i][j] = 0;
            }
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //This is the paint for each cell of the grid
        final Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);

        //Paint colors for hit and miss
        final Paint hitColor = new Paint();
        hitColor.setColor(Color.RED);

        Paint missColor = new Paint();
        missColor.setColor(Color.YELLOW);

        Paint outline = new Paint();
        outline.setColor(Color.BLACK);
        outline.setStrokeWidth(7);
        outline.setStyle(Paint.Style.STROKE);

        int cellWidth = getWidth() / 10;
        int cellHeight = getHeight() / 10;

        //Make the Grid
        for(int col = 0; col < 10; col++){
            for (int row = 0; row < 10; row++){
                Paint p = gridSquPaint;
                int x = col * cellWidth;
                int y = row * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);
                switch (compHitGrid[col][row]) {
                    case 0:
                        p = gridSquPaint;
                        break;
                    case 1:
                        p = hitColor;
                        break;
                    case 2:
                        p = missColor;
                        break;
                }
                canvas.drawRect(rect,p);
                canvas.drawRect(rect,outline);
            }
        }

    }

    /*
    Note: This function lets the computer guess squares that the player's position is at.  It
            will go through a do-while loop to make sure it hasn't guessed that square before.
            At the moment, it is just setting all the squares equal to misses.  Later I will
            add in the comparison to the player's positions, once I get that global variable
            set up.
     */
    int c, r;
    public void computerGuesses(){
        Random i1 = new Random();
        Random i2 = new Random();
        do {
            c = i1.nextInt(10);
            r = i2.nextInt(10);
        } while (compHitGrid[c][r] != 0);
        compHitGrid[c][r] = 2;
    }

    //Make so when you touch the grid, the computer will fire
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        computerGuesses();
        invalidate();
        return true;
    }
}
