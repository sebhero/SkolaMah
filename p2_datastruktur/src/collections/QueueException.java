/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/***
 * A Qeueue exception used for handling error in Queue like LinkedQueue
 */
public class QueueException extends RuntimeException {

	/***
	 * Constructs a QueueException with a given error message
	 * @param message the error message
	 */
    public QueueException(String message ) {
        super( message );
    }
}
