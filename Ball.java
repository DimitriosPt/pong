package c.dimitrios.papageorgacopoulos.csus.edu.pong;

import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.RectF;

class Ball extends GameObject {

    // These are the member variables (fields)
    // They all have the m prefix
    // They are all private
    // because direct access is not required

    private float mXVelocity;
    private float mYVelocity;

    //private float mBallWidth;
    // private float mBallHeight;
    //public RectF body;

    // This is the constructor method.
    // It is called when by the code:
    //  mBall = new Ball(mScreenX);
    // In the PongGame class
    Ball(Point screenSize){

        // Make the ball square and 1% of screen width
        // of the screen width

        setSize(screenSize);
//        mBallWidth = screenX / 100;
//        mBallHeight = screenX / 100;

        // Initialize the RectF with 0, 0, 0, 0
        // We do it here because we only want to
        // do it once.
        // WE will initialize the detail
        // at the start of each game
        body = new RectF();

        //Set Ball color
        Paint ballColor = new Paint();
        ballColor.setColor(Color.argb(255,255, 174, 66));
        this.setColor(ballColor);
    }

    @Override
    void setSize(Point size) {
        this.width = size.x / 100;
        this.height = size.x / 100;
    }
//
//    // Return a reference to mRect to PongGame
//    RectF getRect(){
//        return mRect;
//    }

    // Update the ball position.
    // Called each frame/loop
    void updateOnScreenPosition(long fps){
        // Move the ball based upon the
        // horizontal (mXVelocity) and
        // vertical(mYVelocity) speed
        // and the current frame rate(mFPS)

        // Move the top left corner
        body.left = body.left + (mXVelocity / fps);
        body.top = body.top + (mYVelocity / fps);

        // Match up the bottom right corner
        // based on the size of the ball
        body.right = body.left + this.width;
        body.bottom = body.top + this.height;
    }

    // Reverse the vertical direction of travel
    void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }

    // Reverse the horizontal direction of travel
    void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }

    void reset(int x, int y){

        // Initialise the four points of
        // the rectangle which defines the ball
        body.left = x / 2;
        body.top = 0;
        body.right = x / 2 + this.width;
        body.bottom = this.height;

        // How fast will the ball travel
        // You could vary this to suit
        // You could even increase it as the game progresses
        // to make it harder
        mYVelocity = -(y / 3);
        mXVelocity = (y / 3);
    }

    void increaseVelocity(){
        // increase the speed by 10%
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;
    }

    // Bounce the ball back based upon
    // whether it hits the left or right hand side
    void batBounce(RectF batPosition){

        // Detect center of bat
        float batCenter = batPosition.left +
                (batPosition.width() / 2);

        // detect the center of the ball
        float ballCenter = body.left +
                (this.width / 2);

        // Where on the bat did the ball hit?
        float relativeIntersect = (batCenter - ballCenter);

        // Pick a bounce direction
        if(relativeIntersect < 0){
            // Go right
            mXVelocity = Math.abs(mXVelocity);
            // Math.abs is a static method that
            // strips any negative values from a value.
            // So -1 becomes 1 and 1 stays as 1
        }else{
            // Go left
            mXVelocity = -Math.abs(mXVelocity);
        }

        // Having calculated left or right for
        // horizontal direction simply reverse the
        // vertical direction to go back up
        // the screen
        reverseYVelocity();
    }
}