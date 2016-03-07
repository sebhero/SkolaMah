/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;



/***
 * A linkedQueue
 * @param <E> the element type.
 * @author Sebastian Börebäck
 */
public class LinkedQueue<E> implements Queue<E> {

	private int size = 0;

	Node<E> first = null, last = null;

	/**
	 * Inserts the specified element into this queue.
	 * @param data the object to add
	 */
	@Override
	public void enqueue(E data) {

		final Node<E> newNode = new Node<>(null, data, null);

		if (first == null) {
			//set the new node to the first
			first = newNode;
			//makes also the last
			last = first;
		} else {
			//current last next will be the new last
			last.next = newNode;
			//makes the current to the last.
			last = newNode;
		}
		size++;
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * @return the head of this queue
	 * @throws QueueException if this queue is empty
	 */
	@Override
	public E dequeue() {
		Node<E> f = first;
		if (f == null) {
			throw new QueueException("There is no elements in Queue");
		}
		//do the removal
		return unlinkFirst(f);
	}

	private E unlinkFirst(Node<E> f) {
		//get data of the first
		E element = f.item;
		Node<E> tempNode = f;
		//make the first next to first// pop first
		first = f.next;
		tempNode = null; //help gc
		size--;
		return element;

	}

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return the head of this queue
	 * @throws QueueException if this queue is empty
	 */
	@Override
	public E peek() {
		final Node<E> f = first;
		return (f == null) ? null : f.item;
	}

	/**
	 * Returns true if this stack contains no elements.
	 * @return true if this stack contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns the number of elements in this stack.
	 * @return the number of elements in this stack
	 */
	@Override
	public int size() {
		return size;
	}

	/***
	 * A node class used by the linked list.
	 * @param <E> element type
	 * @author Sebastian Börebäck
	 */
	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		/**
		 * Constructs a new node
		 * @param prev the previous node
		 * @param element the element in the node
		 * @param next the next node
		 */
		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
