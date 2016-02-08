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


	private ArrayList<Integer> list;
	private double[] dbArr;

	@Before
	public void setUp() throws Exception {
		//setup the list
		int size = 100;
		list = new ArrayList<>(size);
		dbArr = new double[size];
		int[] tempArr = new int[size];
		for (int i = 0; i < size; i++) {
			list.add(i);
			dbArr[i]=i;
		}
		Utility.shuffle(list);
		Utility.shuffle(dbArr);



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