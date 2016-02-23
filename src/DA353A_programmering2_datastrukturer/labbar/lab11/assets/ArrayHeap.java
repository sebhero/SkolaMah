/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab11.assets;

import java.util.Random;
import java.util.Comparator;


public class ArrayHeap<E> {
	private E[] list;
	private int size;
	private Comparator<E> comp;

	/**
	 * Upg 7b
	 * @param elements
	 */
	public ArrayHeap(E[] elements) {
		this.list = elements;
		size = list.length;
		comp = new Comp();
		heapify();
	}

	/**
	 * 7b
	 * Min heapify
	 */
	private void heapify() {
		for (int parent = (size -2)/2; parent >= 0; parent--) {
			siftDown(parent);
		}
	}

	/**
	 * Sorterar en array avtagande 100 -> 0
	 * @param elements
	 * @param <E>
	 */
	public static <E> void sort(E[] elements) {

		ArrayHeap ah = new ArrayHeap(elements, new ReverseComparable<>());

		for (int i = elements.length-1; i >= 0; i--) {
			elements[i] = (E) ah.delete();
		}

	}

	public ArrayHeap(E[] elements, Comparator comparator) {

		this.list = elements;
		size = elements.length;
		comp = comparator;
		heapify();

	}

	public ArrayHeap(int initialCapacity) {
		initialCapacity = Math.max(initialCapacity, 20);
		list = (E[])(new Object[initialCapacity]);
		comp = new Comp();  // Den naturliga sorteringsordningen
	}

	public ArrayHeap(int initialCapacity, Comparator<E> comparator) {
		initialCapacity = Math.max(initialCapacity, 20);
		list = (E[])(new Object[initialCapacity]);
		comp = comparator;  // ordning enligt argumentet comparator
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
	
	public void insert(E value) {
		if(size==list.length)
			grow();
		siftUp(value);
		size++;
	}
	
	public E delete() {
		E value = null;
		if(size>0) {
		    value = list[0];
		    list[0] = list[--size];
		    siftDown(0);
		}
		return value;
	}
	
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
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] values = new Integer[200];
		for(int i=0; i<values.length; i++) 
			values[i] = random.nextInt(900)+100;
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10);
//		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10, new ReverseComparable<Integer>());
		for(Integer i : values)
			heap.insert(i);
		while(heap.size()>0) {
			System.out.print(heap.delete()+" ");
		}
		System.out.println();
		
	}
}


