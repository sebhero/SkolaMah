/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * A list node model. used for linkedlist
 * @param <E>
 * @author Sebastian Boreback
 */
public class ListNode<E> {
    private E data;
    private ListNode<E> next;

	/**
	 * Constructor for the listnode.
	 * @param data the data at the node
	 * @param next the next in the Linkedlist
	 */
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }

	/**
	 * Gets the data from listnode
	 * @return the data from the listnode
	 */
	public E getData() {
        return this.data;
    }

	/**
	 * Set the data on listnode
	 * @param data
	 */
	public void setData( E data ) {
        this.data = data;
    }

	/**
	 * Get the next from the listnode
	 * @return the next of the listnode
	 */
	public ListNode<E> getNext() {
        return this.next;
    }

	/**
	 * Set the next of the listnode
	 * @param next element that should be next
	 */
	public void setNext( ListNode<E> next ) {
        this.next = next;
    }

	/**
	 * Convert listnode to a string
	 * @return a string of the listnode object
	 */
	public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ListNode<E> node = next;
        while( node!=null ) {
        	str.append( "; ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
}