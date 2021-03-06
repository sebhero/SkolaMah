/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4;

import DA353A_programmering2_datastrukturer.labbar.lab4.f4.Utility;

/**
 * Created by Sebastian Börebäck on 2016-01-25.
 */
public class QuickSort {


	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int left, int right) {
		int pivotIndex;
		if (left < right) {//minst 2 element
			pivotIndex = partition(array, left, right, (left + right) / 2); //flytta elementen
			quicksort(array, left, pivotIndex - 1);
			quicksort(array, pivotIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
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
