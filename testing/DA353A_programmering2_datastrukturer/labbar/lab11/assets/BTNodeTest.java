/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

import DA353A_programmering2_datastrukturer.projekt.p1.collections.ArrayList;
import DA353A_programmering2_datastrukturer.projekt.p1.collections.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seb on 2016-02-23.
 */
public class BTNodeTest {

	@Test
	public void testCollectPreorder() throws Exception {

		BTNode<Integer> n6 = new BTNode<Integer>(new Integer(108), null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(new Integer(100), null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(new Integer(63), null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(new Integer(110), n6, null);
		BTNode<Integer> n2 = new BTNode<Integer>(new Integer(74), n4, n5);
		BTNode<Integer> tree = new BTNode<Integer>(new Integer(102), n2, n3);
		ArrayList<Integer> list = new ArrayList();


		//when
		tree.collectPreorder(list);
		//then
		System.out.println(list);

	}


	@Test
	public void testCollectLevelOrder() throws Exception {
		BTNode<Integer> n6 = new BTNode<Integer>(new Integer(108), null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(new Integer(100), null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(new Integer(63), null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(new Integer(110), n6, null);
		BTNode<Integer> n2 = new BTNode<Integer>(new Integer(74), n4, n5);
		BTNode<Integer> tree = new BTNode<Integer>(new Integer(102), n2, n3);
		LinkedList<Integer> list = new LinkedList();


		//when
		tree.collectLevelOrder(list);
		//then
		System.out.println(list);


	}

	@Test
	public void testCollect() throws Exception {
		BTNode<Integer> n6 = new BTNode<Integer>(new Integer(108), null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(new Integer(100), null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(new Integer(63), null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(new Integer(110), n6, null);
		BTNode<Integer> n2 = new BTNode<Integer>(new Integer(74), n4, n5);
		BTNode<Integer> tree = new BTNode<Integer>(new Integer(102), n2, n3);
		ArrayList<Integer> list = new ArrayList();



		//when
		tree.collect(list, new IntervalFilter(70,102));
		//then
		System.out.println(list);


	}
}