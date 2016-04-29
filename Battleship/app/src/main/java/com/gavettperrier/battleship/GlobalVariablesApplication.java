package com.gavettperrier.battleship;

import android.app.Application;

/**
 * Created by Rachel on 4/29/2016.
 */
public class GlobalVariablesApplication extends Application {
    private int playersShips[][] = new int[10][10];

    public GlobalVariablesApplication(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                playersShips[i][j] = 2;
            }
        }
    }

    public int getPlayersShips(int col, int row){
        return playersShips[col][row];
    }

    public void setPlayersShips(int col, int row){
        playersShips[col][row] = 1;
    }

}
