/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Sorting class
 * @author Sebastian Börebäck on 2016-02-08.
 */
public class SearchingTest {

	private ArrayList<Integer> list;


	/**
	 * Setup a testing enviroment
	 * Generates a Integer Arraylist with random values to search through.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		//setup the list
		list = new ArrayList<>();
		int[] temp = Utility.randomArray(1_000_000 , 1, 100);
		for (int item : temp) {
			list.add(item);
		}
	}


	/**
	 * BinarySeach test.
	 * Sorts the list with mergsort and uses binaryseach to find a value.
	 * @throws Exception
	 */
	@Test
	public void testBinearSearch() throws Exception {
		//Im testing
		System.out.println("BinarySearch test");
		System.out.println("size "+list.size());

		//Given
		Integer lookingFor =new Integer(55);
		//set it at pos 10;
		list.set(555, lookingFor);
		Sorting.sort(list);

		//When
		int got = Searching.binarySearch(list, lookingFor);

		//Then
		System.out.println("on "+got+": value: "+list.get(got));
		Assert.assertEquals(lookingFor, list.get(got));
		System.out.println("size "+list.size());
		System.out.println();
	}

	/**
	 * Searches through a Arraylist using the LinearSearch
	 * @throws Exception
	 */
	@Test
	public void testLinearSearch() throws Exception {
		//Im testing
		System.out.println("LinearSearch test");
		System.out.println("size "+list.size());

		//Given
		Integer lookingFor =new Integer(-1);
		//set it at pos 10;
		list.set(555, lookingFor);

		//When
		int got = Searching.linearSearch(list, lookingFor);

		//Then
		System.out.println("on "+got+": value: "+list.get(got));
		Assert.assertEquals(lookingFor, list.get(got));
		System.out.println("size "+list.size());
		System.out.println();
	}


}