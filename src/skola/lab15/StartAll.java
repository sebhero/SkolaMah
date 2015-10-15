/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab15;

import javax.swing.*;

/**
 * Created by sebadmin on 2015-10-15.
 */
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
