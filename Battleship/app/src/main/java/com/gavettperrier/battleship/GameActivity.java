package com.gavettperrier.battleship;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;


public class GameActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView mShip1;
    private TextView mShip2;
    private TextView mShip3;
    private TextView mShip4;
    private TextView mShip5;
    private TextView selectedShip;
    private ViewGroup mRrootLayout;
    private int _xDelta;
    private int _yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRrootLayout = (ViewGroup) findViewById(R.id.root);
        mShip1 = (TextView) mRrootLayout.findViewById(R.id.ship1);
        mShip2 = (TextView) mRrootLayout.findViewById(R.id.ship2);
        mShip3 = (TextView) mRrootLayout.findViewById(R.id.ship3);
        mShip4 = (TextView) mRrootLayout.findViewById(R.id.ship4);
        mShip5 = (TextView) mRrootLayout.findViewById(R.id.ship5);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 300);
        mShip1.setLayoutParams(layoutParams);
        mShip1.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(150,450);
        mShip2.setLayoutParams(layoutParams2);
        mShip2.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(150,450);
        mShip3.setLayoutParams(layoutParams3);
        mShip3.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(150,600);
        mShip4.setLayoutParams(layoutParams4);
        mShip4.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(150,750);
        mShip5.setLayoutParams(layoutParams5);
        mShip5.setOnTouchListener(this);

        Button placeShips  = (Button)findViewById(R.id.startGameButton);
        placeShips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, PlayGameActivity.class);
                startActivity(intent);
            }
        });

        Button rotateShips = (Button)findViewById(R.id.rotateShipButton);
        rotateShips.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(selectedShip != null){
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)selectedShip.getLayoutParams();
                    int temp = params.height;
                    params.height = params.width;
                    params.width = temp;
                    selectedShip.setLayoutParams(params);
                }
            }
        });

    }
    public boolean onTouch(View view, MotionEvent event) {
        selectedShip = (TextView) view;
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        mRrootLayout.invalidate();
        return true;
    }

    public void myClickHandler(View v){}

}
