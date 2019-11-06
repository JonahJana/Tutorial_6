package com.example.tutorial_6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

public class DrawingCanvas extends View {

    private Paint mPaint;
    private Path mPath;
    LinkedList<Paint> paintContainer;
    LinkedList<Path> pathsContainer;

    public int pathColour = Color.BLUE;

    public DrawingCanvas(Context context, AttributeSet attrs){
        super(context, attrs);

        paintContainer = new LinkedList<Paint>();
        pathsContainer = new LinkedList<Path>();

        mPaint = new Paint();
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(10);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(pathsContainer.size() > 0){
            for(int i = 0; i < pathsContainer.size(); i++){
                canvas.drawPath(pathsContainer.get(i), paintContainer.get(i));
                super.onDraw(canvas);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                mPaint.setColor(pathColour);
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setStrokeJoin(Paint.Join.ROUND);
                mPaint.setStrokeCap(Paint.Cap.ROUND);
                mPaint.setStrokeWidth(10);

                pathsContainer.addFirst(mPath);
                paintContainer.addFirst(mPaint);

                pathsContainer.getFirst().moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                pathsContainer.getFirst().lineTo(event.getX(), event.getY());
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                mPaint = new Paint();
                mPath = new Path();

                if(pathColour == Color.BLUE)
                    pathColour = Color.RED;
                else pathColour = Color.BLUE;

                break;
        }

        return true;
    }
}

