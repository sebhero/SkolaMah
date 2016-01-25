/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab4;

import DA353A_programmering2_datastrukturer.labbar.lab4.packages.Person;

import java.util.Comparator;

/**
 * Created by Sebastian Börebäck on 2016-01-25.
 */
public class LastnameAsc implements Comparator<Person>{
	@Override
	public int compare(Person p1, Person p2) {
		String last_1 = p1.getLastname();
		String last_2 = p2.getLastname();
		return last_1.compareTo(last_2);

	}
}
