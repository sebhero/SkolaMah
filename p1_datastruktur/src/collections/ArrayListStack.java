/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import java.util.EmptyStackException;

/**
 * Stack implementation using a ArrayList.
 * There you can stack elements on it.
 * @author Sebastian Börebäck on 2016-01-26.
 * My implemenation of ArrayList-Stack
 */
public class ArrayListStack<T> implements Stack<T> {

	ArrayList<T> elements;


	/**
	 * create a array of the choosen type of object.
	 */
	public ArrayListStack() {
		elements = new ArrayList<>();
	}


	/**
	 * Push a element to the top of the stack
	 * @param element elementet that you want to push on top of the stack.
	 */
	public void push(T element) {
		//add the new element
		elements.add(element);

	}

	/**
	 * Pop the last element from the stack
	 * @return the poped element
	 */
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		//remove top element from stack
		//and "clear to let GC do its work"
		return elements.remove(elements.size() - 1);
	}

	/**
	 * Peeks on the top element, the next element to pop
	 * @return the top element / next to pop
	 */
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		//returns the top element.
		return elements.get(elements.size()-1);
	}

	/**
	 * Chekc if the Arraylist-stack is empty
	 * @return true if its empty
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	/**
	 * get the size of the Arraylist-stack
	 * @return the size of the stack
	 */
	public int size() {
		return elements.size();
	}


}
