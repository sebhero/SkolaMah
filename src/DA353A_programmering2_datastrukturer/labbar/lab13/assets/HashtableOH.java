/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab13.assets;

import java.util.Iterator;
import java.util.LinkedList;

import DA353A_programmering2_datastrukturer.labbar.lab13.Map;
//import DA353A_programmering2_datastrukturer.projekt.p1.collections.ArrayList;
//import DA353A_programmering2_datastrukturer.projekt.p1.collections.LinkedList;
//import f13.Map;
//import collections.LinkedList;
//import collections.ArrayList;

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

	public int size() {
//		int count = 0;
//		for (LinkedList<Entry<K, V>> entries : table) {
//			count += entries.size();
//		}
//		return count;
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public void clear() {
		for (LinkedList<Entry<K, V>> entries : table) {
			entries.clear();
		}
	}

	public Iterator<K> keys() {



		LinkedList<K> keys = new LinkedList<>();
		for (LinkedList<Entry<K, V>> item : table) {
			item.forEach(kvEntry -> keys.push(kvEntry.key));
//			Iterator<Entry<K, V>> itr = item.iterator();
//
//			while (itr.hasNext()) {
//				keys.add(itr.next().key);
//			}

		}
		return keys.iterator();
	}

	public Iterator<V> values() {
		LinkedList<V> values= new LinkedList<>();
		for (LinkedList<Entry<K, V>> item : table) {
			item.forEach(kvEntry -> values.push(kvEntry.value));
//			Iterator<Entry<K, V>> itr = item.iterator();
//
//			while (itr.hasNext()) {
//				keys.add(itr.next().key);
//			}

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
