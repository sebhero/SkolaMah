/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;

/***
 * AVLNode nodes in the AVLTree
 * @param <K> the key of the element
 * @param <V> the value of the element
 */
class AVLNode<K, V> {
	K key;
	V value;
	AVLNode<K, V> left;
	AVLNode<K, V> right;
	int height = 0;

	/***
	 * Creates a AVLNode
	 * @param key the key for the node
	 * @param value the value in the node
	 * @param left the left child to the node
	 * @param right the right child to the node
	 */
	public AVLNode(K key, V value, AVLNode<K, V> left, AVLNode<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/***
	 * The AVLNode height in the AVLTree
	 * @return the int height of the Node
	 */
	public int height() {
		int leftD = -1, rightD = -1;
		if (left != null)
			leftD = left.height();
		if (right != null)
			rightD = right.height();
		return 1 + Math.max(leftD, rightD);
	}

	/***
	 * The size of the Node
	 * @return the size of the node
	 */
	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null)
			leftS = left.size();
		if (right != null)
			rightS = right.size();
		return 1 + leftS + rightS;
	}

	/***
	 * Prints out the node with its childes.
	 */
	public void print() {
		if (left != null)
			left.print();
		System.out.println(key + ": " + value);
		if (right != null)
			right.print();
	}

	/***
	 * Show the AVLTree
	 */
	public void showAVL() {
		javax.swing.JOptionPane.showMessageDialog(null, new ShowAVL(this, 800, 600), "Show tree", javax.swing.JOptionPane.PLAIN_MESSAGE);
	}
}
