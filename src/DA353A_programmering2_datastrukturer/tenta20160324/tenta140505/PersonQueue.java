/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

import java.util.LinkedList;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class PersonQueue {
	private LinkedList<Person> queue = new LinkedList<>();

	public void enqueue(Person person) {
		queue.addLast(person);
	}

	public Person dequeue() {
		return queue.removeFirst();
	}

	public int size() {
		return queue.size();
	}

	public static void main(String[] args) {
		PersonQueue queue = new PersonQueue();
		queue.enqueue( new Person("Ahmed",25) );
		queue.enqueue( new Person("Beata",23) );
		queue.enqueue( new Person("Anna",24) );
		queue.enqueue( new Person("Peter",27) );
		System.out.println( "Element i kön: " + queue.size() );
		while( queue.size() > 0 ) {
			System.out.println( queue.dequeue() );
		}
		System.out.println( "Element i kön: " + queue.size() );
	}
}
