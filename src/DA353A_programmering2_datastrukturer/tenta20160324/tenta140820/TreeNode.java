/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140820;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class TreeNode<K, V> {
	private K key;
	private V value;
	private TreeNode<K, V> left;
	private TreeNode<K, V> right;

	public TreeNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void add(K key, V value) {
		int comp = ((Comparable<K>) this.key).compareTo(key);
		if (comp > 0) {
			if (left != null) {
				left.add(key, value);
			} else {
				this.left = new TreeNode<>(key, value);
			}
		} else if (comp < 0) {
			if (right != null) {
				right.add(key, value);
			} else {
				right = new TreeNode<>(key, value);
			}
		}
	}

	public V maxValue() {
		return maxValue(this);
	}

	private V maxValue(TreeNode<K, V> node) {
		if (node.right != null) {
			return maxValue(node.right);
		}
		return node.value;

	}


	public static void main(String[] args) {
		TreeNode<Integer, String> tree =
				new TreeNode<Integer, String>(new Integer(22), "tjugotvå");
		tree.add(new Integer(40), "fyrtio");
		tree.add(new Integer(19), "nitton");
		tree.add(new Integer(48), "fyrtioåtta");
		tree.add(new Integer(31), "trettioett");
		tree.add(new Integer(45), "fyrtiofem");
		tree.add(new Integer(12), "tolv");

		System.out.println( "Största värde = " + tree.maxValue() );

	}
}
