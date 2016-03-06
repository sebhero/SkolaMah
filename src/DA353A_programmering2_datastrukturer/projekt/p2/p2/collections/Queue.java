/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;

import DA353A_programmering2_datastrukturer.labbar.lab8.forlasning.QueueException;

public interface Queue<E> {
	
    /**
     * Inserts the specified element into this queue.
     * @param data the object to add
     * @throws QueueException if the element cannot be added at this
     *         time due to capacity restrictions
     */
    public void enqueue(E data);
    
    /**
     * Retrieves and removes the head of this queue.
     * @return the head of this queue
     * @throws QueueException if this queue is empty
     */
    public E dequeue();
    
    /**
     * Retrieves, but does not remove, the head of this queue.  
     * @return the head of this queue
     * @throws QueueException if this queue is empty
     */
    public E peek();
    
    
    /**
     * Returns true if this stack contains no elements.
     * @return true if this stack contains no elements
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in this stack
     */
    public int size();
}
