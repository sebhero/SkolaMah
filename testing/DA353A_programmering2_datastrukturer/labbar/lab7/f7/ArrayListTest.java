/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7.f7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sebastian Börebäck on 2016-02-01.
 */
public class ArrayListTest {


	private ArrayList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>(2);

	}

	@Test
	public void test1_grow() throws Exception {
		//given
		System.out.println(list.size());
		//when
		list.add(10);
		System.out.println(list.size());
		list.add(10);
		System.out.println(list.size());
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		System.out.println(list.size());
		//then not through array out of bound exception
	}

	@Test
	public void test2_addfirst() throws Exception {
		//Given
		list.add(1);
		list.add(2);
		//When
		list.addFirst(3);
		//Then
		int got = list.get(0);
		Assert.assertEquals(3, got);
		Assert.assertEquals(1, (int)list.get(1));
		Assert.assertEquals(2, (int)list.get(2));

		System.out.println(list);
		//extra
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void test2_addLast() throws Exception {
		//Given
		list.add(1);
		list.add(2);
		//When
		list.addLast(3);
		//Then
		Assert.assertEquals(1, (int)list.get(0));
		Assert.assertEquals(2, (int)list.get(1));
		Assert.assertEquals(3, (int)list.get(2));

	}

	@Test
	public void test3_remove() throws Exception {
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		//When
		int got = list.remove(1);

		//extra
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		System.out.println(list);
		System.out.println("got "+got);

		//Then
		Assert.assertEquals(2,got);
		Assert.assertEquals(3,list.size());
		Assert.assertEquals(3,(int)list.get(1));
	}

	@Test
	public void testRemoveFirst() throws Exception {

		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.removeFirst();
		//Then
		Assert.assertEquals(1,got);
	}

	@Test
	public void testRemoveLast() throws Exception {
		System.out.println("remove last");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.removeLast();
		//Then
		Assert.assertEquals(4,got);
	}

	@Test
	public void testGet() throws Exception {
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		try {
			list.get(1000);
		} catch (ArrayIndexOutOfBoundsException e) {
		//Then
			Assert.assertTrue(e instanceof ArrayIndexOutOfBoundsException);
		}
	}

	@Test
	public void testSet() throws Exception {
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.set(1, 10);
		//Then
		Assert.assertEquals(10, (int)list.get(1));
		Assert.assertEquals(2, got);
	}

	@Test
	public void testClear() throws Exception {
		System.out.println("test clear");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("pre size "+list.size());
		//When
		list.clear();
		//Then
		Assert.assertEquals(0, list.size());
		System.out.println("new size "+list.size());
	}

	@Test
	public void testIndexOf() throws Exception {
		//Im testing
		System.out.println("Testing indexOf");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.indexOf(1, 3);
		//Then
		Assert.assertEquals(2, got);
		System.out.println("looking for nr 3, found at "+got);
	}

	@Test
	public void testIndexOfNull() throws Exception {
		//Im testing
		System.out.println("Testing indexOf NULL");
		//Given
		list.add(1);
		list.add(null);
		list.add(3);
		list.add(4);
		//When
		int got = list.indexOf(1, null);
		//Then
		Assert.assertEquals(1, got);
		System.out.println("looking for nr NULL, found at "+got);
	}
	@Test
	public void testIndexOfNotFound() throws Exception {
		//Im testing
		System.out.println("Testing indexOf not finding");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.indexOf(1, 5);
		//Then
		Assert.assertEquals(-1, got);
		System.out.println("looking for nr 5, didnt find it got: "+got);
	}

	@Test
	public void testIndexOfSimple() throws Exception {
		//Im testing
		System.out.println("Simple index of");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.indexOf(3);
		//Then
		Assert.assertEquals(2, got);
		System.out.println("looking for nr 3, found at "+got);
	}

	@Test
	public void testSize() throws Exception {
		//Im testing
		System.out.println("get the size");
		//Given
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//When
		int got = list.size();
		//Then
		Assert.assertEquals(4, got);
		System.out.println("should be 4, got= "+got);

	}
}