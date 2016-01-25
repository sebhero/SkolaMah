/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab2;

public class BinarySearch {
    
    public int binarySearch( int[] array, int key ) {
        int res = -1, min = 0, max = array.length - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( key == array[ pos ] )
                res = pos;
            else if( key < array[ pos ])
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }
}
