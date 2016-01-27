/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4;

import DA353A_programmering2_datastrukturer.labbar.lab4.packages.RealNbr;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-01-25.
 */
public class lab4Test {

	@Before
	public void setUp() throws Exception {


	}

	@Test
	public void test_2_insertionSort() throws Exception {
		double[] arr = {10, 2, 30, 4, 5, 6, 7, 8, 9};

		System.out.println("original");
		System.out.println(Arrays.toString(arr));

		System.out.println("v1 sort");
		Lab4.insertionsortDesc(arr);
		System.out.println(Arrays.toString(arr));


//		System.out.println("v2 sort");
//		double[] arr2 = {10, 2, 30, 4, 5, 6, 7, 8, 9};
//		Lab4.insertionsortDescV2(arr2);
//		System.out.println(Arrays.toString(arr2));
	}

	@Test
	public void test_3_bubbleSort() throws Exception {
		double[] arr = {10, 2, 30, 4, 5, 6, 7, 8, 9};

		System.out.println("original");
		System.out.println(Arrays.toString(arr));

		System.out.println("v1 sort");
		Lab4.bubblesortDesc(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test_4_showStats() throws Exception {

		double[] arr = {10, 2, 30, 4, 5, 6, 7, 38, 9};

		System.out.println("v1 sort");
		Lab4.insertionsortDesc(arr);

		System.out.println("bubble sort");
		double[] arr3 = {10, 2, 30, 4, 5, 6, 7, 38, 9};
		Lab4.bubblesortDesc(arr3);
	}

	@Test
	public void test_5_mergeSort() throws Exception {


		//double[] arr5 = {10, 2, 30, 4, 5, 6, 7, 38, 9};
		double[] arr5 = Lab4.radnomArray(10,1,10);
		System.out.println("Original");
		//Lab4.printHorzArray(-1, -1, arr5, 80);

		System.out.println("Merge sort");
		Lab4.mergesortDescV2(arr5);
		//Lab4.printHorzArray(-1, -1, arr5, 80);
//		System.out.println(Arrays.toString(arr5));
	}

	@Test
	public void test_6_CheckTheTime() throws Exception {
		double[] arr = Lab4.radnomArray(10_000, 0, 100);
//		double[] arr = {10, 2, 30, 4, 5, 6, 7, 38, 9};
		double[] temp = arr.clone();

		long start = 0, end= 0;

		//-------------//
		System.out.println("Merge sort v2");
		start = System.currentTimeMillis();
		Lab4.mergesortDescV2(arr);
		end = System.currentTimeMillis();

		System.out.println("It took: " + (end - start));

		//-------------//
		arr = temp.clone();
		System.out.println("v1 insertion sort");

		start = System.currentTimeMillis();
		Lab4.insertionsortDesc(arr);
		end = System.currentTimeMillis();

		System.out.println("It took: " + (end - start));

		//-------------//
		arr = temp.clone();
		System.out.println("bubble sort");

		start = System.currentTimeMillis();
		Lab4.bubblesortDesc(arr);
		end = System.currentTimeMillis();

		System.out.println("It took: " + (end - start));
	}

	@Test
	public void test_9_bubbleSortObjects() throws Exception {
		Object[] arr = RealNbr.randomNumbers(10, 1, 10);
		System.out.println(Arrays.toString(arr));
		Lab4.bubblesort(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test_10_quickSort() throws Exception {
		int[] arr = {10, 2, 30, 4, 5, 6, 7, 38, 9};
		System.out.println(Arrays.toString(arr));
		QuickSort.quicksort(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test_11_mergSortObjects() throws Exception {
		Object[] arr = RealNbr.randomNumbers(10, 1, 10);
		System.out.println(Arrays.toString(arr));
		Lab4.mergesort(arr);
		System.out.println(Arrays.toString(arr));

	}
}