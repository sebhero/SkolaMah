/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16;

import skola.lab16.upg16c.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorPanel extends JPanel{


    private final JLabel pickColor= new JLabel("Pick a color");
    private final JRadioButton rdRed = new JRadioButton("Red");
    private final JRadioButton rdGreen = new JRadioButton("Green");
    private final JRadioButton rdBlue = new JRadioButton("Blue");
    private final JRadioButton rdSlump = new JRadioButton("Slump");
    private Controller controller;


    public ColorPanel()
    {
        this(null);

    }

    private void init() {
        setPreferredSize(new Dimension(200, 130));



        //dimension for the radio buttons so the are in row
        Dimension rdDimension = new Dimension(180, 20);

        rdRed.setPreferredSize(rdDimension);
        rdGreen.setPreferredSize(rdDimension);
        rdSlump.setPreferredSize(rdDimension);
        rdBlue.setPreferredSize(rdDimension);


        ButtonGroup group = new ButtonGroup();
        group.add(rdRed);
        group.add(rdGreen);
        group.add(rdSlump);
        group.add(rdBlue);
        //add listeners
        addListeners();


        add(pickColor);
        add(rdRed);
        add(rdGreen);
        add(rdSlump);
        add(rdBlue);
    }

    private void addListeners() {
        Random rnd = new Random();
        //Color theColor;

        //add action listeners
        rdRed.addActionListener(ae -> {
            if (rdRed.isSelected()) {
                setBackground(Color.RED);
                if(this.controller != null) {
                    this.controller.setLabelPanelViewColor(Color.RED);
                }
            }
        });

        rdGreen.addActionListener(ae -> {
            setBackground(Color.GREEN);
            if(this.controller != null) {
                this.controller.setLabelPanelViewColor(Color.GREEN);
            }

        });

        rdSlump.addActionListener(ae -> {
            setBackground(Color.blue);
            if(this.controller != null) {
                this.controller.setLabelPanelViewColor(Color.BLUE);
            }
        });

        rdBlue.addActionListener(ae -> {
            int red, blue, green;
            red = rnd.nextInt(255);
            blue = rnd.nextInt(255);
            green = rnd.nextInt(255);
            Color theColor = new Color(red, green, blue);

            setBackground(theColor);
            if(this.controller != null) {
                this.controller.setLabelPanelViewColor(theColor);
            }
        });


    }

    public ColorPanel(Controller controller) {
        this.controller = controller;
        init();

    }

    public static void main(String[] args) {
        ColorPanel panel = new ColorPanel();
        JOptionPane.showMessageDialog(null, panel);
    }



}
