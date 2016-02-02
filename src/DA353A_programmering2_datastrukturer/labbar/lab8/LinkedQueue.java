/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8;

import DA353A_programmering2_datastrukturer.labbar.lab8.forlasning.Queue;
import DA353A_programmering2_datastrukturer.labbar.lab8.forlasning.QueueException;

/**
 * Created by Sebastian Börebäck on 2016-02-02.
 */
public class LinkedQueue<E> implements Queue<E> {

	//	private E[] elements;
	private int size = 0;

	Node<E> first = null, last = null;


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

	@Override
	public E peek() {
		final Node<E> f = first;
		return (f == null) ? null : f.item;
	}

	@Override
	public boolean isEmpty() {
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
