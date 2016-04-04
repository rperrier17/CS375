package com.gavettperrier.battleship;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rachel on 3/30/2016.
 */
public class GridSquare extends View {
    private Integer row;
    private Integer column;
    private GridPoint gridPoint;
    public GridSquare(Context context, AttributeSet attrs, Integer row, Integer column, GridPoint gridPoint) {
        super(context, attrs);
        this.row = row;
        this.column = column;
        this.gridPoint = gridPoint;
    }
}

