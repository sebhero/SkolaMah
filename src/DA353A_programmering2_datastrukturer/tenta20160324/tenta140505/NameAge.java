/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

import java.util.Comparator;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class NameAge implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		int res = p1.getName().compareTo(p2.getName());
		if (res == 0) {
			return p1.compareTo(p2);
		}
		return res;
	}
}
