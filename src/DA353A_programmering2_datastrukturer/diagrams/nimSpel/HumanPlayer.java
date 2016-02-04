/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

import java.util.Scanner;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */
public class HumanPlayer extends Player {
	Scanner scn = new Scanner(System.in);

	public HumanPlayer(String name, NimGame theGame) {
		super(name, theGame);
	}

	@Override
	public void makeMove() {
		// TODO: 2016-02-04 :21:42 ask user for a move
		System.out.println("Which pile? (1,2,3)");
		int selectedPile = scn.nextInt();
		System.out.println("how many (1-2)?");
		int howMany = scn.nextInt();

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
			default:
				System.out.println("incorrect pile!");
		}

		if (whichPile != null && theGame.possibleMove(howMany, whichPile)) {
			theGame.takePins(howMany,whichPile);
		} else {
			System.out.println("move is not possible");
		}

		if (!theGame.morePins()) {
			System.out.println("you lost, you took the last pin!");
			System.out.println("CPU winner!");
		}

	}
}
