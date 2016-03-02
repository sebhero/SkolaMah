/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

public class Laboration11 {
	public void exercise1() {
		BTNode<Integer> n6 = new BTNode<Integer>(new Integer(108), null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(new Integer(100), null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(new Integer(63), null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(new Integer(110), n6, null);
		BTNode<Integer> n2 = new BTNode<Integer>(new Integer(74), n4, n5);
		BTNode<Integer> tree = new BTNode<Integer>(new Integer(102), n2, n3);
		BTNode<Integer> res = tree.search(new Integer(63));
		if (res != null) {
			System.out.println("Finns");
		} else {
			System.out.println("Finns ej");
		}
        tree.showTree();
	}

	public void exercise2() {
		BTNode<Character> n1 = new BTNode<Character>(new Character('G'), null, null);
		BTNode<Character> n2 = new BTNode<Character>(new Character('S'), n1, null);
		BTNode<Character> n3 = new BTNode<Character>(new Character('X'), n2, null);
		BTNode<Character> n4 = new BTNode<Character>(new Character('N'), n3, null);
		BTNode<Character> tree = new BTNode<Character>(new Character('A'), n4, null);
		tree.showTree();
	}

	public void exercise3() {
		BTNode<String> n1 = new BTNode<String>("Anna", null, null);
		BTNode<String> n2 = new BTNode<String>("Anders", null, null);
		BTNode<String> n3 = new BTNode<String>("Emil", null, null);
		BTNode<String> n4 = new BTNode<String>("Admir", null, null);
		BTNode<String> n5 = new BTNode<String>("Lene", n1, n2);
		BTNode<String> n6 = new BTNode<String>("Robert", n3, n4);
		BTNode<String> tree = new BTNode<String>("Ahmed", n5, n6);
		tree.showTree();
	}

	public static void main(String[] args) {
		Laboration11 lab11 = new Laboration11();
		lab11.exercise1();
	}
}

