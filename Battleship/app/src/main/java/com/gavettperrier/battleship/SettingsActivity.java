package com.gavettperrier.battleship;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ToggleButton musicbutton = (ToggleButton) findViewById(R.id.togglemusic);
        musicbutton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                TextView musicview = (TextView) findViewById(R.id.musictext);
                if(musicbutton.isChecked()){
                    musicview.setText("Music Enabled");
                }
                else{
                    musicview.setText("Music Disabled");
                }

            }
        });

        final ToggleButton soundbutton = (ToggleButton) findViewById(R.id.togglesound);
        soundbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView soundview = (TextView) findViewById(R.id.soundtext);
                if(soundbutton.isChecked()){
                    soundview.setText("Sound Enabled");
                }
                else{
                    soundview.setText("Sound Disabled");
                }

            }
        });

        Button changeusrbutton = (Button) findViewById(R.id.usernamebutton);
        changeusrbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        Button changeprofilebutton = (Button) findViewById(R.id.profilebutton);
        changeprofilebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

}
