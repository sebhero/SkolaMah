/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;
import java.util.Comparator;

public class ReverseComparable<E> implements Comparator<E> {
	public int compare(E o1, E o2) {
		return ((Comparable<E>)o2).compareTo(o1);
	}
}
