/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140328;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class LinkedList<E> {


	private ListNode<E> list = null;

	@Override
	public String toString() {
		String res = "[";
		ListNode<E> node = list;
		while (node != null) {
			res += node.getData().toString();
			node = node.getNext();
			if (node != null)
				res += ",";
		}
		return res + "]";
	}

	public int size() {
		int size = 0;
		ListNode<E> node = list;
		while (node != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	public void addFirst(E el) {
		if (list == null) {
			list = new ListNode<>(el, null);
		} else {
			ListNode<E> temp = list;
			list = new ListNode<E>(el, temp);
		}

	}


	class ListNode<E> {
		private E data;
		private ListNode<E> next;

		public ListNode(E data, ListNode<E> next) {
			this.data = data;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public ListNode<E> getNext() {
			return next;
		}

		public void setNext(ListNode<E> next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LinkedList<Long> longList = new LinkedList<Long>();
		longList.addFirst(new Long(9));
		longList.addFirst(new Long(4));
		longList.addFirst(new Long(8));
		System.out.println(longList.toString());
		System.out.println(longList.size());
	}
}
