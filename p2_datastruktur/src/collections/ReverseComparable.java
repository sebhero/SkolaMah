/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;
import java.util.Comparator;

/**
 * Compare the elements in reverse order
 * @param <E> the type of element for the comparing
 * @author Sebastian Börebäck
 */
public class ReverseComparable<E> implements Comparator<E> {
	/***
	 * Constructor for comaparing 2 elements
	 * @param o1 first element
	 * @param o2 second element
	 * @return which of the element is better
	 */
	public int compare(E o1, E o2) {
		return ((Comparable<E>)o2).compareTo(o1);
	}

	/***
	 * Prints out what type of compare this is.
	 * (Ascending)
	 * @return a string of the type
	 */
	@Override
	public String toString() {
		return "Ascending Comparable";
	}
}
