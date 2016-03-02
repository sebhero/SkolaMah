/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab14;

import DA353A_programmering2_datastrukturer.labbar.lab14.forl14.Edge;
import DA353A_programmering2_datastrukturer.labbar.lab14.forl14.Graph;
import DA353A_programmering2_datastrukturer.labbar.lab14.forl14.GraphSearch;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;



public class WFController {
	private Graph<String> graph = new Graph<String>();
	private MapView map;
	private TreeMap<String, Road> roads;

	public WFController(String placeFile, String roadFile, String mapFile) {
		ArrayList<Place> places = WFController.readPlaces(placeFile);

		roads = WFController.readRoads(roadFile);
		ArrayList<Road> roadList = new ArrayList<Road>();
		Iterator<Road> values = roads.values().iterator();
		while (values.hasNext())
			roadList.add(values.next());

		map = new MapView(mapFile, 12.527, 56.346, 14.596, 55.324);
		showMap();

//		map.showRoads(roadList);

	    makeGraph(places, roads); // Uppgift 2
//		graph.printGraph();

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
				int i=0;
				res.put(parts[0] + "-" + parts[1], new Road(parts[0],parts[1], Integer.parseInt(parts[2]), path));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return res;
	}

	public void showMap() {
		JFrame frame = new JFrame("Karta");
		frame.setSize(686, 592);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(map, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	// Uppgift 2
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
			graph.addVertex(place.getName());
		}
		while (values.hasNext()) {
			road = values.next();
			graph.addEdge(road.getFrom(), road.getTo(), road.getCost());
		}
	}

	// Uppgift 3
	public void search1(String from, String to) {

		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		if (graph.containsVertex(from)) {
			path=GraphSearch.depthFirstSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
			}
			map.showRoads(roadList);
		}



	}

	// Uppgift 4
	public void shortestPath(String from, String to) {
		ArrayList<Edge<String>> path = new ArrayList<>();
		ArrayList<Road> roadList = new ArrayList<>();

		if (graph.containsVertex(from)) {
			path = GraphSearch.dijkstraSearch(graph, from, to);
			for (Edge<String> edge : path) {
				roadList.add(roads.get(edge.getFrom() + "-" + edge.getTo()));
			}
			map.showRoads(roadList);
		}
	}

	// Uppgift 5
	public void randomSearch(String from, String to) {

		Random rnd = new Random();

		ArrayList<Road> roadList = new ArrayList<>();
		ArrayList<Edge<String>> allEdges;

		if (graph.containsVertex(from) && graph.containsVertex(to)) {
			while (!from.equals(to)) {
				//get all neigbours to the edge im at
				//all places i can go to
				allEdges = graph.getAdjacentList(from);
				//pick a random edge
				Edge<String> rndEdge = allEdges.get(rnd.nextInt(allEdges.size()));
				//add the drive from where im at to new place.
				roadList.add(roads.get(rndEdge.getFrom() + "-" + rndEdge.getTo()));
				//now im at new place so i go from here!
				from = rndEdge.getTo();
			}
			for (Road road : roadList) {
				System.out.println(road);
			}
			map.showRoads(roadList);
		}
	}


    private void showRoads(Graph<String> graph) {
    	ArrayList<Road> roadList = new ArrayList<Road>();
    	Iterator<Edge<String>> iter = graph.iterator();
    	Edge<String> edge;
    	while(iter.hasNext()) {
    		edge = iter.next();
    		roadList.add(roads.get(edge.getFrom()+"-"+edge.getTo()));
    	}
    	map.showRoads(roadList);
    }
    
	public static void main(String[] args) {
		URL placesPath = WFController.class.getResource("/files/places.txt");
		URL roadsPath = WFController.class.getResource("/files/roads.txt");
		URL imgPath = WFController.class.getResource("/files/skane.jpg");
		WFController controller = new WFController(placesPath.getPath(),
				roadsPath.getPath(), imgPath.getPath());
//		WFController controller = new WFController("files/places.txt",
//				"files/roads.txt", "files/skane.jpg");
		
		controller.search1("Eslöv", "Kristianstad");
//		controller.search1("Kristianstad", "Eslöv");
//		controller.shortestPath("Kristianstad", "Eslöv");
//		controller.shortestPath("Höganäs", "Åhus");
//		controller.randomSearch("Åhus", "Ängelholm");

		// TODO: 2016-03-02 :17:16 UPG 6
		//avkommenterar for upg6
//		String path = javax.swing.JOptionPane.showInputDialog( "Skriv in fran och till ( Malmö, Eslöv )?" );
//		String[] paths = path.split(",");
//		controller.shortestPath(paths[0], paths[1]);
	}
}
