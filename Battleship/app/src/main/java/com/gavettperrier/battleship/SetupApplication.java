package com.gavettperrier.battleship;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Rachel on 4/10/2016.
 */
public class SetupApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        Parse.initialize(new Parse.Configuration.Builder(getBaseContext())
                .applicationId("f1b626b8-cbb4-4dc7-b973-e98b2fa4de02")
                .server("https://cs375bship.azurewebsites.net/parse")//put / at the end of the url
                       .clientKey(" ")
                .build()
        );
    }
}
