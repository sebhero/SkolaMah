/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab15;

import javax.swing.*;


public class FCConverter {

    public void start() {
        JFrame frame = new JFrame( "Farenheit <-> Celcius" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new FCConverterPanel() );
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        FCConverter app = new FCConverter();
        app.start();
    }
}
