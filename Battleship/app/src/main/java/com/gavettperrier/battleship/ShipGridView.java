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
import android.widget.TextView;

/**
 * Created by Rachel on 4/28/2016.
 */
public class ShipGridView extends View {
    private Ship ship1, ship2, ship3, ship4, ship5;
    //private TextView selectedShip;
    //private ViewGroup mRrootLayout;
    private int _xDelta;
    private int _yDelta;
    public ShipGridView(Context context, AttributeSet attr){

        super(context, attr);


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //This is the paint for each cell of the grid
        final Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);

        int cellWidth = getWidth() / 10;
        int cellHeight = getHeight() / 10;

        //Make the Grid
        for(int col = 0; col < 10; col++){
            for (int row = 0; row < 10; row++){
                Paint p = gridSquPaint;
                int x = col * cellWidth;
                int y = row * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);
                p = gridSquPaint;
                canvas.drawRect(rect,p);
                p.setColor(Color.BLACK);
                p.setStrokeWidth(7);
                p.setStyle(Paint.Style.STROKE);
                canvas.drawRect(rect,p);
            }
        }

        ship1 = new Ship(cellWidth, cellHeight, 0, 0, 5);
        ship2 = new Ship(cellWidth, cellHeight, 0, cellHeight, 4);
        ship3 = new Ship(cellWidth,cellHeight,0,cellHeight*2,3);
        ship4 = new Ship(cellWidth,cellHeight,0,cellHeight*3,3);
        ship5 = new Ship(cellWidth,cellHeight,0,cellHeight*4,2);
        ship1.onDraw(canvas);
        ship2.onDraw(canvas);
        ship3.onDraw(canvas);
        ship4.onDraw(canvas);
        ship5.onDraw(canvas);
    }

    public boolean onTouch(View view, MotionEvent event) {
        //selectedShip = (Ship) view;
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
        invalidate();
        return true;
    }
    /*float dx,dy;

    public boolean onTouchEvent(MotionEvent event,Ship ship){

    }*/

    AttributeSet attrs = new AttributeSet(){
        @Override
        public int getAttributeCount() {
            return 0;
        }

        @Override
        public String getAttributeName(int index) {
            return null;
        }

        @Override
        public String getAttributeValue(int index) {
            return null;
        }

        @Override
        public String getAttributeValue(String namespace, String name) {
            return null;
        }

        @Override
        public String getPositionDescription() {
            return null;
        }

        @Override
        public int getAttributeNameResource(int index) {
            return 0;
        }

        @Override
        public int getAttributeListValue(String namespace, String attribute, String[] options, int defaultValue) {
            return 0;
        }

        @Override
        public boolean getAttributeBooleanValue(String namespace, String attribute, boolean defaultValue) {
            return false;
        }

        @Override
        public int getAttributeResourceValue(String namespace, String attribute, int defaultValue) {
            return 0;
        }

        @Override
        public int getAttributeIntValue(String namespace, String attribute, int defaultValue) {
            return 0;
        }

        @Override
        public int getAttributeUnsignedIntValue(String namespace, String attribute, int defaultValue) {
            return 0;
        }

        @Override
        public float getAttributeFloatValue(String namespace, String attribute, float defaultValue) {
            return 0;
        }

        @Override
        public int getAttributeListValue(int index, String[] options, int defaultValue) {
            return 0;
        }

        @Override
        public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
            return false;
        }

        @Override
        public int getAttributeResourceValue(int index, int defaultValue) {
            return 0;
        }

        @Override
        public int getAttributeIntValue(int index, int defaultValue) {
            return 0;
        }

        @Override
        public int getAttributeUnsignedIntValue(int index, int defaultValue) {
            return 0;
        }

        @Override
        public float getAttributeFloatValue(int index, float defaultValue) {
            return 0;
        }

        @Override
        public String getIdAttribute() {
            return null;
        }

        @Override
        public String getClassAttribute() {
            return null;
        }

        @Override
        public int getIdAttributeResourceValue(int defaultValue) {
            return 0;
        }

        @Override
        public int getStyleAttribute() {
            return 0;
        }
    };
}
