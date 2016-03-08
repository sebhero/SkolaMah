/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * BinarySerachTree a binarysearchtree implementation
 * @param <K> the key type
 * @param <V> the value type
 */
public class BinarySearchTree<K, V> implements SearchTree<K, V>, Iterable {
	private final Comparator<K> comparator;
	private BSTNode<K, V> tree;
	private int size;

	/***
	 * Constructs a empty tree
	 */
	public BinarySearchTree() {
		comparator = new Comp();
	}

	/***
	 * Constructs a Empty tree with a choosen Comparator
	 *
	 * @param comp the comparator for sorting the Tree.
	 */
	public BinarySearchTree(Comparator<K> comp) {
		comparator = comp;
	}

	/***
	 * The root node. first node in the tree
	 * @return the first node in the tree
	 */
	public BSTNode<K, V> root() {
		return tree;
	}

	/**
	 * Returns the element at the specified position in the tree.
	 *
	 * @param key the key of the element to return.
	 * @return the element at the specified key in the tree
	 */
	public V get(K key) {
		BSTNode<K, V> node = find(key);
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
		size++;
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
			size--;
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

	private BSTNode<K, V> find(K key) {
		int res;
		BSTNode<K, V> node = tree;
		while ((node != null) && ((res = comparator.compare(key, node.key)) != 0)) {
			if (res < 0)
				node = node.left;
			else
				node = node.right;
		}

		return node;
	}

	private BSTNode<K, V> put(BSTNode<K, V> node, K key, V value) {

		if (node == null) {
			node = new BSTNode<>(key, value, null, null);
		} else {
			if (comparator.compare(key, node.key) < 0) {
				node.left = put(node.left, key, value);
			} else if (comparator.compare(key, node.key) > 0) {
				node.right = put(node.right, key, value);
			}
		}

		return node;
	}

	private BSTNode<K, V> remove(BSTNode<K, V> node, K key) {
		int compare = comparator.compare(key, node.key);
		if (compare == 0) {
			if (node.left == null && node.right == null)
				node = null;
			else if (node.left != null && node.right == null)
				node = node.left;
			else if (node.left == null && node.right != null)
				node = node.right;
			else {
				BSTNode<K, V> min = getMin(node.right);
				min.right = remove(node.right, min.key);
				min.left = node.left;
				node = min;
			}
		} else if (compare < 0) {
			node.left = remove(node.left, key);
		} else {
			node.right = remove(node.right, key);
		}

		return node;
	}

	private BSTNode<K, V> getMin(BSTNode<K, V> node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	private int height(BSTNode<K, V> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}


//	/**
//	 * Upg 8a. testa BTN-NODE size
//	 *
//	 * @return
//	 */
//	public int size1() {
//		if (tree == null) {
//			return 0;
//		}
//		//else
//		return tree.size();
//	}

	/***
	 * Get the tree size
	 * @return the size of the tree.
	 */
	public int size() {
		return size;
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


	private void keys(BSTNode<K, V> node, ArrayList<K> list) {
		if (node != null) {
			keys(node.left, list);
			list.add(list.size(), node.key);
			keys(node.right, list);
		}
	}


	/***
	 * Get a list of all the values
	 * @return a list of all the values
	 */
	public List<V> values() {
		LinkedList<V> list = new LinkedList<>();
		values(tree, list);
		return list;
	}



	private void values(BSTNode<K, V> node, LinkedList<V> list) {
		if (node != null) {
			values(node.left, list);

			list.addLast(node.value);
			values(node.right, list);
		}
	}

	/**
	 * Returns the first value is the tree. returns null if its empty
	 * @return the value of the first node.
	 */
	public V first() {
		BSTNode<K, V> node = this.tree;
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
		BSTNode<K, V> node = this.tree;
		if (node == null) {
			return null;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	/**
	 * Prints the tree in order. 1...10
	 */
	public void printInOrder() {
		printInOrder(tree);
	}

	private void printInOrder(BSTNode<K, V> node) {
		//InOrder

		if (node != null) {
			//do left side
			printInOrder(node.left);
			//back on the top
			if (height(node) >= 3) {
				System.out.println();
				System.out.print("[] " + node.key + " []");
				System.out.println();
			} else
				System.out.print(node.key + " -> ");
			//do right side
			printInOrder(node.right);

		}

	}

	/**
	 * prints the tree in preOrder
	 */
	private void printPreOrder() {
		printPreOrder(tree);


	}

	private void printPreOrder(BSTNode<K, V> node) {
		//dont need to check left or right if its null.
		//because i do this in the beginning. Bellow if.
		if (node != null) {
			System.out.print(node.key + " -> ");
			printPreOrder(node.left);
			printPreOrder(node.right);
			System.out.println();
		}
	}

	/**
	 * Prints the tree in PostOrder
	 */
	private void printPostOrder() {
		printPostOrder(tree);
		System.out.println();
	}

	private void printPostOrder(BSTNode<K, V> node) {
		if (node != null) {
			System.out.println();
			printPostOrder(node.left);

			printPostOrder(node.right);
			System.out.print(node.key + " -> ");
		}

	}

	/**
	 * Prints the tree in levelOrder
	 */
	private void printLevelOrder() {
		printLevelOrder(tree);
	}

	private void printLevelOrder(BSTNode<K, V> tree) {

		LinkedQueue<BSTNode<K, V>> queue = new LinkedQueue<>();
		BSTNode<K, V> node;
		queue.enqueue(tree);
		int height = height(tree);

		while (!queue.isEmpty()) {
			node = queue.dequeue();

			if (height > height(node)) {
				height--;
				System.out.println();
			}
			System.out.print(node.key + "\t\t");


			if (node.left != null) {
				queue.enqueue(node.left);
			}
			if (node.right != null) {
				queue.enqueue(node.right);
			}


		}
	}

//	/**
//	 * upg 8b
//	 *
//	 * @return
//	 */
//	public int size2() {
//		return size2(this.tree);
//
//	}

	/**
	 * Recursive walkthrough the nodes to count them
	 *
	 * @param node current node
	 * @return the tree size
	 */
	private int size2(BSTNode<K, V> node) {
		if (node == null) {
			return 0;
		}
		return 1 + size2(node.left) + size2(node.right);
	}

	/**
	 * Travesrse through the tree doing the action.
	 * Action can be print, save to list etc.
	 * @param action the action to do.
	 */
	public void traverse(Action<V> action) {
		traverse(tree, action);
	}

	private void traverse(BSTNode<K, V> node, Action<V> action) {
		if (node != null) {
			//InOrder
			traverse(node.left, action);
			action.action(node.value);
			traverse(node.right, action);
		}
	}

	private class Comp implements Comparator<K> {
		public int compare(K key1, K key2) {
			Comparable<K> k1 = (Comparable<K>) key1;
			return k1.compareTo(key2);
		}
	}

	private class Iter implements Iterator<V> {
		final ArrayList<V> list = new ArrayList<>();
		int index = -1;

		public Iter() {
			inOrder(tree);
		}

		private void inOrder(BSTNode<K, V> node) {
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
