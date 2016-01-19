/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.p3;

import java.text.MessageFormat;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */
public class SSPController {

	private SSPViewer viewer;
	private SSPPlayer cpuPlayer;
	private int cpuWon = 0;
	private int playerWon = 0;
	private String winner;
	private boolean playingStatus = false;
	private SSPUserInput userInput;

	/**
	 * Controller for the SSP game
	 * 
	 * @param player
	 *            CPU player
	 * @param viewer
	 *            the view to display game results
	 */
	public SSPController(SSPPlayer player, SSPViewer viewer) {
		this.cpuPlayer = player;
		this.viewer = viewer;
	}

	/**
	 * Handles starting a new game
	 */
	public void newGame() {
		cpuWon = 0;
		playerWon = 0;
		playingStatus = true;
		this.userInput.setGameStatus(playingStatus);
		updateView(4, 4);

	}

	/**
	 * Handle finished game
	 */
	public void doGameEnd() {

		// show text how is winner
		System.out.println(MessageFormat.format("Winner is {0}", winner));
		this.viewer.showWinner(MessageFormat.format("Winner is {0}", winner));
		// Tells the inputs model that the game has ended
		playingStatus = false;
		this.userInput.setGameStatus(playingStatus);
	}

	/**
	 * Handle when player makes a new choice
	 * 
	 * @param playerChoice the new choice from player
	 */
	public void newChoice(int playerChoice) {

		int cpuChoice = cpuPlayer.newChoice();
		System.out.println(MessageFormat.format("player choose: {0} and cpu choose> {1}", playerChoice, cpuChoice));

		// 0 lika
		// -1 och 2 human vinn
		// otherwise cpu win

		int result = playerChoice - cpuChoice;

		switch (result) {

		case 0:
			System.out.println("Same, no winner");
			break;
		case -1:
		case 2:
			System.out.println("Player won round");
			playerWon++;
			break;
		default:
			System.out.println("CPU won round");
			cpuWon++;
			break;
		}

		// Update the view
		updateView(playerChoice, cpuChoice);

		if (checkForWinner(playerWon, cpuWon))
		{
			doGameEnd();
		}

	}

	/**
	 * Updates the view with new game stats
	 * 
	 * @param playerChoice
	 * @param cpuChoice
	 */
	private void updateView(int playerChoice, int cpuChoice) {

		this.viewer.updateWithNewStats(this.playerWon, this.cpuWon, playerChoice, cpuChoice);
	}

	/**
	 * Check if there is a winner
	 * 
	 * @param playerWon
	 *            times player has won
	 * @param cpuWon
	 *            times cpu has won
	 * @return true if there is a winner
	 */
	private boolean checkForWinner(int playerWon, int cpuWon) {

		if (playerWon == 3)
		{
			winner = "Player";
			return true;
		}
		if (cpuWon == 3) {
			winner = "CPU";
			return true;
		}
		// no Winner
		return false;

	}

	/**
	 * Set the userInputs to controller. Used for handeling new game and end game
	 * 
	 * @param sspUserInput
	 *            the user input object
	 */
	public void setUserInput(SSPUserInput sspUserInput) {
		this.userInput = sspUserInput;
	}
}
