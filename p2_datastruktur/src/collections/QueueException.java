/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package collections;

/***
 *
 */
public class QueueException extends RuntimeException {
//    public QueueException() {}

	/***
	 * Constructs a QueueException with a given error message
	 * @param message the error message
	 */
    public QueueException(String message ) {
        super( message );
    }
}
