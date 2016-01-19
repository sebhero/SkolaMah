/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab16.upg16c;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-10-19.
 */
public class ImageApp {

    /**
     * Creates the Frame where the panels are loaded into
     * @param panel
     * @param title
     */
    public void newFrame(JPanel panel, String title) {
        JFrame frame = new JFrame( title );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.add( panel );
        frame.pack();
        frame.setVisible( true );
        frame.setLocation(300,50);
    }
    public static void main(String[] args) {
        ImageApp app = new ImageApp();
        ImageViewer viewer = new ImageViewer();
        Controller cont = new Controller( viewer );
        ImageChooser chooser = new ImageChooser( cont );
        app.newFrame( viewer, "Image viewer" );
        app.newFrame( chooser, "Image chooser" );
    }
}
