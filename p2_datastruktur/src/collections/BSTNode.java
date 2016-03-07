/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Node used in the BinarySearchTree
 * @param <K> the key for the node
 * @param <V> the value of the node
 */
class BSTNode<K,V> {
    final K key;
    final V value;
    BSTNode<K,V> left;
    BSTNode<K,V> right;

	/***
	 * Creates a BSTNode for the BinarySearchTree
	 * @param key the key for the node
	 * @param value the value in the node
	 * @param left the left child to the node
	 * @param right the right child to the node
	 */
    public BSTNode(K key, V value, BSTNode<K,V> left, BSTNode<K,V> right ) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

	/***
	 * The nodes height in the tree
	 * @return the int height of the Node
	 */
    public int height() {
        int leftH = -1, rightH = -1;
        if( left != null )
            leftH = left.height();
        if( right != null )
            rightH = right.height();
        return 1 + Math.max( leftH, rightH );
    }

	/***
	 * The size of the Node
	 * @return the size of the node
	 */
    public int size() {
        int leftS = 0, rightS = 0;
        if( left != null )
            leftS = left.size();
        if( right != null )
            rightS = right.size();
        return 1 + leftS + rightS;
    }

	/***
	 * Prints out the node with its childes.
	 */
    public void print() {
        if( left != null)
            left.print();
        System.out.println(key + ": " + value);
        if( right != null )
            right.print();
    }

	/***
	 * Show the AVLTree
	 */
    public void showTree() {
        javax.swing.JOptionPane.showMessageDialog( null,
		        new ShowBST<>(this, 800, 600), "Show tree",
		        javax.swing.JOptionPane.PLAIN_MESSAGE );

    }
}
