/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */

/**
 * Handel's the User inputs in the game
 */
public class SSPUserInput extends JPanel{

    private final JButton btnPose;
    private final JButton btnSten;
    private final JButton btnSax;
    private final JButton btnNewGame;
    private JPanel pnlChoiceButtons = new JPanel(new FlowLayout());


    private SSPController controller;

    /**
     * Creates a new user input object that handles users inputs
     * @param controller take a controller
     */
    public SSPUserInput(SSPController controller) {
        this.controller = controller;
        controller.setUserInput(this);

//        setPreferredSize(new Dimension(300, 360));
        setLayout(new BorderLayout());

        //add the action listner using lambda expressions
        // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

        btnSten = new JButton("Sten");
        btnSten.addActionListener(ae -> {
          controller.newChoice(0);
        });

        btnSax = new JButton("Sax");
        //add the action listner
        btnSax.addActionListener(ae -> {
          controller.newChoice(1);
        });

        btnPose = new JButton("Pose");
        //add the action listner
        btnPose.addActionListener(ae -> {
          controller.newChoice(2);
        });

        //add the buttons to the panel
        pnlChoiceButtons.add(btnSten, BorderLayout.WEST);
        pnlChoiceButtons.add(btnSax, BorderLayout.CENTER);
        pnlChoiceButtons.add(btnPose, BorderLayout.EAST);

        //add new game button
        btnNewGame = new JButton("Nytt spel");
        //add the action using lambda expressions
        btnNewGame.addActionListener(ae -> controller.newGame());

        JButton btnEndGame = new JButton("Avsluta");
        btnEndGame.addActionListener(ae -> {
            System.exit(0);
        });

        //add the button to the main panel SSPUserInputs
        add(pnlChoiceButtons, BorderLayout.NORTH);
        this.add(btnNewGame, BorderLayout.CENTER);
        add(btnEndGame, BorderLayout.SOUTH);

        //sets the game status to started
        this.setGameStatus(true);

    }


    /**
     * Handles the game status for the buttons.
     * if the game has ended playingStatus is false.
     * if the game har started playingStatus is true
     * @param playingStatus the state the game is in.
     */
    public void setGameStatus(boolean playingStatus) {
        btnSten.setEnabled(playingStatus);
        btnSax.setEnabled(playingStatus);
        btnPose.setEnabled(playingStatus);
        //if the game has ended false this is true
        btnNewGame.setEnabled(!playingStatus);

    }
}
