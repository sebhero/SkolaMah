/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class SearchingTest {

	private ArrayList<Integer> list;


	@Before
	public void setUp() throws Exception {
		//setup the list
		list = new ArrayList<>();
		int[] temp = Utility.randomArray(13, 1, 100);
		for (int item : temp) {
			list.add(item);
		}
	}

	@Test
	public void testBinearSearch() throws Exception {
		//Im testing
		System.out.println("BinarySearch test");
		//Given
		Integer lookingFor =new Integer(55);
		//set it at pos 50;
		list.set(50, lookingFor);
		Sorting.sort(list);
		//When
		int got = Searching.binearSearch(list, lookingFor);
		System.out.println(got);
		//Then
		System.out.println(list);
		Assert.assertEquals(50,got);

	}

	@Test
	public void testLinearSearch() throws Exception {

	}
}