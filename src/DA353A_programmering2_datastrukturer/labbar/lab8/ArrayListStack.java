/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab8;

import DA353A_programmering2_datastrukturer.labbar.lab5.Stack;
import DA353A_programmering2_datastrukturer.labbar.lab7.f7.ArrayList;

import java.util.EmptyStackException;

/**
 * Created by seb on 2016-02-03.
 */
public class ArrayListStack<E> implements Stack<E> {


	ArrayList<E> list = new ArrayList<E>();

	@Override
	public void push(E element) {
		list.addLast(element);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeLast();
	}

	@Override
	public E peek() {
		//titta po sista
		return list.get(size()-1);
	}

	@Override
	public boolean isEmpty() {
		return (size()==0);
	}

	@Override
	public int size() {
		return list.size();
	}
}
