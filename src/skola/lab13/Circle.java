/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

public class Circle {
    private double radius;
    private Point position;

    public Circle( double inRadius, Point inPosition ) {
        this.radius = inRadius;
        this.position = inPosition;
    }
    
    public void setPosition( Point inPosition ) {
        this.position = inPosition;
    }

    public double getRadius() {
        return this.radius;
    }

    public Point getPosition() {
        return this.position;
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public String toString() {
        return "CIRCLE, radius = " + this.radius + ", position = " + position.toString();
    }
}
