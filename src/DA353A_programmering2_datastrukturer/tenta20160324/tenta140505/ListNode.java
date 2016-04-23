/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.tenta20160324.tenta140505;

/**
 * Created by Sebastian Börebäck on 2016-03-23.
 */
public class ListNode<E> {
	private E data;
	private ListNode next;

	public ListNode(E data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}

