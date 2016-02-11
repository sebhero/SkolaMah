
/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

/**
 * Created by Sebastian Börebäck on 2016-02-10.
 */
public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	private int size = 0;


	//FILO
	//first in last out

	public ArrayStack(int capacity) {
		elements = (T[]) (new Object[capacity]);
	}

	public void push(T element) {
		if (size >= elements.length)
			throw new BufferOverflowException();
		elements[size] = element;
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[size - 1];
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}
}