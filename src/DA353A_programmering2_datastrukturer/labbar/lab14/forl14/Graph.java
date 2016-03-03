/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab14.forl14;

import java.util.*;

/**
 * Klassen representerar en graf
 *
 * @param <T> Nodens typ i grafen
 * @author tsroax
 */
public class Graph<T> {
	private HashMap<T, ArrayList<Edge<T>>> graph = new HashMap<T, ArrayList<Edge<T>>>();

	/**
	 * Lägger till en nod i grafen.
	 *
	 * @param vertex
	 */
	public void addVertex(T vertex) {
		//create the places for the diffrent stader
		graph.put(vertex, new ArrayList<Edge<T>>());
	}

	/**
	 * Lägger till en nod, och nodens närliggande grannar, i grafen.
	 *
	 * @param vertex       nod som läggs till i grafen
	 * @param adjacentList lista med nodens närliggande grannar
	 */
	public void addVertex(T vertex, ArrayList<Edge<T>> adjacentList) {
		if (adjacentList != null && !graph.containsKey(vertex)) {
			graph.put(vertex, adjacentList);
		}
	}

	/**
	 * Lägger till en båge i grafen.
	 *
	 * @param from   nod där bågen startar
	 * @param to     nod till vilken bågen leder
	 * @param weight bågens vikt/kostnad
	 * @return true om bågen läggs till i grafen, annars false
	 */
	public boolean addEdge(T from, T to, int weight) {
		ArrayList<Edge<T>> adjacentList;
		Edge<T> edge;
		int index;
		//check that the cities exists first
		boolean res = graph.containsKey(from) && graph.containsKey(to);
		if (res) {
			//get the from pos
			adjacentList = graph.get(from);
			//creats a connection *edge
			edge = new Edge<T>(from, to, weight);
			//get the index of connection between the cities
			index = adjacentList.indexOf(edge);
			//if the connection exists update it (below true)
			if (index >= 0) {
				//In our case Never called
				adjacentList.set(index, edge);
			} else {
				//city connections doesnt exist. add it!
				//only called in our case
				adjacentList.add(edge);
			}
		}
		return res;
	}

	/**
	 * Tar bort en nod ur grafen.
	 *
	 * @param vertex nod som ska tas bort
	 * @return nodens närliggande grannar om noden tas bort, annars null
	 */
	public ArrayList<Edge<T>> removeVertex(T vertex) {
		return graph.remove(vertex);
	}

	/**
	 * Tar bort en båge ur grafen.
	 *
	 * @param from startnod för bågen
	 * @param to   nod dit bågen leder
	 * @return true om bågen tas bort och annars false
	 */
	public boolean removeEdge(T from, T to) {
		ArrayList<Edge<T>> adjacentList = graph.get(from);
		if (adjacentList != null) {
			return adjacentList.remove(new Edge<T>(from, to, 0));
		}

		return false;
	}

	/**
	 * Returnerar en lista över närliggande grannar till argumentet <code>vertex<\code>
	 *
	 * @param vertex nod till vilken lista över närliggande grannar returneras
	 * @return lista med närliggande grannar
	 */
	public ArrayList<Edge<T>> getAdjacentList(T vertex) {
		return graph.get(vertex);
	}

	/**
	 * Returnerar true om en nod finns i grafen och annars false-
	 *
	 * @param vertex nod som söks i grafen
	 * @return true om noden finns i grafen, annars false
	 */
	public boolean containsVertex(T vertex) {
		return graph.containsKey(vertex);
	}

	/**
	 * Returnerar referens till Edge-objekt med start i from och slut i to.
	 * Om sådan inte finns returneras null.
	 *
	 * @param from nod där bågen startar
	 * @param to   nod där bågen slutar
	 * @return referens till Edge-objektet om det finns, annars null
	 */
	public Edge<T> getEdge(T from, T to) {
		ArrayList<Edge<T>> adjacentList = graph.get(from);
		Edge<T> edge = null;
		int index = -1;
		if (adjacentList != null) {
			index = adjacentList.indexOf(new Edge<T>(from, to, 0));
			if (index != -1) {
				edge = adjacentList.get(index);
			}
		}
		return edge;
	}


	/**
	 * Creates a big arraylist.iterator of all the edges.
	 * @return
	 */
	public Iterator<Edge<T>> iterator() {
		ArrayList<Edge<T>> list = new ArrayList<Edge<T>>();
		Iterator<ArrayList<Edge<T>>> iter = graph.values().iterator();
		while (iter.hasNext()) {
			list.addAll(iter.next());
		}
		return list.iterator();
	}

	public void shuffleEdges() {
		Iterator<T> keys = graph.keySet().iterator();
		Object key;
		while (keys.hasNext()) {
			key = keys.next();
			Collections.shuffle(graph.get(key));
		}
	}

	public void printGraph() {
		Iterator<T> vertices = graph.keySet().iterator();
		T vertex;
		while (vertices.hasNext()) {
			System.out.println("-----------------------------------------------");
			vertex = vertices.next();
			System.out.println(vertex);
			for (Edge edge : graph.get(vertex))
				System.out.println("   " + edge);
			System.out.println("-----------------------------------------------");
		}
	}
}
