package c.dimitrios.papageorgacopoulos.csus.edu.pong;

import android.graphics.RectF;

class Bat extends GameObject {

    // These are the member variables (fields)
    // They all have the m prefix
    // They are all private
    // because direct access is not required
    public RectF body;
    private float mLength;
    private float mXCoord;
    private float mBatSpeed;
    private int mScreenX;


    // These variables are public and final
    // They can be directly accessed by
    // the instance (in PongGame)
    // because they are part of the same
    // package but cannot be changed
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;

    // Keeps track of if an how the ball is moving
    // Starting with STOPPED
    public int mBatMoving = STOPPED;

    Bat(int screenX, int screenY){

        // Bat needs to know the screen
        // horizontal resolution
        // Outside of this method
        mScreenX = screenX;

        // Configure the size of the bat based on
        // the screen resolution
        // One eighth the screen width
        mLength = mScreenX / 8;
        // One fortieth the screen height
        float height = screenY / 40;

        // Configure the starting locaion of the bat
        // Roughly the middle horizontally
        mXCoord = mScreenX / 2;
        // The height of the bat
        // off of the bottom of the screen
        float mYCoord = screenY - height;

        // Initialize mRect based on the size and position
        body = new RectF(mXCoord, mYCoord,
                mXCoord + mLength,
                mYCoord + height);

        // Configure the speed of the bat
        // This code means the bat can cover the
        // width of the screen in 1 second
        mBatSpeed = mScreenX;
    }
    void setSize(int screenX, int screenY)
    {
        mScreenX = screenX;
        mLength = mScreenX / 8;
        float height = screenY/40;
    }

    /* This getter is useless
    // Return a reference to the mRect object
    RectF getRect(){
        return mRect;
    }
    */

    // Update the bat- Called each frame/loop
    void updateOnScreenPosition(long fps){

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

        if(mXCoord + mLength > mScreenX){
            mXCoord = mScreenX - mLength;
        }

        // Update mRect based on the results from
        // the previous code in update
        body.left = mXCoord;
        body.right = mXCoord + mLength;
    }

}
