/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class LinkedList<E> {
	private ListNode<E> list = null;
	private int size;

	public int size() {
		return size;
	}

	public void addFirst(E el) {
		list = new ListNode<>(el, list);
		size++;
	}

	public E removeFirst() {
		ListNode<E> node = list;
		if (list != null) {

			list = list.getNext();
			size--;
			return node.getData();
		}
		return null;
	}

	public E get(int pos) {
		ListNode<E> node = list;
		int i = 0;
		if (pos >= 0 && pos < size) {
			while (node != null) {

				if (i == pos) {
					return node.getData();
				}

				i++;
				node = node.getNext();
			}

		}
		return null;
	}

	@Override
	public String toString() {
		if (list == null) {
			return "";
		}
		String str = "";

		ListNode<E> node = list;

		while (node != null) {
			str += node.getData() + ", ";
			node = node.getNext();
		}

		return str;
	}

	public static void main(String[] args) {
		LinkedList<Long> longList = new LinkedList<Long>();
		longList.addFirst( new Long(9) );
		longList.addFirst( new Long(4) );
		longList.addFirst( new Long(8) );
		System.out.println( longList.toString() );
		System.out.println(longList.get(-3));
		for(int i=-1; i<=longList.size(); i++) {
			System.out.println(longList.get(i));
		}
		while(longList.size()>0) {
			System.out.println(longList.removeFirst());
		}
		System.out.println(longList.removeFirst());
	}
}
