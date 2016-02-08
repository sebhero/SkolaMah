/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2016-02-08.
 */
public class Searching {

	public static <E> int binearSearch(ArrayList<E> list, E element) {
		int res = -1, compare, min = 0, max = list.size() - 1, pos;
		Comparable comp = (Comparable)element;
		while( ( min <= max ) && ( res == -1 ) ) {
			pos = (min + max) / 2;
			compare = comp.compareTo( list.get( pos ) );
			System.out.println(MessageFormat.format("pos: {2} ,Checked: {0} and got: {1}", list.get(pos), compare,pos));

			if( compare == 0 )
				res = pos;
			else if( compare < 0 )
				max = pos - 1;
			else
				min = pos + 1;
		}
		return res;
	}

	public static <E> int linearSearch(List<E> list, E element) {
		int res = -1;
		for( int i=0; ( i<list.size()) && ( res == -1 ); i++ ) {
			if( element.equals(list.get(i)) )
				res = i;
		}
		return res;
	}




}
