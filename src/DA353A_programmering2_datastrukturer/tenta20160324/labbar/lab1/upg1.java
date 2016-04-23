/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.labbar.lab1;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class upg1 {
	public static void print(String str, int pos) {
		if (pos < str.length()) {
			System.out.print(str.charAt(pos));
			print(str,pos+1);
		}
	}

	public static void print(int min, int max) {
		if (min <= max) {
			System.out.println(min);
			print(min+1,max);
		}
	}


	public static void everySecondReverse(String txt, int pos) {
		if (pos >= 0 && pos < txt.length()) {
			System.out.print(txt.charAt(pos));
			everySecondReverse(txt,pos-2);
		}
	}

	public static void main(String[] args) {
		System.out.println( factorial( 3 ) ); // Resultat: 6
		System.out.println( factorial( -3 ) ); // Resultat: 1
		System.out.println( factorial( 6 ) ); // Resultat: 720
	}

	private static long factorial(long n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);

	}

	private static void reverse(int min, int max) {
		if (max >= min) {
			System.out.print(max + " ");
			reverse(min,max-1);
		}
	}
}
