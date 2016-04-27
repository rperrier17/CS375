package com.gavettperrier.battleship;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GridView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    int numCells = 10;
    protected int selCol = -1;
    protected int selRow = -1;

    public GridView(Context context) {
        super(context);
        init(null, 0);
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GridView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.GridView_exampleString);
        mExampleColor = a.getColor(
                R.styleable.GridView_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.GridView_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.GridView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.GridView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        mTextPaint.setTextSize(mExampleDimension);
        mTextPaint.setColor(mExampleColor);
        mTextWidth = mTextPaint.measureText(mExampleString);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        mTextHeight = fontMetrics.bottom;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        /*int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        // Draw the text.
        canvas.drawText(mExampleString,
                paddingLeft + (contentWidth - mTextWidth) / 2,
                paddingTop + (contentHeight + mTextHeight) / 2,
                mTextPaint);

        // Draw the example drawable on top of the text.
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }*/

        //This is the paint for each cell of the grid
        Paint gridSquPaint = new Paint();
        gridSquPaint.setColor(Color.WHITE);
        gridSquPaint.setStrokeWidth(1);
        gridSquPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        //This is the paint for a highlighted square
        Paint highlightSqPaint = new Paint();
        highlightSqPaint.setColor(Color.GREEN);
        highlightSqPaint.setStrokeWidth(1);
        gridSquPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        int cellWidth = getWidth() / numCells;
        int cellHeight = getHeight() / numCells;

        //Make the Grid
        for(int row = 0; row < numCells; row++){
            for (int col = 0; col < numCells; col++){
                Paint p = gridSquPaint;
                int x = row * cellWidth;
                int y = col * cellHeight;
                Rect rect = new Rect(x, y, x + cellWidth,y + cellHeight);
                canvas.drawRect(rect,p);

                if(selCol == col && selRow == row){

                }
            }
        }

    }

    //Make so we can select squares
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        float cellWidth = this.getWidth()/numCells;
        float cellHeight = this.getHeight()/numCells;
        selCol = (int)(x/cellWidth);
        selRow = (int)(y/cellHeight);
        invalidate();
        return true;
    }

    StateListDrawable makeHighlightable(Drawable drawable)
    {
        StateListDrawable res = new StateListDrawable();

        Drawable clone = drawable.getConstantState().newDrawable();

        clone.setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        res.addState(new int[] {android.R.attr.state_pressed}, clone);
        res.addState(new int[] { }, drawable);
        return res;
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getExampleString() {
        return mExampleString;
    }

    /**
     * Sets the view's example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
    public void setExampleString(String exampleString) {
        mExampleString = exampleString;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return mExampleColor;
    }

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    public float getExampleDimension() {
        return mExampleDimension;
    }

    /**
     * Sets the view's example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
        invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example drawable attribute value.
     *
     * @return The example drawable attribute value.
     */
    public Drawable getExampleDrawable() {
        return mExampleDrawable;
    }

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param exampleDrawable The example drawable attribute value to use.
     */
    public void setExampleDrawable(Drawable exampleDrawable) {
        mExampleDrawable = exampleDrawable;
    }
}
