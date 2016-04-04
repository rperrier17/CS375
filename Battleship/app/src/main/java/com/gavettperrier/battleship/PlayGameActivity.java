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

    private Button selectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fire = (Button)findViewById(R.id.fireButton);

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton.setBackgroundColor(Color.RED);
            }
        });


    }

    public void myClickHandler(View v) {
        Button btn = (Button)findViewById(v.getId());
        btn.getPaint().setColor(Color.RED);
        btn.getPaint().setStyle(Paint.Style.STROKE);
        btn.getPaint().setStrokeWidth(3);
        selectedButton = btn;
    }
}
