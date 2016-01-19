/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2016-01-19.
 */
public class Rekursion {

	public void print(int min, int max) {

		if (min <= max) {
			System.out.println(min);
			print(min+1,max);
		}
	}

	public void everySecondReverse(String txt, int pos) {
		if (pos >= 0 && pos < txt.length()) {
			System.out.print(txt.charAt(pos));
			everySecondReverse(txt,pos-2);
		}
	}

	public void mystery1( int n ) {
		if( n > 0 ) {
			System.out.println( n );
			mystery1( n - 2 );
		}
	}

	public void mystery2(int a, int b) {
		if( a <= b ) {
			System.out.println( a + " + " + b + " = " + (a+b) );
			mystery2( a+1, b-1 );
		}
	}

	public void reverse(int min, int max) {
		if (max >= min) {
			System.out.print(max+" ");
			reverse(min,max-1);
		}

	}

	public void printStr(String txt, int pos) {
		if (pos <= txt.length()-1 && pos >=0) {
			//Mirrored if printStr is above
			System.out.print(txt.charAt(pos));
			printStr(txt,pos+1);
		}
	}

	public int factorial(int number) {
		System.out.println("Method " + number);

		if (number <= 1) {
			System.out.println("Returned 1");
			return 1;
		} else {
			int result = number * factorial(number - 1);
			System.out.print("Returned " + result);
			System.out.println(MessageFormat.format(" : {0} * getFACT({0} -1)", number));

			return result;
		}
	}

	public boolean member(int nbr, int[] array, int pos) {
		boolean found = false;
		if ((pos < 0) || (pos >= array.length)) {
			System.out.println("Out of bound");
			return false;

		} else if (nbr == array[pos]) {
			System.out.println("Found it at pos "+pos);
			return true;
		} else {
			return member(nbr, array, pos + 1);
		}

	}

	public int mystery3(int[] arr, int pos) {
		if (pos >= arr.length) {
			return 0;
		} else {
			return arr[pos] +mystery3(arr,pos+2);
		}
	}

	public int mystery4(int[] array, int pos) {

		if( pos >= array.length )
			return 0;
		else if( array[ pos ] < 0 )
			return 1 + mystery4( array, pos + 1 );
		else
			return mystery4( array, pos + 1);

	}

	public int sum(int min, int max) {

		if (min <= max) {
			System.out.println(MessageFormat.format("min {0} max {1}", min, max));
			return min+sum(min + 1, max);
		} else {
			return 0;
		}
	}

	public void ReverseStr(String str) {
//		if (pos <= txt.length()-1 && pos >=0) {
//			//Mirrored if printStr is above
//			printStr(txt,pos+1);
//			System.out.print(txt.charAt(pos));
//
//		}
	}
}
