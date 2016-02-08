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
public class LinkedListTest {

	@Test
	public void testIterator() throws Exception {
		//Im testing
		System.out.println("Testing iteration of linkedlist");
		//Given
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		//When
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

		//Then


	}
}