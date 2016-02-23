/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by seb on 2016-02-23.
 */
public class ArrayHeapTest {

	@Test
	public void testSort() throws Exception {

		Random random = new Random();
		Integer[] values = new Integer[200];
		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt(900) + 100;
		}
//		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10);
////		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10, new ReverseComparable<Integer>());
//		for(Integer i : values)
//			heap.insert(i);

		//when
			ArrayHeap.sort(values);
		//then

		System.out.println(Arrays.toString(values));

	}
}