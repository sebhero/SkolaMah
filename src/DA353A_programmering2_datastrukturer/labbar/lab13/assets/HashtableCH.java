/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab13.assets;
//import f13.Map;

import DA353A_programmering2_datastrukturer.labbar.lab13.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
//import collections.ArrayList;

/**
 * Hashtabellen använder sluten hashing
 *
 * @author Rolf Axelsson
 **/
public class HashtableCH<K, V> implements Map<K, V> {

	private Bucket<K, V>[] table;
	private int size;
	private int threshold;
	private double loadfactor = 0.7;

	public HashtableCH() {
		this(11);
	}

	public HashtableCH(int size) {
		table = (Bucket<K, V>[]) new Bucket[size];
		threshold = (int) (loadfactor * table.length);
		for (int i = 0; i < table.length; i++) {
			table[i] = new Bucket<K, V>();
		}
	}

	private void grow() {
		Bucket<K, V>[] oldTable = table;
		table = (Bucket<K, V>[]) new Bucket[table.length * 2];
		size = 0;
		threshold = (int) (loadfactor * table.length);
		for (int i = 0; i < table.length; i++) {
			table[i] = new Bucket<K, V>();
		}
		for (int index = 0; index < oldTable.length; index++) {
			if (oldTable[index].state == Bucket.OCCUPIED)
				put(oldTable[index].key, oldTable[index].value);
		}
	}

	private int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}

	public V put(K key, V value) {
		V res = null;
		//kollar ifall vi måste utöka size
		if (size >= threshold) {
			grow();
		}
		//skapa ett hashvärde
		int hashIndex = hashIndex(key), removed = -1;
		//kollar efter ett tomt eller samma key
		//kollar inte ifall alla värden är removed eller occupied. då blir det oändlig loop
		while (table[hashIndex].state != Bucket.EMPTY && !key.equals(table[hashIndex].key)) {
			if (removed == -1 && table[hashIndex].state == Bucket.REMOVED)
				removed = hashIndex;
			//fortsätt titta
			hashIndex++;
			//slutet
			if (hashIndex == table.length)
				hashIndex = 0;
		}
		//när man hittat en key
		//kolla ifall den är upptagen
		if (table[hashIndex].state == Bucket.OCCUPIED) {
			res = table[hashIndex].value;
			table[hashIndex].value = value;
		} else {
			//ifall det är ledigt
			if (removed != -1)
				hashIndex = removed;
			//lägg till den nya värdet
			table[hashIndex].key = key;
			table[hashIndex].value = value;
			table[hashIndex].state = Bucket.OCCUPIED;
			size++;
		}
		return res;
	}

	public Iterator<K> keys() {
		ArrayList<K> keys = new ArrayList<K>();
		for (int i = 0; i < table.length; i++)
			if (table[i].state == Bucket.OCCUPIED)
				keys.add(table[i].key);
		return keys.iterator();
	}

	public void list() {
		System.out.println("Tabellen innehåller " + size() + " element:");
		for (int i = 0; i < table.length; i++)
			System.out.println(i + ": key=" + table[i].key + " value=" + table[i].value + " state=" + table[i].state);
	}

	public V get(K key) {
		/**
		 beräkan pos i tabbeln med hash.
		 while tabel pos är ej emptyu och key ej är samma som tabell pos
		 öka pos
		 if tabel pos är occupied
		 return värdet
		 annars
		 null
		 */
		int hash = hashIndex(key);
		while (table[hash].state != Bucket.EMPTY && table[hash].key != key) {
			hash++;
			if (table[hash].state == Bucket.OCCUPIED) {
				return table[hash].value;
			} else {
				return null;
			}
		}
		return null;
	}

	public V remove(K key) {

		int hash = hashIndex(key);
		while (table[hash].state != Bucket.EMPTY && table[hash].key != key) {
			hash++;
			if (table[hash].state == Bucket.OCCUPIED) {
				V retVal = table[hash].value;
				table[hash].state = Bucket.REMOVED;
				table[hash].value = null;
				table[hash].key = null;
				size--;
				return retVal;

			} else {
				return null;
			}
		}

		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean containsKey(K key) {
//		int hash = hashIndex(key);
//		return (table[hash] != null);
		return get(key) != null;
	}

	public void clear() {
		int tbSize = table.length;

		table = new Bucket[tbSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = new Bucket<K,V>();
		}
	}

	public Iterator<V> values() {
		ArrayList<V> list = new ArrayList<>();
		for (Bucket<K, V> item : table) {
			if (item.state == Bucket.OCCUPIED) {
				list.add(item.value);

			}

		}
		return list.iterator();
	}

	public static void main(String[] args) {
		HashtableCH<String, String> table = new HashtableCH<String, String>(1);
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
		System.out.println("-----KEYS-------------------------");
		Iterator<String> keys = table.keys();
		while (keys.hasNext())
			System.out.println(keys.next());

		System.out.println("get " + table.get("dator"));

		System.out.println("-----Values-------------------------");
		Iterator<String> values = table.values();
		while (values.hasNext())
			System.out.println(values.next());



	}
}

