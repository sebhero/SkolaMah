/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13f {

    public static void main(String[] args) {

        Point p1, p2;
        p1 = new Point( 10, 12 );
        Circle c1 = new Circle( 3.5, p1 );
        System.out.println( "DA339A_programmering1.Patterns.p1 = " + p1.toString() );
        System.out.println( "c1 = " + c1.toString() );
        System.out.println("------------------------");
        p2 = c1.getPosition();
        p2.setX( 333 ); // x-­‐värdet i DA339A_programmering1.Patterns.p2 ändras till 333
        System.out.println( "DA339A_programmering1.Patterns.p1 = " + p1.toString() );
        System.out.println( "c1 = " + c1.toString() );
        System.out.println( "DA339A_programmering1.Patterns.p2 = " + p2.toString() );

    }

}
