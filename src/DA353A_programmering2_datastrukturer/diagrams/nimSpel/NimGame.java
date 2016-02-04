/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

import java.text.MessageFormat;
import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */



public class NimGame {

	private final Piles piles1;
	private final Piles piles2;
	private final Piles piles3;

	public NimGame() {
		piles1 = new Piles();
		piles2 = new Piles();
		piles3 = new Piles();

	}

	public void setUpNewGame() {
		Random rnd = new Random();
		//ca totalt 30 pinnar
		piles1.putPins(rnd.nextInt(10)+1);
		piles2.putPins(rnd.nextInt(10)+1);
		piles3.putPins(rnd.nextInt(10)+1);
	}

	public void pileSizes() {
		System.out.println(MessageFormat.format("Pile 1 = {0}", piles1.size()));
		System.out.println(MessageFormat.format("Pile 2 = {0}", piles2.size()));
		System.out.println(MessageFormat.format("Pile 3 = {0}", piles3.size()));
	}

	public boolean possibleMove(int numberOfpinsToTake, PILECHOICE whichPile) {

		switch (whichPile) {
			case ONE:
				return  (piles1.size() >= numberOfpinsToTake);
			case TWO:
				return  (piles2.size() >= numberOfpinsToTake);
			case THREE:
				return  (piles3.size() >= numberOfpinsToTake);
		}
		System.out.println("return false");
		//never called.
		return false;
	}

	public void takePins(int numberOfpinsToTake, PILECHOICE whichPile) {
		if (!possibleMove(numberOfpinsToTake, whichPile)) {
			//throw new RuntimeException("Is not possible to do this move!");
			System.out.println("Not possible move");
			return;
		}
		switch (whichPile) {
			case ONE:
				piles1.takePins(numberOfpinsToTake);
				break;
			case TWO:
				piles2.takePins(numberOfpinsToTake);
				break;
			case THREE:
				piles3.takePins(numberOfpinsToTake);
				break;
		}
	}

	public boolean morePins() {
		if (possibleMove(1, PILECHOICE.ONE) ||
			possibleMove(1, PILECHOICE.TWO) ||
			possibleMove(1, PILECHOICE.THREE))
		{
			return true;
		}
		return false;
	}


}
