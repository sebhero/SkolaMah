package DA339A_programmering1.Patterns.skola.lab11b;
/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */



/**
 * Created by sebban on 2015-10-05.
 */
public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }
    public Circle( double inRadius ) {
        this.radius = inRadius;
    }
    public void setRadius( double inRadius ) {
        this.radius = inRadius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double area() {
        double area = Math.PI * this.radius * this.radius;
        return area;
    }
    public String toString() {
        return "CIRCLE, radius = " + this.radius;
    }
}