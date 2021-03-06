/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8;


import DA353A_programmering2_datastrukturer.labbar.lab5.Stack;
import DA353A_programmering2_datastrukturer.labbar.lab7.f7.LinkedList;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Sebastian Börebäck on 2016-02-02.
 */
public class LinkedStack<E> implements Stack<E> {

	private LinkedList<E> list = new LinkedList<E>();


	@Override
	public void push(E element) {
		list.add(0,element);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.remove(0);
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.get(0);
	}

	@Override
	public boolean isEmpty() {
		return (list.size()==0);
	}

	@Override
	public int size() {
		return list.size();
	}

	public boolean empty() {
		return isEmpty();
	}
}
