/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class Sorting {

	/**
	 * Sort a double array using quicksort
	 * @param array the array to sort
	 */
	public static void sort(double[] array) {
		//quicksort
		QuickSort.quicksort(array);
	}

	/**
	 * Sort a Arraylist using mergesort
	 * @param list the Arraylist to sort
	 * @param <E> is generic
	 */
	public static <E> void sort(ArrayList<E> list) {
		//mergsort
		MergSort.mergesort(list);
	}

}
