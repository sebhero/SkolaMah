/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12;

import org.junit.Test;

/**
 * Created by Sebastian Börebäck on 2016-02-23.
 */
public class BinarySearchTreeTest {

	@Test
	public void testSize1_8a() throws Exception {

		//Im testing
		System.out.println("8a testing size1()");
		//Given
		BinarySearchTree tree = new BinarySearchTree();
		//When
		int size = tree.size1();
		//Then
		System.out.println("current size: "+size);
	}

	@Test
	public void testSize2_8b() throws Exception {

		//Im testing
		System.out.println("8b testing size2()");
		//Given
		BinarySearchTree tree = new BinarySearchTree();
		//When
		int size = tree.size2();
		//Then
		System.out.println("current size: "+size);
	}

	@Test
	public void testSize_8c() throws Exception {

		//Im testing
		System.out.println("8c testing size()");
		//Given
		BinarySearchTree tree = new BinarySearchTree();
		tree.put("test","test");
		tree.put("test1","test");
		tree.put("test2","test");
		tree.put("test3","test");
		tree.remove("test");
		tree.remove("test3");
		tree.remove("test1");
		tree.remove("test2");
		//When
		int size = tree.size();
		//Then
		System.out.println("current size: "+size);

	}

	@Test
	public void testFirst_9() throws Exception {

		//Im testing
		System.out.println("9 testing first()");
		//Given
		BinarySearchTree<Integer,Integer> tree = new BinarySearchTree();

		tree.put(50,50);
		tree.put(40,40);
		tree.put(60,60);
		tree.put(70,70);
		tree.put(30,30);
		tree.put(50,50);
		tree.put(20,20);
		//When
		Integer first = tree.first();
		//Then
		System.out.println("current first: "+first);

	}


	@Test
	public void testLast_10() throws Exception {

		//Im testing
		System.out.println("10 testing last()");
		//Given
		BinarySearchTree<Integer,Integer> tree = new BinarySearchTree();
		tree.put(50,50);
		tree.put(40,40);
		tree.put(60,60);
		tree.put(70,70);
		tree.put(30,30);
		tree.put(50,50);
		tree.put(20,20);
		//When
		Integer value = tree.last();
		//Then
		System.out.println("current last: "+value);

	}

}