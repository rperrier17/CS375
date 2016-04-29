package com.gavettperrier.battleship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rachel on 4/28/2016.
 */
public class ShipGridView extends View {
    private Ship ship1;
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
        

    }
}
