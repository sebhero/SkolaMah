/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/**
 * Action interface used by the binarySearchTree.
 * For diffrent types of traverses.
 * @param <T> the action type.
 */
public interface Action<T> {
	/**
	 * Constructs a new action for traverse
	 * @param value the value in the node.
	 */
    public void action(T value);
}
