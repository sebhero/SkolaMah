/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab17;

/**
 * Created by Sebastian Börebäck on 2015-10-27.
 */
public class Exercise17e {

    public static void main(String[] args) {
        Exercise17e e17e = new Exercise17e();
        int[] array = { 1, 2, 3, 9, 5, 9 };
        int index;
        index = e17e.member( 7, array );
        System.out.println( "Position för 7: " + index );
        index = e17e.member( 9, array );
        System.out.println( "Position för 9: " + index );
    }

    private int member(int nbr, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if(array[i] == nbr)
            {
                return i;
            }
        }
        return -1;
    }
}
