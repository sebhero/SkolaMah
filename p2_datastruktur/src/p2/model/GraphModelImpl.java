/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.model;

import p2.model.roffe.*;
import p2.shared.SEARCHTYPE;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * A implementation of the GraphModel
 *
 * @author Sebastian Börebäck on 2016-03-08.
 */
public class GraphModelImpl implements GraphModel {
	private ArrayList<Place> places;
	TreeMap<String, Road> roads;
	private final Graph<String> graph = new Graph<>();
	private String from;
	private String to;
	private SEARCHTYPE searchAlgorithm;
	private ArrayList<Road> foundRoads;


	/**
	 * Get the list of places
	 *
	 * @return a array of all the places
	 */
	public Place[] getPlaces() {
		return places.toArray(new Place[places.size()]);
	}


	/**
	 * Set from where you want to go from
	 *
	 * @param from the name of the places you going from.
	 */
	@Override
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * * Set to where you want too go to
	 *
	 * @param to the name of the places you going to.
	 */
	@Override
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Set which Search algorithm you want to use.
	 *
	 * @param searchAlgorithm the search algorithm name
	 */
	@Override
	public void setSearchAlgorithm(SEARCHTYPE searchAlgorithm) {
		this.searchAlgorithm = searchAlgorithm;
	}

	/**
	 * Find all the roads for a search
	 */
	@Override
	public void findRoads() {
		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		//If the from doesn exist
		if (!graph.containsVertex(from)) {
			return;
		}

		switch (searchAlgorithm) {

			case DIJKSTRA:
				path = GraphSearch.dijkstraSearch(graph, from, to);
				break;
			case BREADTH:
				path = GraphSearch.breadthFirstSearch(graph, from, to);
				break;
			case DEPTH:
				path = GraphSearch.depthFirstSearch(graph, from, to);
				break;
		}

		//create the Arraylist of found roads using lambda
		/**
		 for (Edge<String> edge : path) {
		 roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
		 }
		 */
		roadList.addAll(path.stream().map(edge -> roads.get(edge.getFrom() + "-" + edge.getTo())).collect(Collectors.toList()));

		this.setFoundRoads(roadList);
	}

	/**
	 * Get the found rouds from a search.
	 *
	 * @return a list of all the found roads
	 */
	@Override
	public ArrayList<Road> getFoundRoads() {
		return foundRoads;
	}

	private void loadPlaces(String placesPath) throws FileNotFoundException {

		String filename;
		try {
			filename = this.getClass().getResource("/" + placesPath).getPath();

		} catch (Exception e) {
			System.err.println("Couldnt load Place file");
			System.out.println();

			throw new FileNotFoundException("Couldnt Read Place file: " + placesPath + "\n\n" + e.getStackTrace());
		}

		places = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			String[] parts;
			double longitude, latitude;
			String text = br.readLine();
			while (text != null) {
				parts = text.split(" ");
				longitude = Double.parseDouble(parts[2]);
				latitude = Double.parseDouble(parts[1]);
				places.add(new Place(parts[0], longitude, latitude));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private void loadRoads(String roadsPath) throws FileNotFoundException {

		String filename;
		try {
			filename = this.getClass().getResource("/" + roadsPath).getPath();

		} catch (Exception e) {
			throw new FileNotFoundException("Couldnt Read Roads file: " + roadsPath + "\n\n" + e.getStackTrace());
		}

		TreeMap<String, Road> res = new TreeMap<>();
		ArrayList<Position> path;
		String[] parts;
		String text;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			text = br.readLine();
			while (text != null) {
				path = new ArrayList<>();
				parts = text.split(",");
				for (int i = 3; i < parts.length; i += 2) {
					path.add(new Position(Double.parseDouble(parts[i]), Double
							.parseDouble(parts[i + 1])));
				}
				res.put(parts[0] + "-" + parts[1], new Road(parts[0], parts[1], Integer.parseInt(parts[2]), path));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		roads = res;

		//Using Lambda instead of while loop to fill the roadList and setFoundRoads
		/**
		 ArrayList<Road> roadList = new ArrayList<Road>();
		 Iterator<Road> values = roads.values().iterator();
		 while (values.hasNext())
		 roadList.add(values.next());
		 */
		setFoundRoads(roads.values().stream().collect(Collectors.toCollection(ArrayList::new)));
	}


	/**
	 * Create a new graph. Where you need to apply a place txt file for all the places (nodes)
	 * and connection between them (a roads txt file)
	 *
	 * @param placesPath a txt file with all the places in the Graph
	 * @param roadsPath  a txt file of all the roads between the places
	 * @throws FileNotFoundException throws file not found exception if the files are able to be loaded.
	 */
	@Override
	public void makeGraph(String placesPath, String roadsPath) throws FileNotFoundException {
		//load the places and roads from the files
		loadPlaces(placesPath);
		loadRoads(roadsPath);

		//start generateing the graph
		Iterator<Road> values = roads.values().iterator();
		Road road;
		for (Place place : places) {
			//for all the places add the place name to the graph
			//creates the places in the graph
			graph.addVertex(place.getName());
		}
		while (values.hasNext()) {
			//add the weight between the places
			road = values.next();
			graph.addEdge(road.getFrom(), road.getTo(), road.getCost());
		}
	}

	private void setFoundRoads(ArrayList<Road> foundRoads) {
		this.foundRoads = foundRoads;
	}
}
