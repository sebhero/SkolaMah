/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.display;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * Display the game
 */
public class Display {

    private JFrame frame;

    private Canvas canvas;

    private String title;
    private int width,height;

    public Display( String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //sets in center of screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        Dimension canvasDim = new Dimension(width, height);
        canvas.setPreferredSize(canvasDim);
        canvas.setMaximumSize(canvasDim);
        canvas.setMinimumSize(canvasDim);
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

    }
}
