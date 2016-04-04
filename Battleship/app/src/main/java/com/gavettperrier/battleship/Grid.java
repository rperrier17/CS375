package com.gavettperrier.battleship;

import java.util.ArrayList;

/**
 * Created by Rachel on 4/1/2016.
 */
public class Grid {
    private GridPoint [][] gameGrid;
    public Grid(){
        for(int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                gameGrid[i][j] = new GridPoint();
            }
        }
    }
}
