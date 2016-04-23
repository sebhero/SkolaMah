/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

import java.util.Comparator;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class VIPQueue {
	public Person[] queue;
	private Comparator comp;
	public int size;


	public VIPQueue(Comparator comp, int cap) {
		this.comp = comp;
		queue = new Person[cap];
	}

	public boolean enqueue(Person person) {
		int pos = 0;
		if (size < queue.length) {
			//leta upp pos
			while (pos < size && comp.compare(queue[pos], person) > 0) {
				pos++;
			}
			for (int i = size; i > pos; i--) {
				queue[i] = queue[i - 1];
			}
			queue[pos] = person;
			size++;
			return true;
		}
		return false;
	}

	public Person dequeue() {
		if (size > 0) {
			return queue[--size];
		}
		return null;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		VIPQueue queue = new VIPQueue(new NameAge(),5);
		System.out.println( queue.enqueue( new Person("Ahmed",25) ) );
		System.out.println( queue.enqueue( new Person("Beata",23) ) );
		System.out.println( queue.enqueue( new Person("Anna",24) ) );
		System.out.println( queue.enqueue( new Person("Bodil",23) ) );
		System.out.println( queue.enqueue( new Person("Greg",24) ) );
		System.out.println( queue.enqueue( new Person("Peter",27) ) );
		System.out.println(queue.queue.length);
		System.out.println( "Element i kön: " + queue.size() );
		while( queue.size() > 0 ) {
			System.out.println( queue.dequeue() );
		}
		System.out.println( queue.dequeue() );
	}
}
