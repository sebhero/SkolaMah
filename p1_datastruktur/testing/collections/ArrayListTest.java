/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class ArrayListTest {


	@Test
	public void testIterator() throws Exception {
		//Im testing
		System.out.println("Testing iteration of linkedlist");
		//Given
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		//When & given
		//using the iterator
		System.out.println("Simple For loop using iterator");
		for (Integer item : list) {
			System.out.println(item);
		}
		System.out.println();
		System.out.println("While loop with iterator");
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}