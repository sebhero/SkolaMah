/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */
public abstract class Player {
	private String name;
	protected NimGame theGame;

	public Player(String name, NimGame theGame) {
		this.name = name;
		this.theGame = theGame;
	}

	public String getName() {
		return name;
	}


	public abstract void makeMove();

}
