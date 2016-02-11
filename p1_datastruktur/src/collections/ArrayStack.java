package collections;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

/**
 * Stack implementation useing a generic array.
 * Created by Sebastian Börebäck on 2016-02-10.
 */
public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	private int size = 0;


	//FILO
	//first in last out

	/**
	 * Contsructor that creates a ArrayStack with an initial capacity.
	 * Not to be confused with size, which is the amount of elements in the stack.
	 * @param capacity the initial capacity of the stack.
	 */
	public ArrayStack(int capacity) {
		elements = (T[]) (new Object[capacity]);
	}

	/**
	 * Add a element to the top of the stack
	 * @param element elementet that is added to the stack
	 */
	public void push(T element) {
		if (size >= elements.length)
			throw new BufferOverflowException();
		elements[size] = element;
		size++;
	}

	/**
	 * Pop the top element of the stack. (remove the top element)
	 * the latest to be added.
	 * @return the poped element.
	 */
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}

	/**
	 * Peek on the next element that will be poped.
	 * @return the next element that will be poped.
	 */
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[size - 1];
	}

	/**
	 * Check if the stack is empty
	 * @return true if the stack is empty.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Get the size of the stack
	 * @return the int size of the stack.
	 */
	public int size() {
		return size;
	}
}