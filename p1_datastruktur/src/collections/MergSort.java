/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * My implementaion of the mergsort
 * @author Sebastian Börebäck on 2016-02-08.
 */
public class MergSort {

	/**
	 * Sorts the Arraylist with mergsort.
	 * @param arr the Arraylist you want to sort.
	 * @param <E> the type of elements in the Arraylist
	 */
	public static <E> void mergesort(ArrayList<E> arr) {
		E[] temp = (E[])(new Object[arr.size()]);
		mergesort(arr, 0, arr.size(), temp);
		temp = null;
	}

	/**
	 * The mergsort.
	 * This will divide the Arraylist and sort it.
	 * @param arr the Arraylist
	 * @param start the start position for merge
	 * @param n the size of arraylist
	 * @param temp temp array a helper used by the mergsort to store the sorted elements
	 * @param <E> the Arraylist type
	 */
	private static <E> void mergesort(ArrayList<E> arr, int start, int n, E[] temp) {
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

	/**
	 * Merging together the divided Arraylist
	 * @param arr the original Arraylist
	 * @param first the first element in the Arraylist
	 * @param n1 first middle
	 * @param n2 last middle
	 * @param temp the temp array where the sorted data is stored.
	 * @param <E> the Arraylist type
	 */
	private static <E> void merge(ArrayList<E> arr, int first, int n1, int n2, E[] temp) {
		int counter = 0, cursor1 = 0, cursor2 = n1, last = n1 + n2;
		Comparable comp;
		while ((cursor1 < n1) && (cursor2 < last)) {
			comp = (Comparable) arr.get(first + cursor1);
			//check if start index is less than last index of arr (lower/higher)
			//if lower ascending order if higher descending order
			if (comp.compareTo(arr.get(first+cursor2)) < 0) {
				temp[counter] = arr.get(first + cursor1);
				cursor1++;
			} else {
				temp[counter] = arr.get(first + cursor2);
				cursor2++;
			}
			counter++;
		}
		//swaping until reach n1 swaping lower value
		while (cursor1 < n1) {
			temp[counter] = arr.get(first + cursor1);
			cursor1++;
			counter++;
		}
		//swaping until last. swaping higher value
		while (cursor2 < last) {
			temp[counter] = arr.get(first + cursor2);
			cursor2++;
			counter++;
		}

		for (int i = 0; i < (n1 + n2); i++) {
			arr.set((first + i), temp[i]);
		}

	}
}
