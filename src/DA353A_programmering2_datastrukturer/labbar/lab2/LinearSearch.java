/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab2;

import java.util.Arrays;
import java.util.Random;

public class LinearSearch {
    public int indexOf( int[] array, int value ) {
        int res = -1;
        for( int i=0; ( i<array.length ) && ( res == -1 ); i++ ) {
            if( value == array[ i ] )
                res = i;
        }
        return res;
    }
    
    public int indexOf2( int[] array, int value ) {
        for( int i = 0;  i<array.length; i++  ) {
            if( value == array[ i ] )
                return i;
        }
        return -1;
    }

    public int indexOf(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {

            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }

	public int[] randomIntArray(int count) {
		Random rnd = new Random();
		int[] arr = new int[count];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(count - 1);
		}
		return arr;
	}

	public RealNbr[] getRealNbrArray(int n) {
		RealNbr[] arr = new RealNbr[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new RealNbr(i);
		}
		System.out.println(Arrays.toString(arr));
		arr = (RealNbr[]) Exercise4.shuffle(arr);
		return  arr;
	}

	public int indexOf(RealNbr[] array, RealNbr value) {
		int res = -1;
		for( int i=0; ( i<array.length ) && ( res == -1 ); i++ ) {
			if( value.equals(array[ i ]) )
				res = i;
		}
		return res;
	}

	public int indexOf(Object[] array, Object value) {
		int res = -1;
		for( int i=0; ( i<array.length ) && ( res == -1 ); i++ ) {
			if( value.equals(array[ i ]) )
				res = i;
		}
		return res;
	}
}
