/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;


import java.util.Comparator;

/***
 * ArrayHeap an heap using a array
 * @param <E> the object typ of the ArrayHeap
 */
public class ArrayHeap<E> {
	private E[] list;
	private int size;
	private final Comparator<E> comp;

	/**
	 * Creates a Arrayheap with elements
	 * @param elements the list of elements in the ArrayHeap
	 */
	public ArrayHeap(E[] elements) {
		this.list = elements;
		size = list.length;
		comp = new Comp();
		heapify();
	}

	private void heapify() {
		for (int parent = (size -2)/2; parent >= 0; parent--) {
			siftDown(parent);
		}
	}

	/**
	 * Sorterar en array avtagande 100 -> 0
	 * @param elements list of elements
	 * @param <E> the type of elements
	 */
	public static <E> void sort(E[] elements) {

		ArrayHeap ah = new ArrayHeap(elements, new ReverseComparable<>());

		for (int i = elements.length-1; i >= 0; i--) {
			elements[i] = (E) ah.delete();
		}

	}

	/***
	 * Creats a ArrayHeap with a comparator.
	 * Which then sorts the ArrayHeap depending on the comparator
	 * @param elements the array of elements that will be sorted
	 * @param comparator the order the array will be sorted
	 */
	public ArrayHeap(E[] elements, Comparator comparator) {

		this.list = elements;
		size = elements.length;
		comp = comparator;
		heapify();

	}

	/**
	 * Creates a ArrayHeap with a initial size
	 * @param initialCapacity the initial size
	 */
	public ArrayHeap(int initialCapacity) {
		initialCapacity = Math.max(initialCapacity, 20);
		list = (E[])(new Object[initialCapacity]);
		comp = new Comp();  // Den naturliga sorteringsordningen
	}

	/***
	 * Creates a ArrayHeap with a initial size and gets a Comparator
	 * @param initialCapacity the inital size.
	 * @param comparator the comparator, sorting order.
	 */
	public ArrayHeap(int initialCapacity, Comparator<E> comparator) {
		initialCapacity = Math.max(initialCapacity, 20);
		list = (E[])(new Object[initialCapacity]);
		comp = comparator;  // order by the comparator
	}
	
	private void grow() {
		E[] newList = (E[])(new Object[list.length*2]);
		System.arraycopy(list,0,newList,0,list.length);
		list = newList;
	}
    
    private void siftUp(E value) {
        int position = size;
        int parent = (position-1)/2;
        while(position>0 && comp.compare(value, list[parent])<0) {
            list[position] = list[parent];
            position = parent;
            parent = (position-1)/2;
        }
        list[position] = value;
    }
	
    private void siftDown(int parent) {
        E value = list[parent];
        int child = parent*2+1; // first child
        while(child<size) { // at least one child           
            if((child+1<size) && (comp.compare(list[child], list[child+1])>0)) {
                child++;
            }
            if(comp.compare(value, list[child])>0) {
                list[parent] = list[child];
                parent = child;
                child = parent*2+1;
            } else
                break;
        }
        list[parent] = value;
    }

	/**
	 * Add a new value to the ArrayHeap
	 * @param value the new value
	 */
	public void insert(E value) {
		if(size==list.length)
			grow();
		siftUp(value);
		size++;
	}

	/***
	 * Remove the first element in the ArrayHeap
	 * @return the removed element
	 */
	public E delete() {
		E value = null;
		if(size>0) {
		    value = list[0];
		    list[0] = list[--size];
		    siftDown(0);
		}
		return value;
	}

	/***
	 * Which elements will be removed next.
	 * @return the next removable element
	 */
	public E peek() {
		return (size>0) ? list[0] : null;
	}
	
	public int size() {
		return size;
	}
		
	private class Comp implements Comparator<E> {
		public int compare(E elem1, E elem2) {
			return ((Comparable<E>)elem1).compareTo(elem2);
		}

		@Override
		public String toString() {
			return "Descending Comparable";
		}
	}

	/***
	 * Returns a String of the ArrayHeap
	 * @return a string of the ArrayHeap
	 */
	@Override
	public String toString() {

		String txt;
		txt ="ArrayHeap{" +
				"size=" + size +
				", comp=" + comp +
				'\n'+
				"list= [";

		for (E item : list) {
			if (item != null) {
				txt +=item+", ";
			}
		}
		txt += "]}";

		return txt;
	}
}


