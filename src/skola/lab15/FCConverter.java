/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab15;

import javax.swing.*;

/**
 * Created by sebadmin on 2015-10-15.
 */
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
