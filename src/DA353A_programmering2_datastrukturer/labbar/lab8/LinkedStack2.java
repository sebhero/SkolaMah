/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8;


import DA353A_programmering2_datastrukturer.labbar.lab5.Stack;

import java.util.NoSuchElementException;

/**
 * Created by Sebastian Börebäck on 2016-02-02.
 */
public class LinkedStack2<E> implements Stack<E> {



	transient int size = 0;
	transient Node<E> first;
	transient Node<E> last;

	@Override
	public void push(E element) {
		//add as first element
		addFirst(element);
	}

	private void addFirst(E element) {
		//link the first element
		linkFirst(element);
	}

	private void linkFirst(E element) {
		//get the first element
		final Node<E> f = first;
		//create a new node with element
		//null = prev, element data(item) ,f = next
		final Node<E> newNode = new Node<>(null, element, f);
		//set first to new node
		first = newNode;

		//if this is the first item in the stack
		if (f == null) {
			last = newNode;
		} else {
			//if there exist elements in stack add to first prev
			f.prev =newNode;
		}
		size++;


	}

	@Override
	public E pop() {
//		return list.pop();
		//remove the first element in the list.
		return removeFirst();

	}

	/**
	 * Remove the first element
	 * @return the first item
	 */
	private E removeFirst() {
		//get the first element
		final Node<E> f = first;
		//check if there is a element
		if (f == null) {
			throw new NoSuchElementException("There is no elements in stack");
		}
		//do the removal
		return unlinkFirst(f);
	}

	private E unlinkFirst(Node<E> f) {
		//store away the linked item (data)
		final E element = f.item;
		//get next node
		final Node<E> next = f.next;
		//unlik node
		f.item = null;
		f.next = null; //Help GC
		//set first node to next.
		first = next;
		//if first is null last is also null (no elements)
		if (next == null) {
			last = null;
		} else {
			//set nexts prev to null (no linking to this removed element)
			next.prev =null;
		}
		//decrse size and modCount
		size--;
		return element;
	}

	@Override
	public E peek() {
		//get the first element that we will peek on
		final Node<E> f =first;
		//if first is not null return item.
		return (f == null)? null : f.item;

	}

	@Override
	public boolean isEmpty() {
		//true if size == 0
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	public boolean empty() {
		return isEmpty();
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
