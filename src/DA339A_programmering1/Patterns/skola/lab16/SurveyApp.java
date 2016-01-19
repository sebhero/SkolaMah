/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab16;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-10-19.
 */
public class SurveyApp {

    public void start() {
        JFrame frame = new JFrame( "survey" );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add( new SurveyPanel() );
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SurveyApp().start();
    }
}
