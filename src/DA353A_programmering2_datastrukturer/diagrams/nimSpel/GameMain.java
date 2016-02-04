/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.diagrams.nimSpel;

/**
 * Created by Sebastian Börebäck on 2016-02-04.
 */
public class GameMain {
	public static void main(String[] args) {
		NimGame theGame = new NimGame();
		Player hm = new HumanPlayer("seb",theGame);
		Player cpu = new CPUPlayer("cpu",theGame);
		theGame.setUpNewGame();

		System.out.println("start the game");
		while (theGame.morePins()) {
			theGame.pileSizes();
			System.out.println("player move");
			hm.makeMove();
			if (theGame.morePins()) {
				System.out.println("cpu move");
				cpu.makeMove();
			}
		}
		System.out.println("game over");

	}
}
