/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.model;

import p2.model.roffe.Place;
import p2.model.roffe.Road;
import p2.shared.SEARCHTYPE;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * A graph model for handeling generating and creating graphs between places.
 *
 * @author Sebastian Börebäck on 2016-03-08.
 */
public interface GraphModel {


	/**
	 * Get the list of places
	 *
	 * @return a array of all the places
	 */
	Place[] getPlaces();

	/**
	 * Set from where you want to go from
	 *
	 * @param from the name of the places you going from.
	 */
	void setFrom(String from);

	/**
	 * * Set to where you want too go to
	 *
	 * @param to the name of the places you going to.
	 */
	void setTo(String to);

	/**
	 * Set which Search algorithm you want to use.
	 *
	 * @param searchAlgorithm the search algorithm name
	 */
	void setSearchAlgorithm(SEARCHTYPE searchAlgorithm);

	/**
	 * Find all the roads for a search
	 */
	void findRoads();

	/**
	 * Get the found rouds from a search.
	 *
	 * @return a list of all the found roads
	 */
	ArrayList<Road> getFoundRoads();

	/**
	 * Create a new graph. Where you need to apply a place txt file for all the places (nodes)
	 * and connection between them (a roads txt file)
	 *
	 * @param placesPath a txt file with all the places in the Graph
	 * @param roadsPath  a txt file of all the roads between the places
	 * @throws FileNotFoundException throws file not found exception if the files are able to be loaded.
	 */
	void makeGraph(String placesPath, String roadsPath) throws FileNotFoundException;
}
