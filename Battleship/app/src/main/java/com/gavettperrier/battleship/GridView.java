package com.gavettperrier.battleship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * TODO: document your custom view class.
 */
public class GridView extends View {

    int numCells = 10;
    protected int selCol = -1;
    protected int selRow = -1;
    private int[][] computerShips = new int[10][10];
    private int[][] hitGrid = new int[10][10];

    /*
    Note: For the arrays computerShips and hitGrid, each member corresponds
            to a location on the actual grid.  If the member is initialized to 0,
            the color on the grid is white.  If the member is 1, then there was a ship
            there corresponding to a hit, so the color corresponding to that will be red.
            If the member is 2, then there was not a ship there, so the corresponding
            color will be yellow.
     */

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //initialize the hitGrid array to all zeros
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                hitGrid[i][j] = 0;
            }
        }
        setComputerShips();
    }

    /*
    Note: In the setComputerShips function, the locations for the computer's ships are
            set in the computerShips array.  In theory, this is where some AI would come
            into the app.  In practicality for the scope of this class, however, this
            will not be done with AI.
     */
    public void setComputerShips (){
        //For now, just set the ships to the same locations each time
        //Later on, have them go to random places
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                computerShips[i][j] = 2;
            }
        }
        //Set ship length 5
        computerShips[0][0] = 1;
        computerShips[0][1] = 1;
        computerShips[0][2] = 1;
        computerShips[0][3] = 1;
        computerShips[0][4] = 1;
        //Set ship length 4
        computerShips[6][4] = 1;
        computerShips[6][5] = 1;
        computerShips[6][6] = 1;
        computerShips[6][7] = 1;
        //Set ship length 3
        computerShips[3][5] = 1;
        computerShips[3][6] = 1;
        computerShips[3][7] = 1;
        //Set ship length 3
        computerShips[3][2] = 1;
        computerShips[4][2] = 1;
        computerShips[5][2] = 1;
        //Set ship length 2
        computerShips[7][1] = 1;
        computerShips[8][1] = 1;

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


        int cellWidth = getWidth() / numCells;
        int cellHeight = getHeight() / numCells;

        //Make the Grid
        for(int col = 0; col < numCells; col++){
            for (int row = 0; row < numCells; row++){
                Paint p = gridSquPaint;
                int x = col * cellWidth;
                int y = row * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);
                //hitGrid[(int)(x/cellWidth)][(int)(y/cellHeight)] = computerShips[(int)(x/cellWidth)][(int)(y/cellHeight)];
                    switch (hitGrid[col][row]) {
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

                canvas.drawRect(rect, p);
                canvas.drawRect(rect,outline);
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
        hitGrid[selCol][selRow] = computerShips[selCol][selRow];
        invalidate();
        return true;
    }
}
