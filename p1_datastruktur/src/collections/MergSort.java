/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class MergSort {

	public static <E> void mergesort(ArrayList<E> arr) {

		ArrayList<E> temp = new ArrayList<E>(arr.size());
//		for (E item : arr) {
//			temp.add(null);
//		}
		mergesort(arr, 0, arr.size(), temp);
		temp = null;
	}

	private static <E> void mergesort(ArrayList<E> arr, int start, int n, ArrayList<E> temp) {
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

	private static <E> void merge(ArrayList<E> arr, int first, int n1, int n2, ArrayList<E> temp) {
		int counter = 0, cursor1 = 0, cursor2 = n1, last = n1 + n2;
		Comparable comp;
		while ((cursor1 < n1) && (cursor2 < last)) {
			comp = (Comparable) arr.get(first + cursor1);
			//check if start index is less than last index of arr (lower/higher)
			//if lower ascending order if higher descending order
			if (comp.compareTo(arr.get(first + cursor2)) < 0) {
				temp.add(counter, arr.get(first + cursor1));
				cursor1++;
			} else {
				temp.add(counter, arr.get(first + cursor2));
				cursor2++;
			}
			counter++;
		}
		//swaping until reach n1 swaping lower value
		while (cursor1 < n1) {
			temp.add(counter, arr.get(first + cursor1));
			cursor1++;
			counter++;
		}
		//swaping until last. swaping higher value
		while (cursor2 < last) {
			temp.add(counter,arr.get(first + cursor2));
			cursor2++;
			counter++;
		}

		for (int i = 0; i < (n1 + n2); i++) {
			arr.set((first + i), temp.get(i));
		}

	}
}
