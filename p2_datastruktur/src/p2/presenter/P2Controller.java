/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.presenter;

import p2.model.GraphModel;
import p2.model.GraphModelImpl;
import p2.model.roffe.Position;
import p2.view.MainView;
import p2.view.MainViewImpl;

import java.io.FileNotFoundException;

/**
 * Implemntation of the P2Persenter interface
 * Used for presenting the Application P2
 * @author  by Sebastian Börebäck on 2016-03-08.
 */
public class P2Controller implements P2Presenter {

	MainView view;
	GraphModel model;

	/**
	 * Constructs a P2 presenter (not really a controller)
	 * since im Using MVP.
	 * Taking the image file path, roads file path, places file path
	 * and the upper left cords, lower right cords
	 * Then it creates the View and Model and runs the app.
	 *
	 * @param imgPath the image file path
	 * @param mapLeftUp the upper left cords
	 * @param mapRightDown the lower right cords
	 * @param placesPath the places file path
	 * @param roadsPath the roads file path
	 */
	public P2Controller(String imgPath, Position mapLeftUp, Position mapRightDown,
	                    String placesPath, String roadsPath) {

		//normally done before/outside.
		setModel(new GraphModelImpl());
		try {
			setView(new MainViewImpl(imgPath, mapLeftUp, mapRightDown));
			initModel(placesPath, roadsPath);
		} catch (FileNotFoundException e) {

			//exit the app if file load fails
			e.printStackTrace();
			view.close();
			System.exit(0);
		}

		//normally done before/outside
		run();

	}

	private void initModel(String placesPath, String roadsPath) throws FileNotFoundException {
		model.makeGraph(placesPath, roadsPath);
	}

	/**
	 * Start the program
	 */
	@Override
	public void run() {

		view.setPresenter(this);
		view.setPlaces(model.getPlaces());
		view.updateViewFromModel();
		view.open();

	}

	/**
	 * Returns the current view
	 * @return the current view
	 */
	@Override
	public MainView getView() {
		return this.view;
	}

	/**
	 * Set which view to use
	 * @param view the view to use
	 */
	@Override
	public void setView(MainView view) {
		this.view = view;
	}

	/**
	 * Get the current model
	 * @return the model
	 */
	@Override
	public GraphModel getModel() {
		return this.model;
	}

	/**
	 * Set the model
	 * @param model the model
	 */
	@Override
	public void setModel(GraphModel model) {
		this.model = model;
	}

	/**
	 * Initiate a search for a path between from and to
	 */
	@Override
	public void search() {
		view.updateModelFromView();
		//TODO error check
		model.findRoads();
		view.updateViewFromModel();

	}


}

