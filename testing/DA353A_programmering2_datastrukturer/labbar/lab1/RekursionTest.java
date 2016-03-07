/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2016-01-19.
 */
public class RekursionTest {


	Rekursion theRekursion;

	@Before
	public void setUp() throws Exception {
		theRekursion = new Rekursion();
	}

	@Test
	public void testPrint() throws Exception {
		System.out.println("Test printInOrder");
		theRekursion.print(10, 15);

		System.out.println("Test print2");
		theRekursion.print(15, 10);

		System.out.println("Test print3");
		theRekursion.print(-3, 4);

	}


	@Test
	public void testEverySecondReverse() throws Exception {
		System.out.println("Test 1");
		theRekursion.everySecondReverse("Student", 6);
		System.out.println();
		System.out.println("Test 2");
		theRekursion.everySecondReverse("Lärare", 3);
		System.out.println();
		System.out.println("Test 3");
		theRekursion.everySecondReverse("Förälder", 17);
		System.out.println();
		System.out.println("Test 4");
		theRekursion.everySecondReverse("Barn", -2);
	}


	@Test
	public void testMyster2() throws Exception {
		//when you send in 10, 20
		/**
		 * 10+20 = 30
		 * 11+19 = 30
		 * 12+18 = 30
		 * 13+17 = 30
		 * ...
		 */
		theRekursion.mystery2(10, 20);
	}

	@Test
	public void testReverse() throws Exception {
		System.out.println("test 1");
		theRekursion.reverse(4, 10);
		System.out.println();
		System.out.println("test 2");
		theRekursion.reverse(5, 2);
		System.out.println();
		System.out.println("test 3");
		theRekursion.reverse(-2, 1);

	}

	@Test
	public void testPrinstStr() throws Exception {
		System.out.println("Test 1");
		theRekursion.printStr("Student", 0);
		System.out.println();
		System.out.println("Test 2");
		theRekursion.printStr("Student", 3);
		System.out.println();
		System.out.println("Test 3");
		theRekursion.printStr("Malmö högskola!", 6);
		System.out.println();
		System.out.println("Test 4");
		theRekursion.printStr("Hubert", 10);
		System.out.println();
		System.out.println("Test 5");
		theRekursion.printStr("Negativ position", -6);
	}

	@Test
	public void testFactorial_1() throws Exception {
		//Given
		int expected = 6;
		int got;
		//When
		got = theRekursion.factorial(3);
		//Then
		Assert.assertEquals("When i Factror 3", expected, got);
	}

	@Test
	public void testFactorial_2() throws Exception {
		//Given
		int expected = 1;
		int got;
		//When
		got = theRekursion.factorial(-3);
		//Then
		Assert.assertEquals("When i Factror -3", expected, got);
	}

	@Test
	public void testFactorial_3() throws Exception {
		//Given
		int expected = 720;
		int got;
		//When
		got = theRekursion.factorial(6);
		//Then
		Assert.assertEquals("When i Factror 6", expected, got);
	}

	@Test
	public void testMember_1() throws Exception {
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		//When
		boolean got = theRekursion.member(17, arr, 0);
		//Then
		Assert.assertFalse(got);
		System.out.println(got);

	}

	@Test
	public void testMember_2() throws Exception {
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		//When
		boolean got = theRekursion.member(23, arr, 0);
		//Then
		Assert.assertTrue(got);
		System.out.println(got);

	}

	@Test
	public void testMember_3() throws Exception {
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		//When
		boolean got = theRekursion.member(23, arr, 2);
		//Then
		Assert.assertFalse(got);
		System.out.println(got);
	}

	@Test
	public void testMember_4() throws Exception {
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		//When
		boolean got = theRekursion.member(10, arr, 0);
		//Then
		Assert.assertTrue(got);
		System.out.println(got);
	}

	@Test
	public void testMyster3_1() throws Exception {
		/**
		 * pos 2
		 * total 23 + -20
		 * pos 4
		 * tot 23 -20+ 8
		 * result 11
		 */
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		int expect = 11;
		//When
		int got = theRekursion.mystery3(arr, 0);
		//Then
		Assert.assertEquals(expect, got);
		System.out.println(MessageFormat.format("Myster 3.2 got: {0} and expected: {1}", got, expect));
	}

	@Test
	public void testMyster3_2() throws Exception {
		/**
		 * pos 1
		 * total -45
		 * pos 3
		 * tot -45+10
		 * pos 5
		 * result -35
		 * */
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		int expect = -35;
		//When
		int got = theRekursion.mystery3(arr, 1);
		//Then
		Assert.assertEquals(expect, got);
		System.out.println(MessageFormat.format("Myster 3.2 got: {0} and expected: {1}", got, expect));
	}

	@Test
	public void testMyster4() throws Exception {
		/**
		 * pos 0 23
		 * pos 1 -45
		 * +1
		 * pos 2
		 * +1
		 * pos 3
		 * pos 4
		 * result 2
		 * */
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		int expect = 2;
		//When
		int got = theRekursion.mystery4(arr, 0);
		//Then
		Assert.assertEquals(expect, got);
		System.out.println(MessageFormat.format("Myster 4 got: {0} and expected: {1}", got, expect));
	}

	@Test
	public void testSum_1() throws Exception {
		//Given
		int expected = 30;
		//When
		int got = theRekursion.sum(4, 8);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got " + got);
	}

	@Test
	public void testSum_2() throws Exception {
		//Given
		int expected2 = 0;
		//When
		int got2 = theRekursion.sum(5, 2);
		//Then
		Assert.assertEquals(expected2, got2);
		System.out.println("got2 " + got2);

	}

	@Test
	public void testSum_3() throws Exception {
		//Given
		int expected = -2;
		//When
		int got = theRekursion.sum(-2, 1);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got " + got);
	}

	@Test
	public void test13ReverseStr() throws Exception {
		//TODO look through
		//Given
		String expected = "tudentS";
		String got;
		//When
		got = theRekursion.reverseStr("Student");
		//Then

		//Assert.assertArrayEquals(expected,got);

		System.out.println("got " + got);
	}

	@Test
	public void test_14_Mystery5() throws Exception {
		//Given
		int expected = 24;
		/**
		 * n 4, res 1
		 * n 3, res 4
		 * n 2, res 12
		 * n 1, res 24
		 * result 24
		 */

		//When
		//System.out.println( mystery5( 4, 1 ) )
		int got = theRekursion.mystery5(4, 1);

		//Then
		Assert.assertEquals(expected, got);
		System.out.println("Mystery 5. expected 24 and got: " + theRekursion.mystery5(4, 1));

	}

	@Test
	public void test_15_everySecond() throws Exception {

		System.out.println("test 1");
		theRekursion.everySecond("Student", 0, 6);
		System.out.println();
		System.out.println("Test 2");
		theRekursion.everySecond("Student", 3, 5);
		System.out.println();
		System.out.println("test 3");
		theRekursion.everySecond("Malmö högskola!", -4, 6);
		System.out.println();
		System.out.println("test 4");
		theRekursion.everySecond("Hubert!", 2, 10);
		System.out.println();
		System.out.println("test 5");
		theRekursion.everySecond("Hubert!", 5, 2);
		System.out.println();
	}

	@Test
	public void test_16_printString() throws Exception {
		String txt = "Student";
		int pos = 0;
		int n = 2;
		System.out.println("test 1");
		theRekursion.printString(txt, pos, n);
		System.out.println();
		System.out.println("test 2");
		theRekursion.printString(txt, 3, -1);
		System.out.println();
		System.out.println("test 3");
		theRekursion.printString("du", 0, 2);
		System.out.println();
		System.out.println("test 4");
		theRekursion.printString("Malmo hogskola! ", -2, 1);
		System.out.println();
		System.out.println("test 5");
		theRekursion.printString("Hubert", 10, 0);
		System.out.println();
	}

	@Test
	public void test_17_Mystery6() throws Exception {
		/**
		 * 10
		 * 6 (10 -4)
		 * 2 (6 -4)
		 * 3 (6-3)
		 * 0 (3-3)
		 * 7 (10 -3)
		 * 3 (7-4)
		 * 0 (4-4)
		 * 4 (7-3)
		 * 0 (4-4)
		 * 1 (4-3)
		 */

		//When
		theRekursion.mystery6(10);
	}

	@Test
	public void test_18_Myster7() throws Exception {
		//Given
		int[] arr = {3, 7, -2, 6, 9};
		//When
		theRekursion.mystery7(arr);
		//Then
		/**
		 * 9
		 * 6
		 * -2
		 * 7
		 * 3
		 */

	}

	@Test
	public void test_19_Digits() throws Exception {
		int got = theRekursion.digits("Student");

	}

	@Test
	public void test_20_DigitsNum_1() throws Exception {
		//Given
		int nbr = 95004;
		int expected = 5;

		//When
		int got = theRekursion.digitsNum(nbr);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got "+got+" expected: "+expected);
		System.out.println();

	}

	@Test
	public void test_20_DigitsNum_2() throws Exception {
		//Given
		int nbr = 32;
		int expected = 2;

		//When
		int got = theRekursion.digitsNum(nbr);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got "+got+" expected: "+expected);
		System.out.println();

	}

	@Test
	public void test_21_Fibonacci() throws Exception {
		long startTime;
		long endTime;
//		for (int i = 1; i < 31; i++) {
//			startTime = System.currentTimeMillis();
//			System.out.println(MessageFormat.format("{0} : fib= {1}", i, theRekursion.fib(i)));
//			endTime = System.currentTimeMillis();
//			System.out.println("ran for: "+(endTime-startTime));
//		}

				System.out.println(MessageFormat.format("{0} : fib= {1}", 8, theRekursion.fib(8)));

	}

	@Test
	public void test_22_Fibonacci_2() throws Exception {
		long startTime;
		long endTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {

			theRekursion.fib(30);
//			System.out.println(MessageFormat.format("{0} : fib= {1}", i, theRekursion.fib(30)));

		}
		endTime = System.currentTimeMillis();
		System.out.println("ran for: "+(endTime-startTime));
	}


}