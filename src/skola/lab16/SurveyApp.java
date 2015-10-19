/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16;

import skola.lab15.FCConverterPanel;

import javax.swing.*;

/**
 * Created by seb on 2015-10-19.
 */
public class SurveyApp {

    public void start() {
        JFrame frame = new JFrame( "survey" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new SurveyPanel() );
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SurveyApp().start();
    }
}
