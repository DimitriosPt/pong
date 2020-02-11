package c.dimitrios.papageorgacopoulos.csus.edu.pong;

import android.graphics.RectF;

public abstract class GameObject {
    private RectF body;
    private float height;
    private float width;

    abstract void setSize(int screenX, int sceenY);
    abstract void updateOnScreenPosition(long fps);

}
