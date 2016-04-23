/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140820;

import DA353A_programmering2_datastrukturer.labbar.lab11.assets.Filter;
import DA353A_programmering2_datastrukturer.tenta20160324.tenta140505.Person;
import collections.LinkedList;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class MemberQueue {
	private LinkedList<Person> queue = new LinkedList<>();

	public void enqueue(Person member) {
		queue.addLast(member);
	}

	public Person dequeue() {
		if (empty()) {
			return null;
		}
		return queue.removeFirst();
	}

	public boolean empty() {
		return queue.size() == 0;
	}

	public Person peek() {
		if (empty()) {
			return null;
		}
		return queue.get(0);
	}

	public void moveToEnd(Filter<Person> filter) {
		for (int i = 0; i < queue.size(); i++) {
			Person p = queue.get(i);
			if (filter.accept(p)) {
				queue.remove(i);
				enqueue(p);
			}
		}
	}



	public static void main(String[] args) {
		MemberQueue q = new MemberQueue();
		System.out.println( "Inga medlemmar i kön: " + q.empty() );
		System.out.println( "Först i kön: " + q.peek() );
		System.out.println( "Ta bort först i kön: " + q.dequeue() );
		q.enqueue( new Person("Alf",8670) );
		q.enqueue( new Person("Edit",235) );
		q.enqueue( new Person("Anna",789) );
		q.enqueue( new Person("Zero",42) );
		q.enqueue( new Person("Vilda",4564) );
		q.enqueue( new Person("Ronja",4622) );
		System.out.println( "Inga medlemmar i kön: " + q.empty() );
		System.out.println( "Först i kön: " + q.peek() );
//		while( !q.empty() ) {
//			System.out.println( "Ta bort först i kön: " + q.dequeue() );
//		}
//		System.out.println("Inga medlemmar i kön: " + q.empty() );
		q.moveToEnd( new LessThan( 400 ) );
		while( !q.empty() ) {
			System.out.println( q.dequeue() );
		}
	}

	private static class LessThan implements Filter<Person> {
		private final int limit;

		public LessThan(int limit) {
			this.limit = limit;
		}

		@Override
		public boolean accept(Person element) {
			return element.getAge() < limit;
		}
	}
}
