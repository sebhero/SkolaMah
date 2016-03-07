/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * A controller for the Graph and searching in the Graph
 * @author Sebastian Börebäck
 */
public class P2Controller {
	private final ArrayList<Place> places;
	private MainView2 mainView;
	private Graph<String> graph = new Graph<String>();
	private MapView map;
	private TreeMap<String, Road> roads;

	/**
	 * Constructs a controller for handling all communication between view and graph
	 * @param imgPath path to the image
	 * @param mapLeftUp upper left corner of the map
	 * @param mapRightDown lower right corner of the map
	 * @param placesPath the path to the places file
	 * @param roadsPath the path to the roads file
	 */
	public P2Controller(String imgPath, Position mapLeftUp, Position mapRightDown,
	                    String placesPath, String roadsPath) {


		String placeFile = this.getClass().getResource("/" + placesPath).getPath();
		String roadFile = this.getClass().getResource("/" + roadsPath).getPath();
		String mapFile = this.getClass().getResource("/" + imgPath).getPath();


		places = P2Controller.readPlaces(placeFile);
		roads = P2Controller.readRoads(roadFile);
		//create the graph
		makeGraph(places, roads);
		//init the gui
		initGui(mapLeftUp, mapRightDown, mapFile, places);

		ArrayList<Road> roadList = new ArrayList<Road>();
		Iterator<Road> values = roads.values().iterator();
		while (values.hasNext())
			roadList.add(values.next());
		map.showRoads(roadList);



	}

	private void initGui(Position mapLeftUp, Position mapRightDown, String mapFile, ArrayList<Place> places) {
		map = new MapView(mapFile, mapLeftUp.getLongitude(), mapLeftUp.getLatitude(), mapRightDown.getLongitude(), mapRightDown.getLatitude());



		mainView = new MainView2(map, this,places.toArray());

		JFrame frame = new JFrame("P2 Karta");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainView, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();
	}


	public static ArrayList<Place> readPlaces(String filename) {
		ArrayList<Place> places = new ArrayList<Place>();
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
		return places;
	}

	public static TreeMap<String, Road> readRoads(String filename) {
		TreeMap<String, Road> res = new TreeMap<String, Road>();
		ArrayList<Position> path;
		String[] parts;
		String text;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			text = br.readLine();
			while (text != null) {
				path = new ArrayList<Position>();
				parts = text.split(",");
				for (int i = 3; i < parts.length; i += 2) {
					path.add(new Position(Double.parseDouble(parts[i]), Double
							.parseDouble(parts[i + 1])));
				}
				int i = 0;
				res.put(parts[0] + "-" + parts[1], new Road(parts[0], parts[1], Integer.parseInt(parts[2]), path));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return res;
	}

	/**
	 * Creates the graph used for the searching.
	 * connecting roads with the places
	 * @param places the diffrent places
	 * @param roads the diffrent roads between the places
	 */
	public void makeGraph(ArrayList<Place> places, TreeMap<String, Road> roads) {
		// Iterera genom arraylisten places
		// för varje Place-objekt så lägg till platsens namn som en nod
		// i grafen (instansvariabeln graph), ungefär:
		// graph.addVertex(namn)
		// Om du studerar klassen Place hittar du lämplig get-metod för namnet.

		// skapa en Iterator över values (Road-objekt) i roads
		// så länge det finns Road-objekt i Iteratorn
		// lägg till en båge i grafen med addEdge(T from, T to, int
		// cost)-metoden
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

	/***
	 * Do a depthFirst search
	 * @param from from where
	 * @param to to where
	 */
	public void depthFirstSearch(String from, String to) {

		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		if (graph.containsVertex(from)) {
			//does a depthFirst Search for the connection.
			//going down the Graph to find the path
			path = GraphSearch.depthFirstSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
			}
			map.showRoads(roadList);
			mainView.updateMapRoadList(roadList);
		}


	}

	/***
	 * Starts a BreadthFirst Search
	 * @param from from which city
	 * @param to which city
	 */
	public void breadthFirstSearch(String from, String to) {

		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		if (graph.containsVertex(from)) {
			//does a depthFirst Search for the connection.
			//going down the Graph to find the path
			path = GraphSearch.breadthFirstSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
			}
			map.showRoads(roadList);
			mainView.updateMapRoadList(roadList);
		}


	}

	/***
	 * Starts a Dijkstra Search
	 * @param from from which city
	 * @param to which city
	 */
	public void dijkstraSearch(String from, String to) {
		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		if (graph.containsVertex(from)) {
			//Using dijkstraSearch to find the path.
			//which iin our case has a priorityQueue
			//that weight the connection *edges
			//which i it will take the lowest!? (shortest) edge
			// for its next visited
			path = GraphSearch.dijkstraSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
			}
			map.showRoads(roadList);
			mainView.updateMapRoadList(roadList);

		}
	}


}
