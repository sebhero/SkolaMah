/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2.collections;

import DA353A_programmering2_datastrukturer.labbar.lab13.Map;
import collections.LinkedList;

import java.util.Iterator;


/**
 * Hashtabellen använder öppen hashing
 *
 * @author Rolf Axelsson
 */
public class HashtableOH<K, V> implements Map<K, V> {
	private LinkedList<Entry<K, V>>[] table;
	private int size;

	/**
	 * Creates a new instance of HashtableOH
	 */
	public HashtableOH(int size) {
		table = (LinkedList<Entry<K, V>>[]) new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<Entry<K, V>>();
		}
	}

	private int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}

	/**
	 * Add a key and its connected value to the HashTable
	 * @param key key with which the specified value is connected with.
	 * @param value the value of the connected key
	 * @return the added value
	 */
	public V put(K key, V value) {
		V res = null;
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, value);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			table[hashIndex].addFirst(entry);
			size++;
		} else {
			res = table[hashIndex].set(index, entry).value;
		}
		return res;
	}

	/**
	 * Prints out the list of elements in the hashtable
	 */
	public void list() {
		Entry<K, V> entry;
		for (int i = 0; i < table.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < table[i].size(); j++) {
				entry = table[i].get(j);
				System.out.print(" <" + entry.key + "," + entry.value + ">");
			}
			System.out.println();
		}
	}

	/**
	 * Returns the element at the specified position in the hashtable.
	 *
	 * @param key the key of the element to return.
	 * @return the element at the specified key in the hashtable else null.
	 */
	public V get(K key) {


		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		for (Entry<K, V> item : table[hashIndex]) {
			if (item.key.equals(key)) {
				return item.value;
			}
		}
		return null;
	}

	/**
	 * Removes the mapped key from the hashtable if its present.
	 *
	 * @param key the key for the element to be removed.
	 * @return the value that was associated with the key.
	 */
	public V remove(K key) {

		int counter = 0;
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		for (int i = 0; i < table[hashIndex].size(); i++) {
			if (table[hashIndex].get(i).equals(entry)) {
				Entry<K, V> retVal = table[hashIndex].remove(i);
				return retVal.value;
			}
		}
		return null;
	}

	/***
	 * Get the tree size
	 * @return the size of the tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Check is the tree is empty
	 * @return true if its empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Does the key exist in the hashtable
	 *
	 * @param key the key which we are looking for
	 * @return true if the key is in the hashtable
	 */
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	/**
	 * Clears the hashtables of elements
	 */
	public void clear() {
		for (LinkedList<Entry<K, V>> entries : table) {
			entries.clear();
		}
	}

	/**
	 * Get all the keys
	 * @return a list of all the keys
	 */
	public Iterator<K> keys() {
		LinkedList<K> keys = new LinkedList<>();
		for (LinkedList<Entry<K, V>> item : table) {
			item.forEach(kvEntry -> keys.push(kvEntry.key));
		}
		return keys.iterator();
	}

	/***
	 * Get a list of all the values
	 * @return a list of all the values
	 */
	public Iterator<V> values() {
		LinkedList<V> values= new LinkedList<>();
		for (LinkedList<Entry<K, V>> item : table) {
			item.forEach(kvEntry -> values.push(kvEntry.value));

		}
		return values.iterator();
	}

	public static void main(String[] args) {
		HashtableOH<String, String> table = new HashtableOH<String, String>(4);
		table.put("hej", "hello");
		table.put("röd", "red");
		table.put("vit", "white");
		table.put("säng", "bed");
		table.put("svart", "black");
		table.put("gul", "yellow");
		table.put("dator", "computer");
		table.put("snö", "snow");
		table.put("blå", "blue");
		table.put("grön", "green");
		table.put("hus", "house");
		table.list();

		System.out.println("get: " + table.get("dator"));
//		System.out.println("remove: " + table.remove("dator"));
		System.out.println("size: " + table.size());

		System.out.println("-----KEYS-------------------------");
		Iterator<String> keys = table.keys();
		while (keys.hasNext())
			System.out.println(keys.next());

		System.out.println("-----VALUES-------------------------");
		Iterator<String> values = table.keys();
		while (values.hasNext())
			System.out.println(values.next());
	}
}
