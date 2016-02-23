/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;
//import laboration8.LinkedQueue;

import DA353A_programmering2_datastrukturer.labbar.lab8.LinkedQueue;
import DA353A_programmering2_datastrukturer.projekt.p1.collections.ArrayList;
import DA353A_programmering2_datastrukturer.projekt.p1.collections.LinkedList;

import java.util.Iterator;


public class BTNode<V> {
	private V value;
	private BTNode<V> left;
	private BTNode<V> right;

	public interface Action<V> {
		public void action(V value);
	}

	public BTNode(V value, BTNode<V> left, BTNode<V> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BTNode<V> getLeft() {
		return this.left;
	}

	public void setLeft(BTNode<V> left) {
		this.left = left;
	}

	public BTNode<V> getRight() {
		return this.right;
	}

	public void setRight(BTNode<V> right) {
		this.right = right;
	}

	public int depth() {
		int leftH = -1, rightH = -1;
		if (left != null)
			leftH = left.depth();
		if (right != null)
			rightH = right.depth();
		return 1 + Math.max(leftH, rightH);
	}

	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null)
			leftS = left.size();
		if (right != null)
			rightS = right.size();
		return 1 + leftS + rightS;
	}

	public void preorder(Action<V> a) {
		a.action(value);
		if (left != null)
			left.preorder(a);
		if (right != null)
			right.preorder(a);
	}

	public void inorder(Action<V> a) {
		if (left != null)
			left.inorder(a);
		a.action(value);
		if (right != null)
			right.inorder(a);
	}

	public void postorder(Action<V> a) {
		if (left != null)
			left.postorder(a);
		if (right != null)
			right.postorder(a);
		a.action(value);
	}

	public void levelOrder(Action<V> a) {
		LinkedQueue<BTNode<V>> queue = new LinkedQueue<BTNode<V>>();
		BTNode<V> node;
		queue.enqueue(this);
		while (!queue.isEmpty()) {
			node = queue.dequeue();
			a.action(node.value);
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);
		}
	}

	public void showTree() {
		javax.swing.JOptionPane.showMessageDialog(null, new ShowBTNode<V>(this, 800, 600), "Show tree", javax.swing.JOptionPane.PLAIN_MESSAGE);
	}

	public BTNode<V> search(V value) {
        BTNode<V> current = null;

		if (this.value.equals(value)) {
			current = this;
		}

		if (current == null && this.left != null) {
			current = this.left.search(value);
		}

		if (current == null && this.right != null) {
			current = this.right.search(value);
		}

		return current;
	}


	public void collectPreorder(ArrayList<V> list) {
//		list.add(this.value);
//		//if left has something preOrder its childes
//		if (this.left != null) {
//			this.left.collectPreorder(list);
//		}
//		//Done with left side do right side preOrder
//		if (this.right != null) {
//			this.right.collectPreorder(list);
//		}

//		Action<V> a = new Action<V>() {
//			@Override
//			public void action(V value) {
//				list.add(V value);
//			}
//		};

//		Action<V> a = value1 -> list.add(value1);
//		preorder(value1 -> list.add(value1));

		preorder(a -> list.add(a));

	}

	public void collectLevelOrder(LinkedList<V> list) {
		levelOrder(a -> list.add(a));
	}

	public void collect(ArrayList<V> list, Filter<V> filter) {
//		if (this.left != null) {
//			this.left.collect(list, filter);
//		}
//
//		if (filter.accept(this.value)) {
//			list.add(this.value);
//		}
//
//		if (this.right != null) {
//			this.right.collect(list,filter);
//		}


		inorder(a -> {
			if (filter.accept(a)) {
				list.add(a);
			}
		});


	}

	public ArrayList<V> collect(Filter<V> filter) {

		ArrayList<V> list = new ArrayList();

		inorder(a -> {
			if (filter.accept(a)) {
				list.add(a);
			}
		});
		return list;

	}
}
