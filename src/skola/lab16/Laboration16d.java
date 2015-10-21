/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16;

import skola.lab16.upg16c.Controller;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-10-20.
 */
public class Laboration16d {



    public static void main(String[] args) {
        Laboration16d lab16d = new Laboration16d();
        lab16d.action();
    }

    private void action() {

        ColorPanelView labelPanel = new ColorPanelView();
        Controller controller = new Controller(labelPanel);

        ColorPanel colorPanel = new ColorPanel(controller);
        showFrame("ColorChooser", 50, 50, colorPanel);
        showFrame("Color viewer",500,50,labelPanel);


    }

    private void showFrame(String title, int x, int y, JPanel panel) {

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(x,y);
        frame.setVisible(true);

    }


}
