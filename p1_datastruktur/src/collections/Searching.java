/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Searching Implements Binarysearch Algorithm and Linearseach algorithm.
 * Used for searching through Arraylist using binarysearch and
 * linearseach for searching though classes implementing the List interface.
 * @author Sebastian Börebäck on 2016-02-08.
 */
public class Searching {

	/**
	 * BinaySearch search through a list using binary search
	 * @param list the list im searching through
	 * @param element the element im looking for
	 * @param <E> the list is generic
	 * @return int the index of element
	 */
	public static <E> int binarySearch(ArrayList<E> list, E element) {
		int res = -1, compare, min = 0, max = list.size() - 1, pos;
		Comparable comp = (Comparable)element;
		while( ( min <= max ) && ( res == -1 ) ) {
			pos = (min + max) / 2;
			compare = comp.compareTo( list.get( pos ) );
			if (compare == 0) {
				res = pos;
			}
			else if (compare < 0)
				max = pos - 1;
			else
				min = pos + 1;
		}
		return res;
	}

	/**
	 * LinearSearch searching through a list using linear search
	 * @param list the list im searching through
	 * @param element the element im looking for
	 * @param <E> the list is generic
	 * @return int the index of element
	 */
	public static <E> int linearSearch(List<E> list, E element) {
		int res = -1;
		for( int i=0; ( i<list.size()) && ( res == -1 ); i++ ) {
			if (element.equals(list.get(i))) {
				 res = i;
			}

		}
		return res;
	}

}
