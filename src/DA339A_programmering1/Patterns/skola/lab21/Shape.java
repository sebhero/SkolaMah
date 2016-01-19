/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab21;
import java.awt.*;

public abstract class Shape {
    protected int x,y;
    protected Color color;
    
    public Shape() {
        this(0,0,Color.white);
    }
    
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void setColor( Color color ) {
        this.color = color;
    }
    
    public abstract void paint(PaintWindow window);
}
