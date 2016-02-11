/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class SortingTest {


	private ArrayList<Double> list;
	private double[] dbArr;

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
			list.add((double) temp[i]);
		}

	}


	@Test
	public void testQuickSort() throws Exception {
		//Im testing
		System.out.println("Testing quickSort");
		//Given
		System.out.println(Arrays.toString(dbArr));
		//When
		Sorting.sort(dbArr);
		//Then
		System.out.println("sorted");
		System.out.println(Arrays.toString(dbArr));


	}

	@Test
	public void testMergeSort() throws Exception {

		//Im testing
		System.out.println("Testing MergSort");
		//Given
		System.out.println(list);
		//When
		Sorting.sort(list);
		//Then
		System.out.println("sorted");
		System.out.println(list);
	}


}