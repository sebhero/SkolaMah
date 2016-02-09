/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;



import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * A Arraylist. My implemenation of javas Arraylist
 * @author Sebastian Börebäck
 * @param <E> the type of ArrayList
 */
public class ArrayList<E> implements List<E>, Iterable<E> {
	private E[] elements;
	private int size;

	/**
	 * Increase the size of the array that the Arraylist uses
	 */
	private void grow() {
		E[] temp = Arrays.copyOf(elements, size * 2);
		elements = temp;
	}

	/**
	 * Creates an empty list with default capacity
	 */
	public ArrayList() {
		this(20);
	}

	/**
	 * Creates an empty list with initialized capacity
	 * @param initialCapacity the initial capacity for the list
	 */
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	/**
	 * Add an element on index
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 */
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

	/**
	 * Add a element at the end
	 * @param element element to be appended to this list
	 */
	public void add(E element) {
		add(size,element);
	}

	/**
	 * Add a element at the first position
	 * @param element element to be inserted at the beginning of this list
	 */
	public void addFirst(E element) {
		// Laboration, uppgift 1b
		add(0, element);
	}

	/**
	 * Add a element at the end
	 * @param element element to be appended at the end of this list
	 */
	public void addLast(E element) {
		// Laboration, uppgift 1b
		add(size, element);
	}

	/**
	 * Remove element on index
	 * @param index the index of the element to be removed
	 * @return the removed element
	 */
	public E remove(int index) {
		// Laboration, uppgift 1c
		checkIndex(index);
		E oldValue = elements[index];

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

	/**
	 * Remove the first element
	 * @return the removed element
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Remove the last element
	 * @return the removed element
	 */
	public E removeLast() {
		return remove(size-1);
	}

	/**
	 * Clear the list
	 */
	public void clear() {
		//GC clean up
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size =0;
		elements = (E[])new Object[20];
	}

	/***
	 * Get a element at index
	 * @param index index of the element to return
	 * @return the element on index
	 */
	public E get(int index) {
		checkIndex(index);
		return elements[index];
	}

	/***
	 * Set a element on index. index needs to be the size range
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the old element at position
	 */
	public E set(int index, E element) {
		// Laboration, uppgift 1f
		checkIndex(index);
		E oldValue = elements[index];
		elements[index] = element;
		return oldValue;
	}

	/**
	 * Check if the index is with in range
	 * @param index index of the element
	 */
	private void checkIndex(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("want to put on index: "+index);
	}

	/**
	 * Get index for element
	 * @param element element to search for
	 * @return the index of the element
	 */
	public int indexOf(E element) {
		return indexOf(0, element);
	}

	/**
	 * get element on index with a starting index
	 * @param startIndex the search starts at position startIndex in the list
	 * @param element element to search for
	 * @return the element on the index
	 */
	public int indexOf(int startIndex, E element) {
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

	/**
	 * Return the size of the Arraylist
	 * @return size the size of the Arraylist
	 */
	public int size() {
		return size;
	}

	/**
	 * Prints out the Arraylist as a string
	 * @return String of the Arraylist
	 */
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

	/**
	 * A iterator to be able to iterate the list
	 * @return the list iterator.
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}

	/**
	 * Check if the list is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	/**
	 * Converts the list to a array
	 * @return a array from the Arraylist
	 */
	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	/**
	 * Helper class for iterating through the list.
	 */
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

}
