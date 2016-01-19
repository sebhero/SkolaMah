/*
 * Author: Sebastian Börebäck Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.p3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.MessageFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */

/**
 * A view to display game status
 */
public class SSPViewer extends JPanel {

	private final JLabel lbWinner;
	private final JLabel lbHumanStats;
	private final JLabel lbCPUStats;
	private final JLabel lbHumanPlayed;
	private final JLabel lbCPUPlayed;

	/**
	 * View for displaying the game results
	 */
	public SSPViewer() {

		setPreferredSize(new Dimension(200, 200));
		setLayout(new BorderLayout());
		JPanel pnlStats = new JPanel(new GridLayout(3, 2));

		lbWinner = new JLabel("Först till 3 vinner");
		JLabel lbHuman = new JLabel("Human");
		JLabel lbCPU = new JLabel("Computer");

		lbHumanStats = new JLabel("0");
		lbCPUStats = new JLabel("0");
		lbHumanPlayed = new JLabel("");
		lbCPUPlayed = new JLabel("");

		pnlStats.add(lbHuman);
		pnlStats.add(lbCPU);
		pnlStats.add(lbHumanStats);
		pnlStats.add(lbCPUStats);
		pnlStats.add(lbHumanPlayed);
		pnlStats.add(lbCPUPlayed);

		add(lbWinner, BorderLayout.NORTH);
		add(pnlStats);

	}

	/**
	 * Updates the game stats
	 * 
	 * @param playerWon
	 *            many times player won
	 * 
	 * @param cpuWon
	 *            many times cpu won
	 * @param playerChoice
	 *            what the play picked
	 * @param cpuChoice
	 *            what the cpu picked
	 */
	public void updateWithNewStats(int playerWon, int cpuWon, int playerChoice, int cpuChoice) {
		System.out.println(MessageFormat.format("human wons> {0}, cpu wons> {1}", playerWon, cpuWon));

		this.lbWinner.setText("");
		this.lbHumanStats.setText(String.valueOf(playerWon));
		this.lbCPUStats.setText(String.valueOf(cpuWon));

		this.lbHumanPlayed.setText(getChoiceText(playerChoice));
		this.lbCPUPlayed.setText(getChoiceText(cpuChoice));
	}

	/**
	 * Get the string value of the choice
	 * 
	 * @param choice
	 *            the int value of the choice
	 * 
	 * @return a String for the choice
	 */
	private String getChoiceText(int choice) {
		switch (choice)
		{
		case 0:
			return "Sten";
		case 1:
			return "Sax";
		case 2:
			return "Pose";
		default:
		case 4:
			return "";
		}
		// If couldnt find the type
		//return "Didnt find choice";
	}

	/**
	 * Show winning text
	 * 
	 * @param winner
	 *            the text string to display.
	 * 
	 */
	public void showWinner(String winner) {
		this.lbWinner.setText(winner);
	}
}
