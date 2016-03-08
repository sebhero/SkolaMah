/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.view;

import p2.model.roffe.Place;
import p2.presenter.P2Presenter;

/**
 * A View interface for using the view
 * @author Sebastian Börebäck on 2016-03-08.
 */
public interface MainView {

	/**
	 * Connect the presenter to the view
	 * @param ctrl the presenter (P2Controller)
	 */
	void setPresenter(P2Presenter ctrl);

	/**
	 * Update the view from the model
	 */
	void updateViewFromModel();

	/**
	 * Start/show the view
	 */
	void open();

	/**
	 * Close the view
	 */
	void close();

	/**
	 * Update the model from the view
	 */
	void updateModelFromView();

	/**
	 * Set the places used by the comboboxes
	 * @param places the list of places
	 */
	void setPlaces(Place[] places);
}
