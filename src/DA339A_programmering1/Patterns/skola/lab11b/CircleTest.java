package DA339A_programmering1.Patterns.skola.lab11b;
/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */



/**
 * Created by sebadmin on 2015-10-05.
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle(23.2);
        c.setRadius(23.2); // setRadius eller initiera via konstruktor
        System.out.println("CIRKEL med radie = " + c.getRadius()); // getRadius
        System.out.println( "CIRKEL med area = " + Math.PI * c.getRadius()* c.getRadius());
// båda understrykningarna och lite till kan ersättas med area
        c.setRadius( c.getRadius()+ 5.7); // setRadius och getRadius, 1 el 2 rader med kod
        System.out.println( "CIRCLE, radius = " + c.getRadius() ); // toString
    }
}
