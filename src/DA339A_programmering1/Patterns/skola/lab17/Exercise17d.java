/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab17;

/**
 * Created by Sebastian Börebäck on 2015-10-27.
 */
public class Exercise17d {


    public static void main(String[] args) {
        Exercise17d e17d = new Exercise17d();
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 1000, 100, 10, 1 };
        System.out.print( "Array 1 baklänges: " );
        e17d.reverse( arr1 );
        System.out.println();
        System.out.print( "Array 2 baklänges: " );
        e17d.reverse( arr2 );
        System.out.println();
    }

    public static void reverse(int[] theArray) {

        for (int i = theArray.length-1; i >= 0; i--) {
            System.out.print(theArray[i]);
            if(i-1 >= 0)
            {
                System.out.print(",");
            }
        }

    }
}
