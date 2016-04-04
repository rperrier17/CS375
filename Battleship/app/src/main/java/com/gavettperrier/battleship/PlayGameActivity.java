package com.gavettperrier.battleship;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PlayGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
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

        View.OnClickListener myClickHandler = new View.OnClickListener(){
            public void onClick(View v){
                Button btn = (Button)findViewById(v.getId());
                btn.getPaint().setColor(Color.RED);
                btn.getPaint().setStyle(Paint.Style.STROKE);
                btn.getPaint().setStrokeWidth(3);
            }
            //NEED TO MAKE IT SO PRESSING BUTTON WILL PERMANENTLY CHANGE COLOR!!!!!!!!!!!
        };
    }

}
