/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * AVL Tree, a balanced tree
 *
 * @param <K> the keys in the tree
 * @param <V> the values of the keys
 */
public class AVLTree<K, V> implements SearchTree<K, V> {
	private final Comparator<K> comparator;
	private AVLNode<K, V> tree;

	/***
	 * Constructs a Empty tree.
	 */
	public AVLTree() {
		comparator = new Comp();
	}

	/***
	 * Constructs a Empty tree with a choosen Comparator
	 *
	 * @param comp the comparator for sorting the Tree.
	 */
	public AVLTree(Comparator<K> comp) {
		comparator = comp;
	}

	/**
	 * Returns the root of the tree
	 *
	 * @return the root element
	 */
	public AVLNode<K, V> root() {
		return tree;
	}


	/**
	 * Returns the element at the specified position in the tree.
	 *
	 * @param key the key of the element to return.
	 * @return the element at the specified key in the tree
	 */
	public V get(K key) {
		AVLNode<K, V> node = find(key);
		if (node != null)
			return node.value;
		return null;
	}


	/**
	 * Add a key and its connected value to the tree
	 *
	 * @param key   key with which the specified value is connected with.
	 * @param value the value of the connected key
	 */
	public void put(K key, V value) {
		tree = put(tree, key, value);
	}

	/**
	 * Removes the mapped key from the tree if its present.
	 *
	 * @param key the key for the element to be removed.
	 * @return the value that was associated with the key.
	 */
	public V remove(K key) {
		V value = get(key);
		if (value != null) {
			tree = remove(tree, key);
		}
		return value;
	}

	/**
	 * Does the key exist in the tree
	 *
	 * @param key the key which we are looking for
	 * @return true if the key is in the tree
	 */
	public boolean contains(K key) {
		return find(key) != null;
	}

	/***
	 * Return the trees height
	 *
	 * @return the trees height
	 */
	public int height() {
		return height(tree);
	}

	/***
	 * Returns a iterator for the tree
	 *
	 * @return the Iterator for the tree.
	 */
	public Iterator<V> iterator() {
		return new Iter();
	}

	private AVLNode<K, V> find(K key) {
		int res;
		AVLNode<K, V> node = tree;
		while ((node != null) && ((res = comparator.compare(key, node.key)) != 0)) {
			if (res < 0)
				node = node.left;
			else
				node = node.right;
		}
		return node;
	}

	private AVLNode<K, V> put(AVLNode<K, V> node, K key, V value) {
		if (node == null) {
			node = new AVLNode<>(key, value, null, null);
		} else {
			if (comparator.compare(key, node.key) < 0) {
				node.left = put(node.left, key, value);
				//calc height
				countHeight(node);
				//balance tree
				node = balanceLeft(node);

			} else if (comparator.compare(key, node.key) > 0) {
				node.right = put(node.right, key, value);
				//calc height
				countHeight(node);
				//balance tree
				node = balanceRight(node);
			}
		}
		return node;
	}

	private AVLNode<K, V> remove(AVLNode<K, V> node, K key) {
		int compare = comparator.compare(key, node.key);
		if (compare == 0) {
			if (node.left == null && node.right == null)
				node = null;
			else if (node.left != null && node.right == null)
				node = node.left;
			else if (node.left == null && node.right != null)
				node = node.right;
			else {
				AVLNode<K, V> min = getMin(node.right);
				min.height = node.height;
				min.right = remove(node.right, min.key);
				min.left = node.left;
				node = min;
			}
		} else if (compare < 0) {
			node.left = remove(node.left, key);
		} else {
			node.right = remove(node.right, key);
		}
		if (node != null) {
			//calc height
			countHeight(node);
		}
		node = balanceNode(node);
		return node;
	}

	private AVLNode<K, V> getMin(AVLNode<K, V> node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	private int height(AVLNode<K, V> node) {
		if (node == null)
			return -1;
		return node.height();
	}

	private void countHeight(AVLNode<K, V> node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	/***
	 * Get the tree size
	 * @return the size of the tree.
	 */
	public int size() {
		return this.tree.size();
	}

	/**
	 * Get all the keys
	 * @return a list of all the keys
	 */
	public List<K> keys() {
		ArrayList<K> list = new ArrayList<>();
		keys(tree, list);
		return list;


	}

	private void keys(AVLNode<K, V> node, ArrayList<K> list) {
		if (node != null) {
			keys(node.left, list);
			list.add(node.key);
			keys(node.right, list);
		}
	}


	/***
	 * Get a list of all the values
	 * @return a list of all the values
	 */
	public List<V> values() {
		collections.ArrayList<V> list = new collections.ArrayList<>();
		Iterator<V> itr = this.iterator();
		while (itr.hasNext()) {
			list.add(itr.next());
		}
		return list;
	}

	/**
	 * Returns the first value is the tree. returns null if its empty
	 * @return the value of the first node.
	 */
	public V first() {
		AVLNode<K, V> node = this.tree;
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node.value;

	}

	/**
	 * Returns the last value is the tree. returns null if its empty
	 * @return the value of the last node.
	 */
	public V last() {
		AVLNode<K, V> node = this.tree;
		if (node == null) {
			return null;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	private class Comp implements Comparator<K> {
		public int compare(K key1, K key2) {
			Comparable<K> k1 = (Comparable<K>) key1;
			return k1.compareTo(key2);
		}
	}

	// AVLTree methods -----------------------------------------------
	private AVLNode<K, V> balanceNode(AVLNode<K, V> node) {
		if (node != null) {
			node = balanceLeft(node);
			node = balanceRight(node);
		}
		return node;
	}

	private AVLNode<K, V> balanceLeft(AVLNode<K, V> node) {
		if ((height(node.left) - height(node.right)) == 2) {

			if ((height(node.left.left) - height(node.left.right)) == -1) {
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			} else {
				node = rotateRight(node);
			}
		}
		return node;
	}

	private AVLNode<K, V> balanceRight(AVLNode<K, V> node) {
		if ((height(node.right) - height(node.left)) == 2) {
			if ((height(node.right.right) - height(node.right.left)) == -1) {
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			} else {
				node = rotateLeft(node);
			}
		}
		return node;
	}

	private AVLNode<K, V> rotateLeft(AVLNode<K, V> node) {
		AVLNode<K, V> rootNode = node.right;
		node.right = rootNode.left;
		rootNode.left = node;
		//calc height
		countHeight(node);
		countHeight(rootNode);

		return rootNode;
	}

	private AVLNode<K, V> rotateRight(AVLNode<K, V> node) {
		AVLNode<K, V> rootNode = node.left;
		node.left = rootNode.right;
		rootNode.right = node;
		//calc height
		countHeight(node);
		countHeight(rootNode);
		return rootNode;
	}
	// AVLTree methods -----------------------------------------------


	private class Iter implements Iterator<V> {
		final ArrayList<V> list = new ArrayList<>();
		int index = -1;

		public Iter() {
			inOrder(tree);
		}

		private void inOrder(AVLNode<K, V> node) {
			if (node != null) {
				inOrder(node.left);
				list.add(node.value);
				inOrder(node.right);
			}
		}

		/**
		 * Check if there is a next element
		 * @return true if there is a next element
		 */
		public boolean hasNext() {
			return index < list.size() - 1;
		}

		/***
		 * Get the next element
		 * @return the next element
		 */
		public V next() {
			if (!hasNext())
				throw new NoSuchElementException();
			index++;
			return list.get(index);
		}

		/**
		 * Not supported
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
