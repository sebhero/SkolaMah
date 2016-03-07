/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;

/**
 * The Entry element used in the HashTable
 * @param <K> key type
 * @param <V> the value type
 */
class Entry<K,V> {
    K key;
    V value;

	/**
	 * Creates a Entry element
	 * @param key the key of the element
	 * @param value the value of the element
	 */
	public Entry( K key, V value ) {
        this.key = key;
        this.value = value;
    }
    
    // jämför två nycklar, returnerar true om lika

	/**
	 * Checks if two Entry are the same by comparing keys.
	 * @param obj the other Entry
	 * @return true if they are equal.
	 */
    public boolean equals( Object obj ) {
        if( !(obj instanceof Entry) )
            return false;
        Entry<K,V> entry = (Entry<K,V>)obj;
        return key.equals( entry.key );
    }
}
