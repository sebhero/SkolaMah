/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */

/**
 * Handel's the User inputs in the game
 */
public class SSPUserInput extends JPanel {

	private JButton btnPose;
	private JButton btnSten;
	private JButton btnSax;
	private JButton btnNewGame;
	private JPanel pnlChoiceButtons = new JPanel(new FlowLayout());

	private SSPController controller;

	/**
	 * Creates a new user input object that handles users inputs
	 * 
	 * @param controller
	 *            take a controller
	 */
	public SSPUserInput(SSPController controller) {
		this.controller = controller;
		controller.setUserInput(this);

		// setPreferredSize(new Dimension(300, 360));
		setLayout(new BorderLayout());

		initButtons(controller);

		// add the buttons to the panel
		pnlChoiceButtons.add(btnSten, BorderLayout.WEST);
		pnlChoiceButtons.add(btnSax, BorderLayout.CENTER);
		pnlChoiceButtons.add(btnPose, BorderLayout.EAST);


		// add the action using lambda expressions

		JButton btnEndGame = new JButton("Avsluta");
		btnEndGame.addActionListener(ae -> {
			System.exit(0);
		});

		// add the button to the main panel SSPUserInputs
		add(pnlChoiceButtons, BorderLayout.NORTH);
		this.add(btnNewGame, BorderLayout.CENTER);
		add(btnEndGame, BorderLayout.SOUTH);

		// sets the game status to started
		this.setGameStatus(true);

	}

	/**
	 * Init the buttons and add actionlisteners
	 * 
	 * @param controller
	 */
	private void initButtons(SSPController controller) {

		btnSten = new JButton("Sten");
		btnSax = new JButton("Sax");
		btnPose = new JButton("Pose");
		// add new game button
		btnNewGame = new JButton("Nytt spel");

		btnSten.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newChoice(0);
			}
		});

		btnSax.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newChoice(1);
			}
		});

		btnPose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newChoice(2);
			}
		});

		btnNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newGame();
			}
		});


		// better way
		// add the action listner using lambda expressions
		// https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
		// also using enums would improve the code...

		// btnNewGame.addActionListener(ae -> controller.newGame());
		// btnSten.addActionListener(ae -> {
		// controller.newChoice(0);
		// });
		//
		//
		// // add the action listner
		// btnSax.addActionListener(ae -> {
		// controller.newChoice(1);
		// });
		//
		//
		// // add the action listner
		// btnPose.addActionListener(ae -> {
		// controller.newChoice(2);
		// });
	}

	/**
	 * Handles the game status for the buttons. if the game has ended playingStatus is false. if the game har started playingStatus is true
	 * 
	 * @param playingStatus
	 *            the state the game is in.
	 */
	public void setGameStatus(boolean playingStatus) {
		btnSten.setEnabled(playingStatus);
		btnSax.setEnabled(playingStatus);
		btnPose.setEnabled(playingStatus);
		// if the game has ended false this is true
		btnNewGame.setEnabled(!playingStatus);

	}
}
