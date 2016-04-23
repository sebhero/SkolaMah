/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

import java.util.Arrays;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private boolean hashCount =false;
	private int hash;


	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (name != person.getName()) {
			return false;
		}

		if (age != person.age) return false;

		if (age == person.getAge() && name == person.getName()) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {

		if (hashCount == false) {

			hash = this.getName().hashCode()+age;
			this.hashCount=true;
		}
		return hash;


	}

	public static void main(String[] args) {

		Person p1 = new Person("Ahmed", 25);
		Person p2 = new Person("Ahmed", 23);
		Person p3 = new Person("Beata", 25);
		Person p4 = new Person("Beata", 23);
		Person p5 = new Person("Ahmed", 25);
		System.out.println(p1.equals(null));
		System.out.println(p1.equals("Hejsan"));
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p4));
		System.out.println(p1.equals(p5));

		Person[] persons = {new Person("Ahmed", 25), new Person("Beata", 23),
				new Person("Anna", 24), new Person("Peter", 27)};
		Arrays.sort(persons);
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].toString());
		}

		System.out.println("age compare");

		Person[] persons2 = { new Person("Ahmed",25), new Person("Beata",23),
				new Person("Ahmed",24), new Person("Beata",27)};
		Arrays.sort( persons2, new NameAge() );
		for( int i = 0; i < persons2.length; i++ ) {
			System.out.println( persons2[ i ].toString() );
		}
	}

	@Override
	public int compareTo(Person otherP) {
		if (this.age == otherP.getAge()) {
			return 0;
		}
		//OM 1...10 THEN THIS IS > THAN OTHER
		//IF 10..1 THEN THIS IS < THAN OTHER
		if (this.age > otherP.getAge()) {
			return 1;
		} else {
			return -1;
		}
	}
}
