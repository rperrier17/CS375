package com.gavettperrier.battleship;

import java.util.ArrayList;

/**
 * Created by Rachel on 3/30/2016.
 */
public class User {
    private String username;
    private Integer gamesWon;
    private Integer gamesPlayed;
    private ArrayList<User> friends;
    User(String username){
        this.username = username;
        gamesPlayed = 0;
        gamesWon = 0;
        friends = new ArrayList<User>();
    }
}
