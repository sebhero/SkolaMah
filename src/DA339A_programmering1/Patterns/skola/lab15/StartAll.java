/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab15;

import javax.swing.*;


public class StartAll {

    public void start() {
        JFrame frame = new JFrame("All panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AllPanels());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StartAll app = new StartAll();
        app.start();
    }

}
