package com.gavettperrier.battleship;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rachel on 4/1/2016.
 */
public class Ship {
    private GridPoint front;
    private GridPoint back;
    private ArrayList<Boolean> health;
    private Boolean horizontal;
    Ship(GridPoint front, GridPoint back, Integer length){
        this.front = front;
        this.back = back;
        health = new ArrayList<Boolean>();
        for(int i = 0; i < length; i++){
            health.add(false);
        }
    }
}
