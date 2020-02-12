package c.dimitrios.papageorgacopoulos.csus.edu.pong;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.DisplayMetrics;

class Bat extends GameObject {

    private float mXCoord;
    private float mBatSpeed;

    // These variables are public and final
    // They can be directly accessed by
    // the instance (in PongGame)
    // because they are part of the same
    // package but cannot be changed
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    public int mBatMoving = STOPPED;

    Bat(Point screenSize){

        Paint myPaint = new Paint();
        myPaint.setColor(Color.RED);
        this.color = myPaint;

        // Configure the size of the bat based on
        // the screen resolution
        // One eighth the screen width
        this.width = screenSize.x / 8;
        // One fortieth the screen height
        this.height = screenSize.y / 40;

        // Configure the starting locaion of the bat
        // Roughly the middle horizontally
        mXCoord = screenSize.x / 2;
        // The height of the bat
        // off of the bottom of the screen
        float mYCoord = screenSize.y* .80f; //place the bat 20% of the way from the bottom

        // Initialize mRect based on the size and position
        body = new RectF(mXCoord, mYCoord,
                mXCoord + this.width,
                mYCoord + height);

        // Configure the speed of the bat
        // This code means the bat can cover the
        // width of the screen in 1 second
        mBatSpeed = screenSize.x;
    }
    void setSize(Point screenSize)
    {
        //mLength = mScreenX / 8;
        this.width = screenSize.x / 8;
        this.height = screenSize.y / 40;
    }

    /* This getter is useless
    // Return a reference to the mRect object
    RectF getRect(){
        return mRect;
    }
    */

    // Update the bat- Called each frame/loop
    void updateOnScreenPosition(long fps){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();

        // Move the bat based on the mBatMoving variable
        // and the speed of the previous frame
        if(mBatMoving == LEFT){
            mXCoord = mXCoord - mBatSpeed / fps;
        }

        if(mBatMoving == RIGHT){
            mXCoord = mXCoord + mBatSpeed / fps;
        }

        // Stop the bat going off the screen
        if(mXCoord < 0){
            mXCoord = 0;
        }

        if(mXCoord + this.width > metrics.widthPixels){
            mXCoord = metrics.widthPixels - this.width;
        }

        // Update mRect based on the results from
        // the previous code in update
        body.left = mXCoord;
        body.right = mXCoord + this.width;
    }

}
