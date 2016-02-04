/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p1.collections;



import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;
	
	private void grow() {
//		chars = Arrays.copyOf(chars,chars.length*2);
		E[] temp = Arrays.copyOf(elements, size * 2);
		elements = temp;
	}
	
	public ArrayList() {
		this(20);
	}
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	public void add(E element) {
		add(size,element);
	}

	public void addFirst(E element) {
		// Laboration, uppgift 1b
		add(0, element);
	}

	public void addLast(E element) {
		// Laboration, uppgift 1b
		add(size, element);
	}

	public E remove(int index) {
		// Laboration, uppgift 1c
		checkIndex(index);
		E oldValue = elements[index];

//		for (int i = index; i+1 < elements.length; i++) {
//			elements[i] = elements[i + 1];
//		}

		//from arraylist
		int numMoved=size - index - 1;
		/**
		if
			size = 4
			index = 1
		then 4 - 1 - 1 = 2
		 */
		if (numMoved > 0) {
			//move all the object down from index to
			/**
			 * numMoved = 1
			 * index = 1
			 * index + 1 = 2
			 * 1,2,(3),4 remove 2 =>
			 * src start    = 2 (3) index +1
			 * dest post    = 1 (2) index
			 * length       = 2  numMoved
			 */
			System.arraycopy(elements, index+1, elements, index,
					numMoved);
		}
		//remove the element and sets that last element is null.
		/**
		 * sets elements[size] = null (4)
		 * then size = size - 1
		 */
		elements[--size] = null; // clear to let GC do its work

		return oldValue;
	}

	public E removeFirst() {
		// Laboration, uppgift 1d
		return remove(0);
	}

	public E removeLast() {
		// Laboration, uppgift 1d
		return remove(size-1);
	}

	public void clear() {
		// Laboration, uppgift 1g
		//GC clean up
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size =0;
	}

	public E get(int index) {
		// Laboration, uppgift 1e
		checkIndex(index);
		return elements[index];
	}

	public E set(int index, E element) {
		// Laboration, uppgift 1f
		checkIndex(index);
		E oldValue = elements[index];
		elements[index] = element;
		return oldValue;
	}

	private void checkIndex(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
	}

	public int indexOf(E element) {
		// Laboration, uppgift 1i
		return indexOf(0, element);
	}

	public int indexOf(int startIndex, E element) {
		// Laboration, uppgift 1h
		if (element == null) {
			for (int i = startIndex; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = startIndex; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		//not found
		return -1;
	}

	public int size() {
		// Laboration, uppgift 1j
		return size;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	public Iterator<E> iterator() {
		return new Iter();
//		return new Iterator<E>() {
//			private int index=0;
//			
//			public boolean hasNext() {
//				return index<size;
//			}
//			
//			public E next() {
//				if(index==size)
//					throw new NoSuchElementException();
//				return elements[index++];
//			}
//			
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	private class Iter implements Iterator<E> {
		private int index=0;
		
		public boolean hasNext() {
			return index<size;
		}
		
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=10; i<100; i+=10) {
			list.add(i);
		}
		System.out.println(list);
		Iterator<Integer> numbers = list.iterator();
		while(numbers.hasNext())
			System.out.print(numbers.next()+ " ");
	}
}
