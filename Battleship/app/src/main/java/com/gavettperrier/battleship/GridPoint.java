package com.gavettperrier.battleship;

/**
 * Created by Rachel on 4/1/2016.
 */
public class GridPoint {
    private Boolean occupied;
    private Boolean attacked;
    public GridPoint(){
        occupied = false;
        attacked = false;
    }

    public Boolean attackPoint(){
        if(!attacked){
            attacked = true;
            return occupied;
        }
        else {
            return false;
        }
    }
}
