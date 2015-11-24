/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg3;

import skola.lab21.upg2.NameProfession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class TestTitle extends JPanel{

    private Title northTitle = new Title("Rot und Schwarz",Font.BOLD,18,Color.RED,Color.BLACK);
    private Title centerTitle= new Title("Blau text - gelb hintergrund", Font.PLAIN,14,Color.BLUE,Color.YELLOW);
    private Title southTitle = new Title("Diesem Titel in suden sind",Font.ITALIC,10, Color.WHITE, Color.BLACK);

    public TestTitle() {
        setPreferredSize(new Dimension(300,200));
        setLayout(new BorderLayout());
        this.add(northTitle, BorderLayout.NORTH);
        this.add(centerTitle, BorderLayout.CENTER);
        this.add(southTitle, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestTitle());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}



