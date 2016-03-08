/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.presenter;

import p2.model.GraphModel;
import p2.view.MainView;

/**
 * A Presenter for model and view. connecting the view and the model
 * @author Sebastian Börebäck on 2016-03-08.
 */
public interface P2Presenter {

	/**
	 * Returns the current view
	 * @return the current view
	 */
	MainView getView();

	/**
	 * Set which view to use
	 * @param view the view to use
	 */
	void setView(MainView view);

	/**
	 * Start the program
	 */
	void run();

	/**
	 * Get the current model
	 * @return the model
	 */
	GraphModel getModel();

	/**
	 * Set the model
	 * @param model the model
	 */
	void setModel(GraphModel model);

	/**
	 * Initiate a search for a path between from and to
	 */
	void search();
}
