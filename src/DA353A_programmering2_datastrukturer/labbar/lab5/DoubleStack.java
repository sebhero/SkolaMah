/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab5;

/**
 * Created by Sebastian Börebäck on 2016-01-26.
 */
public class DoubleStack implements DStack {

	private final Double[] theStack;
	int size = 0;


	public DoubleStack(int capacity) {
		theStack = new Double[capacity];
	}

	@Override
	public void push(Double element) {
		if (size < theStack.length) {
			theStack[size] = element;
			size++;
		}
	}

	@Override
	public Double pop() {
		if (!isEmpty()) {
			--size;
			return theStack[size];
		}
		return null;
	}

	@Override
	public Double peek() {
		return theStack[size-1];
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;

	}

	@Override
	public int size() {
		return size;
	}
}
