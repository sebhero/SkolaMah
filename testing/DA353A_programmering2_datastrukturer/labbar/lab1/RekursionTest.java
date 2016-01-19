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
		System.out.println("Test print");
		theRekursion.print(10,15);

		System.out.println("Test print2");
		theRekursion.print(15,10);

		System.out.println("Test print3");
		theRekursion.print(-3,4);

	}


	@Test
	public void testEverySecondReverse() throws Exception {
		System.out.println("Test 1");
		theRekursion.everySecondReverse("Student", 6);
		System.out.println();
		System.out.println("Test 2");
		theRekursion.everySecondReverse( "Lärare", 3 );
		System.out.println();
		System.out.println("Test 3");
		theRekursion.everySecondReverse( "Förälder", 17 );
		System.out.println();
		System.out.println("Test 4");
		theRekursion.everySecondReverse( "Barn", -2 );
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
		theRekursion.mystery2(10,20);
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
		theRekursion.printStr( "Student" , 0);
		System.out.println();
		System.out.println("Test 2");
		theRekursion.printStr( "Student" , 3);
		System.out.println();
		System.out.println("Test 3");
		theRekursion.printStr( "Malmö högskola!" , 6);
		System.out.println();
		System.out.println("Test 4");
		theRekursion.printStr( "Hubert" , 10);
		System.out.println();
		System.out.println("Test 5");
		theRekursion.printStr( "Negativ position" , -6);
	}

	@Test
	public void testFactorial_1() throws Exception {
		//Given
		int expected = 6;
		int got;
		//When
		got = theRekursion.factorial( 3 );
		//Then
		Assert.assertEquals("When i Factror 3",expected,got);
	}

	@Test
	public void testFactorial_2() throws Exception {
		//Given
		int expected = 1;
		int got;
		//When
		got = theRekursion.factorial( -3 );
		//Then
		Assert.assertEquals("When i Factror -3",expected,got);
	}

	@Test
	public void testFactorial_3() throws Exception {
		//Given
		int expected = 720;
		int got;
		//When
		got = theRekursion.factorial( 6 );
		//Then
		Assert.assertEquals("When i Factror 6",expected,got);
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
		boolean got =theRekursion.member(23, arr, 0);
		//Then
		Assert.assertTrue(got);
		System.out.println(got);

	}

	@Test
	public void testMember_3() throws Exception {
		//Given
		int[] arr = {23, -45, -20, 10, 8};
		//When
		boolean got =theRekursion.member(23, arr, 2);
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
		Assert.assertEquals(expect,got);
		System.out.println(MessageFormat.format("Myster 3.2 got: {0} and expected: {1}", got,expect));
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
		Assert.assertEquals(expect,got);
		System.out.println(MessageFormat.format("Myster 3.2 got: {0} and expected: {1}", got,expect));
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
		Assert.assertEquals(expect,got);
		System.out.println(MessageFormat.format("Myster 4 got: {0} and expected: {1}", got,expect));
	}

	@Test
	public void testSum_1() throws Exception {
		//Given
		int expected = 30;
		//When
		int got = theRekursion.sum(4, 8);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got "+got);
	}

	@Test
	public void testSum_2() throws Exception {
		//Given
		int expected2 = 0;
		//When
		int got2 = theRekursion.sum(5, 2);
		//Then
		Assert.assertEquals(expected2, got2);
		System.out.println("got2 "+got2);

	}

	@Test
	public void testSum_3() throws Exception {
		//Given
		int expected = -2;
		//When
		int got = theRekursion.sum(-2, 1);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got "+got);
	}

	@Test
	public void testReverseStr() throws Exception {
		//Given
		int expected = -2;
		//When
		int got = theRekursion.sum(-2, 1);
		//Then
		Assert.assertEquals(expected, got);
		System.out.println("got "+got);

		theRekursion.ReverseStr( "Student");
	}
}