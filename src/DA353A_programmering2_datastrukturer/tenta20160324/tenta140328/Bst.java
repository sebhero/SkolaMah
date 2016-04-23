/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140328;

import DA353A_programmering2_datastrukturer.labbar.lab12.assets.SearchTree;
import DA353A_programmering2_datastrukturer.projekt.p2.p2.collections.Action;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class Bst<K,V> implements SearchTree<K,V>{

	private Comparator<K> comparator;
	private BstNode<K,V> tree;
	private int size = 0;

	public Bst() {

	}

	public void traversal(Action<V> action) {
		traversal(action,tree);
	}

	private void traversal(Action<V> action, BstNode<K, V> node) {
		if (node != null) {
			traversal(action,node.left);
			action.action(node.value);
			traversal(action,node.right);
		}

		if (node.left != null) {
			traversal(action, node.left);
		}
		if (node.right != null) {
			traversal(action, node.right);
		}
		action.action(node.value);

	}

	public static void main(String[] args) {
		Bst<String,Integer> bst = new Bst<String,Integer>();
		int[] arr = {2,6,8,3,4,2,3,1,4,6,4};
		for(int i : arr)
			bst.put( String.valueOf(i), new Integer(i));
		Sum bstSum = new Sum();
		bst.traversal( bstSum );
		System.out.println( bstSum.total() );
	}


	@Override
	public void put(K key, V value) {

	}

	@Override
	public V remove(K key) {
		return null;
	}

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public boolean contains(K key) {
		return false;
	}

	@Override
	public int height() {
		return 0;
	}

	@Override
	public Iterator<V> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public List<K> keys() {
		return null;
	}

	@Override
	public List<V> values() {
		return null;
	}

	@Override
	public V first() {
		return null;
	}

	@Override
	public V last() {
		return null;
	}

	private BstNode<K, V> rotateLeft(BstNode<K, V> node) {

		BstNode<K, V> oldright = node.right;
		node.right = node.right.left;
		oldright.left = node;
		return oldright;




	}

	private static class Sum implements Action<Integer>{
		int total=0;
		public int total() {
			return total;
		}

		@Override
		public void action(Integer value) {
			total+=value;
		}
	}

	private class BstNode<K, V> {
		public BstNode<K, V> left;
		public V value;
		public BstNode<K, V> right;
	}
}
