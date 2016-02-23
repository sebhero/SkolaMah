/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab2;


import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by seb on 2016-01-20.
 */
public class LinearSearchTest {

	private LinearSearch ls;

	@Before
	public void setUp() throws Exception {
		ls = new LinearSearch();
		//Given
		//expected
		//When
		//got
		//Then
	}

	//test double
	@Test
	public void test_1_IndexOfDouble() throws Exception {
		//Given
		double[] arr=new double[10];
		Arrays.fill(arr,1);
		arr[arr.length-1] =10;
		//When
		int got = ls.indexOf(arr, 10);
		//Then
		System.out.println("want 9 got: "+got);
	}

	//test string
	@Test
	public void test_2_IndexOfString() throws Exception {
		//Given
		String[] arr=new String[10];
		Arrays.fill(arr,"hello");
		arr[8] ="seb";
		//When
		int got = ls.indexOf(arr, "seb");
		//Then
		System.out.println("want 8 got: "+got);
	}

	@Test
	public void test_3_RandomIIntArray() throws Exception {
		//Given
		int count=10_000;
		Laboration2 lab2 = new Laboration2();
		int[] arr = lab2.randomIntArray(count);
//		int[] arr = ls.randomIntArray(count);

		//expected
		//When
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < count-1; i++) {
			ls.indexOf(arr, i);
		}
		long endTime = System.currentTimeMillis();
		//got
		System.out.println("got " + (endTime - startTime));
		//Then
		
	}

	@Test
	public void test_4_shuffleSwap() throws Exception {
		Exercise4 ex4 = new Exercise4();
		Integer[] arr = new Integer[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Integer(i);
		}
		arr = (Integer[]) ex4.shuffle(arr);
		for (Integer elem : arr) {
			System.out.println(elem);
		}
	}

	@Test
	public void test_5_RealNbr() throws Exception {
		//Given
		int n= 10;
		//expected
		//When
		//got
		System.out.println("Do getRealNbrArray");
		RealNbr[] arr = ls.getRealNbrArray(n);
		//Then
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test_6_RealNbrIndexOf() throws Exception {
		//Given
		RealNbr[] arr = ls.getRealNbrArray(10);
		RealNbr value = new RealNbr(9);
		RealNbr expected = new RealNbr(9);
		//When
		int got = ls.indexOf(arr, value);
		//got
		//Then
		System.out.println("reaknbr indexOf got "+got);
	}

	@Test
	public void test_7_IndexOfObject() throws Exception {
		//Given
		Object[] arr = ls.getRealNbrArray(10);
		Object value = new RealNbr(9);
		//When
		int got = ls.indexOf(arr, value);
		//Then
		System.out.println("Object indexOf got "+got);

		//Given
		Object[] arrStr = new String[5];
		Object valueStr = new String("hej");
		for (int i = 0; i < arrStr.length; i++) {
			arrStr[i]= "no";
		}
		arrStr[4] = valueStr;
		//expected
		//When
		got = ls.indexOf(arrStr, valueStr);
		//Then
		System.out.println("Object indexOf expect 4 got "+got);
	}

	@Test
	public void test_8_fillInteger() throws Exception {
		Laboration2 lab2 = new Laboration2();
		ArrayList<Integer> res1 = lab2.fillInteger(100_000, 10_000, 50_000);
//		System.out.println(Arrays.toString(res1.toArray()));
		System.out.println();

		ArrayList<RealNbr> res2 = new ArrayList<>();
		for (Integer item : res1) {
			res2.add(new RealNbr(item));
		}
		Collections.sort(res2);
//		System.out.println(Arrays.toString(res2.toArray()));
		System.out.println();
		int got = Collections.binarySearch(res2, new RealNbr(10_000));
		System.out.println("got "+got);
		got = Collections.binarySearch(res2, new RealNbr(20_000));
		System.out.println("got "+got);
		got = Collections.binarySearch(res2, new RealNbr(50_000));
		System.out.println("got "+got);
	}

	@Test
	public void test_9_binarySearch_1() throws Exception {

//Given
		int count=100_000;
		Laboration2 lab2 = new Laboration2();
		int[] arr = lab2.randomIntArray(count);
		BinarySearch bs = new BinarySearch();

		//expected
		//When
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < count-1; i++) {
			ls.indexOf(arr, i);

		}
		long endTime = System.currentTimeMillis();

		//Then
		System.out.println("Linear got " + (endTime - startTime));
		System.out.println();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < count-1; i++) {
			bs.binarySearch(arr, i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("binary got " + (endTime - startTime));

	}
}