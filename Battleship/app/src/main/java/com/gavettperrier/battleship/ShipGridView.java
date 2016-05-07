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
    private int shipxpos = 0;
    private int shipypos = 0;
    //Array to hold ship positions...Will need to make global eventually
    int shipPositions[][] = new int[10][10];

    public ShipGridView(Context context, AttributeSet attr){
        super(context, attr);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Initialize the amount the ship array
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                shipPositions[i][j] = 2;
            }
        }

        //This is the paint for each cell of the grid
        final Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);

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
                p = gridSquPaint;
                canvas.drawRect(rect,p);
                canvas.drawRect(rect,outline);
            }
        }

        ship1 = new Ship(cellWidth, cellHeight, shipxpos, shipypos, 5);
        ship2 = new Ship(cellWidth, cellHeight, shipxpos, shipypos + cellHeight, 4);
        /*ship3 = new Ship(cellWidth,cellHeight,0,cellHeight*2,3);
        ship4 = new Ship(cellWidth,cellHeight,0,cellHeight*3,3);
        ship5 = new Ship(cellWidth,cellHeight,0,cellHeight*4,2);*/
        ship1.onDraw(canvas);
        ship2.onDraw(canvas);
        /*ship3.onDraw(canvas);
        ship4.onDraw(canvas);
        ship5.onDraw(canvas);*/
        //shipPositions[shipxpos][shipypos] = 1;

    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent){
        return this.onTouch(motionEvent);
    }

    public boolean onTouch(MotionEvent event) {
        //selectedShip = (Ship) view;
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        //Find X,Y this ship is under, and update the X,Y for that ship.
        //Math will be slightly different for changing the cordinates.
        {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) this.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    //ship1.xpos  = _xDelta;
                    //ship1.ypos = _yDelta;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
                            .getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    //this.setLayoutParams(layoutParams);
                    shipxpos = layoutParams.leftMargin;
                    shipypos = layoutParams.topMargin;
                    break;
            }
        }
        invalidate();
        return true;
    }
    /*float dx,dy;

    public boolean onTouchEvent(MotionEvent event,Ship ship){

    }*/

    /*AttributeSet attrs = new AttributeSet(){
        @Override
        public*/
}
