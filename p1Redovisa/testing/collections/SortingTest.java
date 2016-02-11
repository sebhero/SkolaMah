/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-02-11.
 */
public class SortingTest {


	private ArrayList<Integer> list;
	private double[] dbArr;

	public static double[] randomArray(int n, double min, double max) {
		double[] array = new double[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() * (max - min) + min;
//			System.out.println(array[i]);
		}

//		System.out.println(" ");
		return array;
	}

	@Before
	public void setUp() throws Exception {
		//setup the list
		int size = 100_000;
		list = new ArrayList<>(size);
		dbArr = new double[size];
//		int[] tempArr = new int[size];
		int[] temp = Utility.randomArray(size, 1, 100);
		for (int i = 0; i < temp.length; i++) {
			dbArr[i] = temp[i];
			list.add(temp[i]);
		}

	}

	@Test
	public void testQuickSort() throws Exception {
		//Im testing
		System.out.println("Testing quickSort");
		//Given
		System.out.println(Arrays.toString(dbArr));
		//When
		Sorting.quicksort(dbArr);
		//Then
		System.out.println("sorted");
		System.out.println(Arrays.toString(dbArr));


	}

	@Test
	public void testMergeSort_with_Random() throws Exception {

		//Im testing
		System.out.println("Testing MergSort");
		//Given
		System.out.println(list);
		//When
		Sorting.mergesort(list);
		//Then
		System.out.println("sorted");
		System.out.println(list);
	}

	@Test
	public void testMergeSort_with_1_100() throws Exception {


		int size = 100;
		list = new ArrayList<>(size);
		int[] temp = new int[size];
		for (int i = 0; i < temp.length; i++) {
			list.add(i);
		}
		Utility.shuffle(list);

		//Im testing
		System.out.println("Testing MergSort");
		//Given
		System.out.println(list);
		//When
		Sorting.mergesort(list);
		//Then
		System.out.println("sorted");
		System.out.println(list);
	}

	@Test
	public void testMergeSort_using_randomArray() throws Exception {


		int size = 100;
		ArrayList<Integer> list2 = new ArrayList<>(size);
		double[] temp = randomArray(size,1,100);
		for (int i = 0; i < temp.length; i++) {
			list2.add((int) temp[i]);
		}

		//Im testing
		System.out.println("Testing MergSort");
		//Given
		System.out.println(list2);
		//When
		Sorting.mergesort(list2);
		//Then
		System.out.println("sorted");
		System.out.println(list2);
	}

}