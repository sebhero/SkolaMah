/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2016-03-06.
 */
public class ArrayHeapTest {

	private ArrayHeap<Integer> heap;
	private Integer[] values;

	@Before
	public void setUp() throws Exception {
		Random random = new Random();
		values = new Integer[200];
		for(int i=0; i<values.length; i++)
			values[i] = random.nextInt(900)+100;


		heap = new ArrayHeap<Integer>(50);
//		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10, new ReverseComparable<Integer>());
//		for(Integer i : values)
//			heap.insert(i);
//		while(heap.size()>0) {
//			System.out.print(heap.delete()+" ");
//		}
//		System.out.println();

	}

	@Test
	public void testSort() throws Exception {
		//Im testing
		System.out.println("Sorting of ArrayHeap");
		//Given

//		for (Integer i : values) {
//			heap.insert(i);
//		}
		System.out.println("Not Sorted Array");
		System.out.println(Arrays.toString(values));
		//When
		ArrayHeap.sort(values);
		//Then
		System.out.println(Arrays.toString(values));
	}

	@Test
	public void testInsert() throws Exception {
		//Im testing
		System.out.println("Insert of ArrayHeap");
		//Given

		//When
		heap.insert(10);
		heap.insert(20);
		heap.insert(9);
		heap.insert(15);
		heap.insert(30);
		//Then
		System.out.println(heap);
		Assert.assertEquals(5, heap.size());

	}

	@Test
	public void testDelete() throws Exception {
		//Im testing
		System.out.println("delete of ArrayHeap");
		//Given
		heap.insert(10);
		heap.insert(20);
		heap.insert(9);
		heap.insert(15);
		heap.insert(30);
		//When
		int got = heap.delete();
		//Then
		System.out.println(heap);
		Assert.assertEquals(4, heap.size());
		Assert.assertEquals(9,got);
		System.out.println("got = "+got);

	}

	@Test
	public void testPeek() throws Exception {
		//Im testing
		System.out.println("peek at next in line of ArrayHeap");
		//Given
		heap.insert(10);
		heap.insert(20);
		heap.insert(9);
		heap.insert(15);
		heap.insert(30);
		//when
		int got = heap.peek();
		//then
		Assert.assertEquals(9, got);
		System.out.println("got "+got);
	}

	@Test
	public void testSize() throws Exception {
		//Im testing
		System.out.println("Size of ArrayHeap");
		//Given

		//When
		heap.insert(10);
		heap.insert(20);
		heap.insert(9);
		heap.insert(15);
		heap.insert(30);
		//Then
		System.out.println(heap);
		Assert.assertEquals(5, heap.size());
	}
}