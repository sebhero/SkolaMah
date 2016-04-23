/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140820;

import DA353A_programmering2_datastrukturer.tenta20160324.tenta140505.Person;
import collections.ArrayList;

import java.util.Comparator;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class Upg6 {

	/**
	 * upg6 A
	 * D,B
	 */

	/**
	 * 6 B
	 * size = 3
	 * Malmo
	 * -1
	 */

	/**
	 * 6 C
	 * 5+4+3+2+1 = 15
	 */

	/**
	 * 6 D
	 *            35
	 *      28             41
	 *   26   31        37      42
	 *      29
	 */

	/**
	 * 6 E
	 * 0 1
	 * 1 2
	 * 2 4
	 * 3 8
	 * 1+2+4+8 = 15
	 */

	/***
	 * 6 F
	 * <p>
	 * <p>
	 * A <--> B --> C --> A
	 * -- B--> D
	 */

	public Person get(ArrayList<Person> list, int pos) {
		for (Person person : list) {
			if (person.getAge() == pos) {
				return person;
			}
		}
		return null;
	}


	/**
	 * 39 sandal
	 * 45 strandsko
	 * 41 gumnastiksko
	 * 41 tennissko
	 * this .compareTo other 1...10
	 * g
	 * sa
	 * st
	 * t
	 */


	class TypeAndSize implements Comparator<Shoe>{

		@Override
		public int compare(Shoe s1, Shoe s2) {
			//stallet for 3 if satser om vilken for 1,-1 och 0
			int res = ((Integer) s1.getSize()).compareTo(s2.getSize());
			if (res == 0) {
				return s1.compareTo(s2);
			}
			return res;

		}
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		Upg6 tent = new Upg6();
		list.add(new Person("David",1001));
		list.add(new Person("Catherine",832));
		list.add(new Person("Peter",93));
		list.add(new Person("Anna",204));
		System.out.println("id=93: " + tent.get(list,93));
		System.out.println("id=900: " +tent.get(list,900));
	}


	private class Shoe implements Comparable<Shoe>{

		private int size;
		private String type;

		public Shoe(int size, String type) {
			this.size = size;
			this.type = type;
		}



		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
		public int compareTo(Shoe o) {
			//10...0
			return o.getType().compareTo(type);
		}
	}
}
