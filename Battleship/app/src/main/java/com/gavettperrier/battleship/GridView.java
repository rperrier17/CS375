package com.gavettperrier.battleship;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: document your custom view class.
 */
public class GridView extends View {

    int numCells = 10;
    protected int selCol = -1;
    protected int selRow = -1;
    //private List<Point> firedSquares = new ArrayList<Point>();
    private List<Computers_Ships> firedSquares = new ArrayList<Computers_Ships>();



    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //This is the paint for each cell of the grid
        Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);

        Paint hitColor = new Paint();
        hitColor.setColor(Color.RED);
        Paint missColor = new Paint();
        missColor.setColor(Color.YELLOW);

        //This is the paint for a highlighted square
        Paint highlightSqPaint = new Paint();
        highlightSqPaint.setColor(Color.GREEN);

        int cellWidth = getWidth() / numCells;
        int cellHeight = getHeight() / numCells;

        //Make the Grid
        for(int row = 0; row < numCells; row++){
            for (int col = 0; col < numCells; col++){
                Paint p = gridSquPaint;
                int x = row * cellWidth;
                int y = col * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);

                if(selCol == col && selRow == row){
                    p = highlightSqPaint;
                }
                for(int i = 0; i < firedSquares.size(); i++)
                {
                    if(row == firedSquares.get(i).coordinates.x && col == firedSquares.get(i).coordinates.y)
                    {
                        if(firedSquares.get(i).coordinates.x == 0 && firedSquares.get(i).coordinates.y ==0)
                            firedSquares.get(i).squColor = hitColor;
                        else
                            firedSquares.get(i).squColor = missColor;
                        p = firedSquares.get(i).squColor;
                    }
                }
                firedSquares.add(new Point((int)(x),(int)(y)));
                canvas.drawRect(rect,p);
                p.setColor(Color.BLACK);
                p.setStrokeWidth(5);
                p.setStyle(Paint.Style.STROKE);
                canvas.drawRect(rect,p);
            }
        }

    }

    //Make so we can select squares
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        float cellWidth = this.getWidth()/numCells;
        float cellHeight = this.getHeight()/numCells;
        selCol = (int)(x/cellWidth);
        selRow = (int)(y/cellHeight);

        invalidate();
        return true;
    }
}
