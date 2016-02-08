/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class Sorting {



	public static void sort(double[] array) {
		//quicksort
		QuickSort.quicksort(array);
	}

	public static <E> void sort(ArrayList<E> list) {
		//mergsort

		MergSort.mergesort(list);
	}

}
