/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */
public class Piles {
	int pins = 0;
	public void putPins(int pins) {
		this.pins = pins;
	}

	public int size() {
		return pins;
	}

	public void takePins(int numberOfpinsToTake) {
		pins = pins-numberOfpinsToTake;
	}

	public void clear() {
		pins = 0;
	}
}
