/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

/**
 * Created by seb on 2015-10-13.
 */
public class upg13j {
    public static void main(String[] args) {

        Point p1 = new Point( 10, 12 );
        Point p2 = new Point( 20, 15 );
        p1.setPoint( p2 );
        System.out.println( p1.toString() );
        System.out.println( p2.toString() );

    }
}
