/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11;

import DA353A_programmering2_datastrukturer.labbar.lab11.assets.BTNode;

/**
 * Created by Sebastian Börebäck on 2016-02-22.
 */
public class upg4 {

	public void exercise4a() {
		BTNode<Integer> n1 = new BTNode<>(44,null,null);
		BTNode<Integer> n2 = new BTNode<>(45,n1,null);
		BTNode<Integer> n3 = new BTNode<>(36,null,null);
		BTNode<Integer> n4 = new BTNode<>(38,n3,n2);
		BTNode<Integer> n5 = new BTNode<>(17,null,null);
		BTNode<Integer> n6 = new BTNode<>(15,null,n5);

		BTNode<Integer> tree = new BTNode<Integer>(27,n6,n4);
		tree.showTree();
	}

	public static void main(String[] args) {
		upg4 lab11 = new upg4();
		lab11.exercise4a();
	}
}
