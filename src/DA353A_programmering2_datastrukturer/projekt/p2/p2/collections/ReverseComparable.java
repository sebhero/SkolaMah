/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;
import java.util.Comparator;

public class ReverseComparable<E> implements Comparator<E> {
	public int compare(E o1, E o2) {
		return ((Comparable<E>)o2).compareTo(o1);
	}

	@Override
	public String toString() {
		return "Ascending Comparable";
	}
}
