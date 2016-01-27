/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by Sebastian Börebäck on 2016-01-26.
 */
public class ArrayListStack<T> implements Stack<T> {

	ArrayList<T> elements;


	public ArrayListStack() {
		//create a array of the choosen type of object.
		elements = new ArrayList<>();
	}


	@Override
	public void push(T element) {
		//add the new element
		elements.add(element);

	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		//remove top element from stack
		//and "clear to let GC do its work"
		return elements.remove(elements.size() - 1);
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		//returns the top element.
		return elements.get(elements.size()-1);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public int size() {
		return elements.size();
	}
}
