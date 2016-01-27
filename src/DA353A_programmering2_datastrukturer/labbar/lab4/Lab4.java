/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4;

import DA353A_programmering2_datastrukturer.labbar.lab4.f4.Utility;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-01-25.
 */
public class Lab4 {


	/**
	 * Creates a double-array with capacity of n with random
	 * numbers from min to max
	 *
	 * @param n   capacity
	 * @param min lowest number
	 * @param max highest number
	 * @return a double-array
	 */
	public static double[] radnomArray(int n, double min, double max) {

		double[] temp = new double[n];
		for (int i = 0; i < n; i++) {
			temp[i] = (Math.random() * (max - min)) + min;
		}
		return temp;
	}

	public static void insertionsortDescV2(double[] arr) {
		int compares = 0, swaps = 0;

		for (int i = 1; i < arr.length; i++) {
			compares++;
			for (int j = i; (j > 0) && (arr[j - 1] < arr[j]); j--) {
				swaps++;
				Utility.swap(arr, j, j - 1);
				compares++;
			}
		}

		System.out.println(MessageFormat.format("compares: {0} and swaps: {1}", compares, swaps));
	}

	public static void insertionsortDesc(double[] arr) {
		int compares = 0, swaps = 0;

		for (int i = 1; i < arr.length; i++) {
			int j = i;
			double toInsert = arr[i];
			compares++;
			//going backwards if j is not first value,
			//if next is bigger than current keep on going
			while ((j > 0) && (arr[j - 1] < toInsert)) {
				arr[j] = arr[j - 1];
				j--;
				compares++;
				swaps++;
			}
			arr[j] = toInsert;


		}

		System.out.println(MessageFormat.format("compares: {0} and swaps: {1}", compares, swaps));

	}

	public static void bubblesortDesc(double[] arr) {
		int compares = 0, swaps = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				compares++;
				if (arr[j] > arr[j - 1]) {
					Utility.swap(arr, j, j - 1);
					swaps++;
				}
			}
		}
		System.out.println(MessageFormat.format("compares: {0} and swaps: {1}", compares, swaps));

	}


	/**
	 * mergesrot a double array
	 *
	 * @param arr the array
	 * @param lo  the lowest value
	 * @param n   the array size
	 */
	public static void mergesortDesc(double[] arr, int lo, int n) {

		int low = lo;
		int high = n;

		//if low is higher or eq. with high
		//they have crossed paths
		if (low >= high) {
			return;
		}

		//find the middle index
		int middle = (low + high) / 2;

		//sort lower half
		mergesortDesc(arr, low, middle);

		//sort higher half
		mergesortDesc(arr, middle + 1, high);

		//save away last index for low arr sort
		int end_low = middle;

		//save away last index of the high arr sort
		int start_high = middle + 1;

		//if the lowest index is <= to bottom of arrays
		//highest index and lowest index of the 2nd array is
		// <= to its highest index

		while ((lo <= end_low) && (start_high <= high)) {

			//if the value in the first array is less
			//than the value in the 2nd array pos 1
			if (arr[low] > arr[start_high]) {
				//go to next in low
				low++;
			} else {
				//save the 1st index of the 2nd array
				double temp = arr[start_high];

				//dec backwards throught first array
				//starting at last index of the first array
				for (int k = start_high - 1; k >= low; k--) {
					arr[k + 1] = arr[k];
				}

				//swap in the value from start_high index
				arr[low] = temp;
				low++;
				end_low++;
				start_high++;
			}

		}
	}

	public static void mergesortDescV2(double[] arr) {
		double[] temp = new double[arr.length];
		mergesortDescV2(arr, 0, arr.length, temp);
		temp = null;
	}

	private static void mergesortDescV2(double[] arr, int start, int n, double[] temp) {
		int n1, n2;
		if (n > 1) {
			//first middle
			n1 = n / 2;
			//2nd middle
			n2 = n - n1;
			mergesortDescV2(arr, start, n1, temp);
			mergesortDescV2(arr, start + n1, n2, temp);
			merge(arr, start, n1, n2, temp);
		}
	}

	private static void merge(double[] arr, int first, int n1, int n2, double[] temp) {
		int counter = 0, cursor1 = 0, cursor2 = n1, last = n1 + n2;
		while ((cursor1 < n1) && (cursor2 < last)) {
			//check if start index is less than last index of arr (lower/higher)
			if (arr[first + cursor1] > arr[first + cursor2]) {
				temp[counter] = arr[first + cursor1];
				cursor1++;
			} else {
				temp[counter] = arr[first + cursor2];
				cursor2++;
			}
			counter++;
		}
		//swaping until reach n1 swaping lower value
		while (cursor1 < n1) {
			temp[counter] = arr[first + cursor1];
			cursor1++;
			counter++;
		}
		//swaping until last. swaping higher value
		while (cursor2 < last) {
			temp[counter] = arr[first + cursor2];
			cursor2++;
			counter++;
		}
		for (int i = 0; i < (n1 + n2); i++) {
			arr[first + i] = temp[i];
		}

	}

	public static void swap(Object[] array, int i, int j) {
			Object temp = array[ i ];
			array[ i ] = array[ j ];
			array[ j ] = temp;
	}


	public static void main(String[] args) {
//		double[] arr = radnomArray(10, 2, 10);
		double[] arr = {10, 2, 30, 4, 5, 6, 7, 8, 9};


		System.out.println("original");
		System.out.println(Arrays.toString(arr));

		System.out.println("v1 sort");
		insertionsortDesc(arr);
		System.out.println(Arrays.toString(arr));


		System.out.println("v2 sort");
		double[] arr2 = {10, 2, 30, 4, 5, 6, 7, 8, 9};
		insertionsortDescV2(arr2);
		System.out.println(Arrays.toString(arr2));

		System.out.println("bubble sort");
		double[] arr3 = {10, 2, 30, 4, 5, 6, 7, 8, 9};
		bubblesortDesc(arr3);
		System.out.println(Arrays.toString(arr3));

		System.out.println("Merge sort");
		double[] arr4 = {10, 2, 30, 4, 5, 6, 7, 8, 9};
		mergesortDesc(arr4, 0, arr4.length - 1);
		System.out.println(Arrays.toString(arr4));

		System.out.println("Merge sort V2");
		double[] arr5 = {10, 2, 30, 4, 5, 6, 7, 8, 9};
		mergesortDescV2(arr5);
		System.out.println(Arrays.toString(arr5));

	}


	public static void bubblesort(Object[] arr) {
		Comparable comp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				comp = (Comparable) arr[j - 1];
				if (comp.compareTo(arr[j]) > 0) {
					//Utility.swap(arr, j, j - 1);
					swap(arr,j,j-1);
				}
			}
		}
	}

	public static void mergesort(Object[] arr) {
		Object[] temp = new Object[arr.length];
		mergesort(arr, 0, arr.length, temp);
		temp = null;
	}

	private static void mergesort(Object[] arr, int start, int n, Object[] temp) {
		int n1, n2;
		if (n > 1) {
			//first middle
			n1 = n / 2;
			//2nd middle
			n2 = n - n1;
			mergesort(arr, start, n1, temp);
			mergesort(arr, start + n1, n2, temp);
			merge(arr, start, n1, n2, temp);
		}
	}

	private static void merge(Object[] arr, int first, int n1, int n2, Object[] temp) {
		int counter = 0, cursor1 = 0, cursor2 = n1, last = n1 + n2;
		Comparable comp;
		while ((cursor1 < n1) && (cursor2 < last)) {
			comp = (Comparable) arr[first + cursor1];
			//check if start index is less than last index of arr (lower/higher)
			//if lower ascending order if higher descending order
			if (comp.compareTo(arr[first+cursor2]) < 0) {
				temp[counter] = arr[first + cursor1];
				cursor1++;
			} else {
				temp[counter] = arr[first + cursor2];
				cursor2++;
			}
			counter++;
		}
		//swaping until reach n1 swaping lower value
		while (cursor1 < n1) {
			temp[counter] = arr[first + cursor1];
			cursor1++;
			counter++;
		}
		//swaping until last. swaping higher value
		while (cursor2 < last) {
			temp[counter] = arr[first + cursor2];
			cursor2++;
			counter++;
		}
		for (int i = 0; i < (n1 + n2); i++) {
			arr[first + i] = temp[i];
		}

	}


}
