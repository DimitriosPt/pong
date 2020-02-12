package c.dimitrios.papageorgacopoulos.csus.edu.pong;

import android.graphics.Paint;
import android.graphics.RectF;

public abstract class GameObject {
    public RectF body;
    public float height;
    public float width;
    //attaches color to the game objects that are made since the ball and bat are always the same
    //color
    public Paint color;


    abstract void setSize(int screenX, int sceenY);
    abstract void updateOnScreenPosition(long fps);

    public void setColor(Paint color) {
        this.color = color;
    }
}
