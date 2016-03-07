/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;


import java.util.Comparator;

/***
 * A prioriyQueue implementation
 * @param <E> the type of element in the Queue
 * @author Sebastian Börebäck
 */
public class PriorityQueue<E> implements Queue<E> {
	private ArrayHeap<PriorityQueueElement<E>> queue;

	/**
	 * Constructs a PriorityQueue with initialCapacity of 20
	 */
	public PriorityQueue() {
		this(20);
	}

	/**
	 * Constructs a PriorityQueue with added capacity
	 * @param initialCapacity the inital capacity
	 */
	public PriorityQueue(int initialCapacity) {
		queue = new ArrayHeap<PriorityQueueElement<E>>(initialCapacity);
	}

	/**
	 * Constructs a PriorityQueue with added capacity and comparator
	 * @param initialCapacity the inital capacity
	 * @param comparator how the elements in the Queue will be compared
	 */
	public PriorityQueue(int initialCapacity, Comparator<E> comparator) {
		queue = new ArrayHeap<PriorityQueueElement<E>>(initialCapacity, new PriorityQueueComparator<E>(comparator));
	}

	/***
	 * Add a element to the Queue
	 * @param data the object to be added
	 */
	public void enqueue(E data) {
		queue.insert(new PriorityQueueElement<E>(data));

	}

	/***
	 * Remove a element from the Queue
	 * @return the removed element
	 */
	public E dequeue() {
		return queue.delete().getElement();
	}

	/**
	 * Returns the next element to be removed
	 * @return the next element to be removed
	 */
	public E peek() {
		return queue.peek().getElement();
	}

	/***
	 * Check if the Queue is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return (queue.size() == 0);
	}

	/**
	 * Return the size of the Queue
	 * @return the int size
	 */
	public int size() {
		return queue.size();
	}
}

/***
 * PriorityQueue element. elements used in the Queue
 * @param <E> the type of element
 */
class PriorityQueueElement<E> implements Comparable<PriorityQueueElement<E>> {
	private static int counter = 1;
	private E element;
	private int order;

	/**
	 * Constructs a new QueueElement
	 * @param element the value in the QueueElement
	 */
	public PriorityQueueElement(E element) {
		this.element = element;
		this.order = counter++;
	}

	/**
	 * Get the element
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Get the element priorityOrder
	 * @return return the priorityOrder
	 */
	public int getOrder() {
		return order;
	}

	/***
	 * Compare the element with another element
	 * @param pqElement other element
	 * @return which element is of higher priority
	 */
	public int compareTo(PriorityQueueElement<E> pqElement) {
		int res = ((Comparable<E>) element).compareTo(pqElement.element);
		if (res == 0)
			res = order - pqElement.order;
		return res;
	}
}

/***
 * Comparator for comparing elements in the queue
 * @param <E> the elements type
 */
class PriorityQueueComparator<E> implements Comparator<PriorityQueueElement<E>> {
	private Comparator<E> comp;

	/***
	 * Constructor with added comparator.
	 * @param comparator of how the elements will be compared
	 */
	public PriorityQueueComparator(Comparator<E> comparator) {
		comp = comparator;
	}

	/***
	 * Compare two elements
	 * @param pqElement1 first element to be compared with
	 * @param pqElement2 seconde element to be compared
	 * @return higher if first element has higher priority
	 */
	public int compare(PriorityQueueElement<E> pqElement1, PriorityQueueElement<E> pqElement2) {
		int res = comp.compare(pqElement1.getElement(), pqElement2.getElement());
		if (res == 0)
			res = pqElement1.getOrder() - pqElement2.getOrder();
		return res;
	}
}
