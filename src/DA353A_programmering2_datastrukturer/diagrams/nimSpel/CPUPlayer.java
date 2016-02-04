/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */
public class CPUPlayer extends Player {
	Random rnd = new Random();

	public CPUPlayer(String name, NimGame theGame) {
		super(name, theGame);
	}

	@Override
	public void makeMove() {
		int selectedPile = rnd.nextInt(2) + 1;

		PILECHOICE whichPile = getPile(selectedPile);

		int canTake;

		if (theGame.possibleMove(2, whichPile)) {
			System.out.println("take "+2+" from "+whichPile);
			theGame.takePins(2, whichPile);
		} else {
			if (theGame.possibleMove(1, whichPile)) {
				System.out.println("take "+1+" from "+whichPile);
				theGame.takePins(1, whichPile);
			} else {
				//could take 1 or 2 from pile check other piles
				switch (whichPile) {
					case ONE:
						canTake = tryPile(PILECHOICE.TWO);
						if (canTake > 0) {
							System.out.println("take "+canTake+" from "+PILECHOICE.TWO);
							theGame.takePins(canTake, PILECHOICE.TWO);
						} else {
							canTake = tryPile(PILECHOICE.THREE);
							if (canTake > 0) {
								System.out.println("take "+canTake+" from "+PILECHOICE.THREE);
								theGame.takePins(canTake, PILECHOICE.THREE);
							} else {
								doLose();
							}
						}
						break;
					case TWO:
						canTake = tryPile(PILECHOICE.ONE);
						if (canTake > 0) {
							System.out.println("take "+canTake+" from "+PILECHOICE.ONE);
							theGame.takePins(canTake, PILECHOICE.ONE);
						} else {

							canTake = tryPile(PILECHOICE.THREE);
							if (canTake > 0) {
								System.out.println("take "+canTake+" from "+PILECHOICE.THREE);
								theGame.takePins(canTake, PILECHOICE.THREE);
							} else {
								doLose();
							}
						}
						break;
					case THREE:
						canTake = tryPile(PILECHOICE.TWO);
						if (canTake > 0) {
							System.out.println("take "+canTake+" from "+PILECHOICE.TWO);
							theGame.takePins(canTake, PILECHOICE.TWO);
						} else {
							canTake = tryPile(PILECHOICE.ONE);
							if (canTake > 0) {
								System.out.println("take "+canTake+" from "+PILECHOICE.ONE);
								theGame.takePins(canTake, PILECHOICE.ONE);
							} else {
								doLose();
							}
						}
						break;
				}
			}

		}

	}

	private void doLose() {
		System.out.println("you lost, you took the last pin!");
		System.out.println("Human player is winner!");
	}

	private int tryPile(PILECHOICE whichPile) {
		if (theGame.possibleMove(2, whichPile)) {
			return 2;
		} else if (theGame.possibleMove(1, whichPile)) {
			return 1;
		}
		return -1;
	}

	private PILECHOICE getPile(int selectedPile) {
		PILECHOICE whichPile = null;
		switch (selectedPile) {
			case 1:
				whichPile = PILECHOICE.ONE;
				break;
			case 2:
				whichPile = PILECHOICE.TWO;
				break;
			case 3:
				whichPile = PILECHOICE.THREE;
				break;
		}
		return whichPile;
	}
}
