/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140328;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class upg5 {


	/**
	 * Upg5 A
	 * 7,16,5,11
	 * fifo
	 * 7.16.5.11
	 */

	/**
	 * B
	 *      36
	 * 16       42
	 *      18      47
	 *             45
	 */

	/**
	 * C
	 * mysterC
	 * 1-10
	 * om sista ar mindre an forra
	 * swap
	 * sorterings algortihm
	 * man kan sorterar en int vektor.
	 */

	public static void mysteryC( int[] array ) {
		int temp;
		for( int i=0; i < array.length - 1; i++ ) {
			for( int j = array.length - 1; j > i; j-- ) {
				if( array[ j ] < array[ j - 1 ] ) {
					temp = array[ j ];
					array[ j ] = array[ j - 1 ];
					array[ j - 1 ] = temp;
				}
			}
		}
	}

	/**
	 * 1C
	 * y och 7
	 * skriver ut y x7
	 */

	public static void mysteryD( char c, int n ) {
		if( n > 0 ) {
			System.out.println( c );
			mysteryD( c, n - 1 );
		}
	}

	/**
	 * 1E
	 * 0
	 * 1
	 * 0
	 * 2
	 * 0
	 * 1
	 * 0
	 *abacaba
	 *
	 *
	 */

	public static void mysteryE( String str, int n ) {
		if( n >= 0 ) {
			mysteryE( str, n - 1 );
			System.out.print( str.charAt( n ) );
			mysteryE( str, n -1 );
		}
	}


	/**
	 * 1F
	 * a,d,e
	 */

	/**
	 * 5G
	 * en hashfunktion anvands for att skapa hashnycklar.
	 * Dessa nycklar blir da vart i hasttabellen de sparas
	 * hashfunktionen viktigaste uppgift ar att forsoka skapa sa unika
	 * nycklar som mojligt. .. sprids val i vektorn.
	 */

	/**
	 * upg 6
	 */
	private static int partiion(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		int storeIndex = left;
		//arr skifta element i position pivotIndex och right
		swap(arr, pivotIndex, right);
		for(int i= left; i <= right-1;i++) {
			if (arr[i] < pivotValue) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		swap(arr,storeIndex,right);

		return storeIndex;
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int temp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2]=temp;
	}

	/**
	 * upg 7
	 *
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mysteryE("ABCD", 2);
//		mysteryD('y',7);
//		int[] arr = new int[]{1, 3, 10, 5, 11};
//		System.out.println(Arrays.toString(arr));
//		mysteryC(arr);
//		System.out.println(Arrays.toString(arr));
	}
}
