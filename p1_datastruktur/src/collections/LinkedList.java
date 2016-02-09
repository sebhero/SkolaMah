/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;


import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * My Linkedlist implementaiton
 *
 * @author Sebastian Boreback
 * @param <E> generic type
 */
public class LinkedList<E> implements Iterable<E>, List<E> {
	private ListNode<E> list = null;

	/**
	 * Locate a element in the linkedlist
	 * @param index the index of the element
	 * @return element at index
	 */
	private ListNode<E> locate(int index) {
		ListNode<E> node = list;
		for (int i = 0; i < index; i++)
			node = node.getNext();
		return node;
	}

	/**
	 * The size of the list
	 * @return int the size of the list
	 */
	public int size() {
		int n = 0;
		ListNode<E> node = list;
		while (node != null) {
			node = node.getNext();
			n++;
		}
		return n;
	}

	/**
	 * Get element at index
	 * @param index index of the element to return
	 * @return the element data at index
	 */
	public E get(int index) {
		checkIndex(index);

		ListNode<E> node = locate(index);
		return node.getData();
	}

	/**
	 * Set a element at index
	 * @param index index of the element to replace
	 * @param data
	 * @return the old data at index.
	 */
	public E set(int index, E data) {
		checkIndex(index);

		//get the node
		ListNode<E> oldNode = locate(index);
		//get the old data
		E oldData = oldNode.getData();
		//set the new data
		oldNode.setData(data);
		return oldData;
	}

	/**
	 * Add a element at the end of the linkedlist
	 * @param data the data to be added
	 */
	public void add(E data) {
		addLast(data);
	}

	/**
	 * Add a element at the first position
	 * @param data the new data for the position
	 */
	public void addFirst(E data) {
		add(0,data);
	}

	/**
	 * Add a element at the last position
	 * @param data the new data for the position
	 */
	public void addLast(E data) {
		add(size(), data);
	}

	/**
	 * Add data on the index position
	 * @param index index at which the specified element is to be inserted
	 * @param data the data which position we are looking for.
	 */
	public void add(int index, E data) {
		checkIndex(index);

		if (index == 0) {
			list = new ListNode<E>(data, list);
		} else {
			//add on end
			//get last
			ListNode node = locate(index - 1);
			//add new nod with ref to lasts.next
			ListNode newNode = new ListNode(data, node.getNext());
			//set last nod next to new nod
			node.setNext(newNode);

		}
	}

	/**
	 * Check if index is out of bounds
	 * @param index
	 */
	private void checkIndex(int index) {
		if ((index < 0) || (index > size())) {
			throw new IndexOutOfBoundsException("size=" + size() + ", index=" + index);
		}
	}

	/**
	 * Remove the first element in linkedlist
	 * @return the data from the removed element.
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Remove the last element in linkedlist
	 * @return the data from the removed element.
	 */
	public E removeLast() {
		return remove(size()-1);
	}

	/**
	 * Remove the element in linkedlist from index position
	 * @return the data from the removed element.
	 */
	public E remove(int index) {
		checkIndex(index);

		E res;
		if (index == 0) {
			res = list.getData();
			list = setNull(list);
		} else {
			ListNode<E> node = locate(index - 1);
			res = node.getNext().getData();
			node.setNext(setNull(node.getNext()));
		}
		return res;
	}

	/**
	 * Help GC to remove the element in linkedlist
	 * @param toNull the element
	 * @return a Nulled ListNode
	 */
	private ListNode<E> setNull(ListNode<E> toNull) {
		ListNode<E> res = toNull.getNext();
		toNull.setData(null);
		toNull.setNext(null);
		return res;
	}

	/**
	 * Clear the linked list.
	 */
	public void clear() {
		while (size() >0) {
			removeLast();
		}
	}

	/**
	 * Find which position data is on in the Linkedlist
	 * @param data the data we are looking for.
	 * @return the index position
	 */
	public int indexOf(E data) {
		return 	indexOf(0, data);
	}

	/**
	 * Find which position data is on with starting index.
	 * @param startIndex the search starts at position startIndex in the list
	 * @param element element to search for
	 * @return the position of the element is on.
	 */
	public int indexOf(int startIndex, E element) {
		checkIndex(startIndex);
		ListNode<E> current = locate(startIndex);
		int index = startIndex;
		do{
			if (current.getData().equals(element)) {
				return index;
			}
			index++;
			current = current.getNext();
		}while (current.getNext() != null);
		return -1;
	}


	/**
	 * Iterator to be able to iterate over the Linkedlist
	 * @return the iterator for the list.
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}

	/**
	 * Converts the list to a string
	 * @return String of the list.
	 */
	public String toString() {
		if (list != null)
			return list.toString();
		else
			return "[]";
	}

	/**
	 * Helper class for Linkedlist.
	 * So that you can iterate over the list.
	 * used in simple for loops and while iterator.hasnext
	 */
	private class Iter implements Iterator<E> {

		private ListNode<E> lastReturned;
		private ListNode<E> next = list;

		/**
		 * If there is a next in the list
		 * @return true if there is a next element in list
		 */
		@Override
		public boolean hasNext() {
			return (next != null);
		}

		/**
		 * get the data from the next element.
		 * and sets next to next.getNext (which is the next in the list)
		 * @return the data from the next element.
		 */
		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastReturned = next;
			next = next.getNext();
			return lastReturned.getData();
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}

			ListNode<E> lastNext = lastReturned.getNext();
			setNull(lastReturned);
			if (next == lastReturned) {

				next = lastNext;
			}
			lastReturned = null;

		}
	}
}


