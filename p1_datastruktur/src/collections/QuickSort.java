/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * My implementation of Quicksort
 * @author Sebastian Börebäck on 2016-01-25.
 */
public class QuickSort {


	/**
	 * Constructor for quicksort
	 * @param array the array that you want to sort
	 */
	public static void quicksort(double[] array) {
		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Private constructor take the left and right index for the array.
	 * (start and end)
	 * @param array the array you want to sort
	 * @param left the left start position
	 * @param right the right start position
	 */
	private static void quicksort(double[] array, int left, int right) {
		int pivotIndex;
		if (left < right) {//minst 2 element
			pivotIndex = partition(array, left, right, (left + right) / 2); //flytta elementen
			quicksort(array, left, pivotIndex - 1);
			quicksort(array, pivotIndex + 1, right);
		}
	}

	/**
	 * Partition the array.
	 * Sort from left and right.
	 * @param array the original array
	 * @param left the left starting position
	 * @param right the right , the end
	 * @param pivotIndex the middle
	 * @return the pivotIndex, the new left/right
	 */
	private static int partition(double[] array, int left, int right, int pivotIndex) {
		double pivotValue = array[pivotIndex];
		int storeIndex = left;

		Utility.swap(array,pivotIndex,right);


		for (int i = left; i <= (right - 1); i++) {
			if (array[i] < pivotValue) {
				Utility.swap(array, i,storeIndex);
				storeIndex++;
			}
		}
		Utility.swap(array,storeIndex,right);
		return storeIndex;
	}
}
