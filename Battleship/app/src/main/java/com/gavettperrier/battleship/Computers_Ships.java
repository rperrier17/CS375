package com.gavettperrier.battleship;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by Rachel on 4/27/2016.
 */
public class Computers_Ships {
    public Point coordinates;
    public Paint squColor;

    //This is the paint for a fired at square

    public Computers_Ships(Point point)
    {
        coordinates = point;
    }
}
