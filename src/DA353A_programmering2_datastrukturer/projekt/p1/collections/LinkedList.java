/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p1.collections;


import DA353A_programmering2_datastrukturer.labbar.lab7.f7.List;
import DA353A_programmering2_datastrukturer.labbar.lab7.f7.ListNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>, List<E> {
	private ListNode<E> list = null;

	private ListNode<E> locate(int index) {
		ListNode<E> node = list;
		for (int i = 0; i < index; i++)
			node = node.getNext();
		return node;
	}

	public int size() {
		int n = 0;
		ListNode<E> node = list;
		while (node != null) {
			node = node.getNext();
			n++;
		}
		return n;
	}

	public E get(int index) {
		checkIndex(index);

		ListNode<E> node = locate(index);
		return node.getData();
	}

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

	public void add(E data) {
		addLast(data);
	}

	public void addFirst(E data) {
		add(0,data);
	}

	public void addLast(E data) {
		add(size(), data);
	}

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

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size()-1);
	}

	public E remove(int index) {
		checkIndex(index);

		E res;
		if (index == 0) {
			res = list.getData();
			list = setNull(list);
//            list = list.getNext();
		} else {
			ListNode<E> node = locate(index - 1);
			res = node.getNext().getData();
			node.setNext(setNull(node.getNext()));
//            node.setNext( node.getNext().getNext() );
		}
		return res;
	}

	private ListNode<E> setNull(ListNode<E> toNull) {
		ListNode<E> res = toNull.getNext();
		toNull.setData(null);
		toNull.setNext(null);
		return res;
	}

	public void clear() {
		while (size() >0) {
			removeLast();
			System.out.println(list);
		}
	}

	public int indexOf(E data) {
		return 	indexOf(0, data);
	}

	@Override
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


	public Iterator<E> iterator() {
		return new Iter();
	}

	public String toString() {
		if (list != null)
			return list.toString();
		else
			return "[]";
	}

	private class Iter implements Iterator<E> {

		private ListNode<E> lastReturned;
		private ListNode<E> next = list;
		private int nextIndex =0;

		@Override
		public boolean hasNext() {
			return nextIndex<size();
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastReturned = next;
			next = next.getNext();
			nextIndex++;
			return lastReturned.getData();
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}

			ListNode<E> lastNext = lastReturned.getNext();
			setNull(lastReturned);
			if (next == lastReturned)
				next = lastNext;
			else
				nextIndex--;
			lastReturned = null;

		}


//		private ListNode<E> lastReturned;
//		private ListNode<E> next;
//		private int nextIndex;
//
//		public boolean hasNext() {
//			return nextIndex<size();
//		}
//
//		public E next() {
//			if (nextIndex == size()) {
//				throw new NoSuchElementException();
//			}
//			return get(nextIndex++);
//		}
//
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}
	}
}


