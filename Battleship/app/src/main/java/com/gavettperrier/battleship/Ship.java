package com.gavettperrier.battleship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rachel on 4/1/2016.
 */
public class Ship {//Took out extends View
    int _xDelta;
    int _yDelta;
    private ViewGroup mRootLayout;

    int cellWidth;
    int cellHeight;
    int xposfront;
    int xposback;
    int yposfront;
    int yposback;
    int size;
    public Ship(int cellWidth,int cellHeight,int xposfront, int yposfront,int size){
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.xposfront = xposfront;
        this.yposfront = yposfront;
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
        Rect rect = new Rect(xposfront,yposfront,xposfront+cellWidth*size,yposfront+cellHeight);
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

    public boolean onTouch(View view, MotionEvent event) {
        //selectedShip = (Ship) view;
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        mRootLayout.invalidate();
        return true;
    }

    public boolean contains(int x, int y){
        if((x >= xposfront) && (x <= xposback) && (y >= yposfront) && (y <= yposback)) {
            return true;
        }
        else {
            return false;
        }
    }
}
