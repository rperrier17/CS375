package com.gavettperrier.battleship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rachel on 4/1/2016.
 */
public class Ship {//Took out extends View
    int cellWidth;
    int cellHeight;
    int xpos;
    int ypos;
    int size;
    public Ship(int cellWidth,int cellHeight,int xpos, int ypos,int size){
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.xpos = xpos;
        this.ypos = ypos;
        this.size = size;

    }
    /*public Ship(Context context, AttributeSet attr){
        super(context,attr);
    }*/
    /*private GridPoint front;
    private GridPoint back;
    private ArrayList<Boolean> health;
    private Boolean horizontal;
    Ship(GridPoint front, GridPoint back, Integer length){
        this.front = front;
        this.back = back;
        health = new ArrayList<Boolean>();
        for(int i = 0; i < length; i++){
            health.add(false);
        }
    }*/

    public void onDraw(Canvas canvas){
        //super.onDraw(canvas);
        Paint p1 = new Paint();
        p1.setColor(Color.MAGENTA);
        Rect rect = new Rect(xpos,ypos,xpos+cellWidth*size,ypos+cellHeight);
        canvas.drawRect(rect, p1);
    }
    /*//Make so we can select squares
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        float cellWidth = this.getWidth()/10;
        float cellHeight = this.getHeight()/10;
        selCol = (int)(x/cellWidth);
        selRow = (int)(y/cellHeight);
        invalidate();
        return true;
    }*/


}
