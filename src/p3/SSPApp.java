/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-10-21.
 */
public class SSPApp {

    public static void main(String[] args) {
        SSPPlayer player = new SSPPlayer();
        SSPViewer viewer = new SSPViewer();
        SSPController controller = new SSPController(player,viewer);
        SSPUserInput userInput = new SSPUserInput(controller);

        JFrame frame1 = new JFrame("SSPViewer");
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.add(viewer);
        frame1.pack();
        frame1.setVisible(true);

        JFrame frame2 = new JFrame("SSPUserInput");
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.add(userInput);
        frame2.pack();
        frame2.setVisible(true);

    }

}
