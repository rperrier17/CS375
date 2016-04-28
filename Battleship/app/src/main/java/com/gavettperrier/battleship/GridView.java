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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: document your custom view class.
 */
public class GridView extends View {

    int numCells = 10;
    protected int selCol = -1;
    protected int selRow = -1;
    private List<Point> firedSquares = new ArrayList<Point>();
    //private List<Computers_Ships> firedSquares = new ArrayList<Computers_Ships>();
    private List<Paint> paintSqColors = new ArrayList<Paint>();
    private List<Point> compShipLocation = new ArrayList<Point>();


    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //This is the paint for each cell of the grid
        final Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);

        final Paint hitColor = new Paint();
        hitColor.setColor(Color.RED);
        Paint missColor = new Paint();
        missColor.setColor(Color.YELLOW);

        //This is the paint for a highlighted square
        Paint highlightSqPaint = new Paint();
        highlightSqPaint.setColor(Color.GREEN);

        int cellWidth = getWidth() / numCells;
        int cellHeight = getHeight() / numCells;

        //Make the Grid
        for(int col = 0; col < numCells; col++){
            for (int row = 0; row < numCells; row++){
                Paint p = gridSquPaint;
                int x = col * cellWidth;
                int y = row * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);

                if(selCol == col && selRow == row) {
                    if(row == 0){
                        p = hitColor;
                    }
                    else {
                        p = missColor;
                    }
                }
                /*paintSqColors.add(p);
                for (int i = 0; i < firedSquares.size(); i++) {
                    p = paintSqColors.get(i);
                }*/
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
        firedSquares.add(new Point((int)(x),(int)(y)));
        invalidate();
        return true;
    }
}
