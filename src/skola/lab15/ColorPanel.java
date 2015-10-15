/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab15;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorPanel extends JPanel{


    private final JLabel pickColor;
    private final JRadioButton radio1;
    private final JRadioButton radio2;
    private final JRadioButton radio4;
    private final JRadioButton radio3;


    public ColorPanel()
    {
        setPreferredSize(new Dimension(200, 130));

        Random rnd = new Random();

        pickColor = new JLabel("Pick a color");

        radio1 = new JRadioButton("Red");
        radio2 = new JRadioButton("Green");
        radio3 = new JRadioButton("Blue");
        radio4 = new JRadioButton("Slump");

        //dimesion for the radionbuttons so the are in row
        Dimension rdDimension = new Dimension(180, 20);

        radio1.setPreferredSize(rdDimension);
        radio2.setPreferredSize(rdDimension);
        radio3.setPreferredSize(rdDimension);
        radio4.setPreferredSize(rdDimension);


        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);

        //add action listner
        radio1.addActionListener(ae ->{
            if(radio1.isSelected())
                setBackground(Color.RED);
        });

        radio2.addActionListener(ae -> setBackground(Color.GREEN));

        radio3.addActionListener(ae -> setBackground(Color.blue));

        radio4.addActionListener(ae ->{
            int choice = rnd.nextInt(3);

            switch (choice)
            {
                case 1:
                    setBackground(Color.RED);
                break;
                case 2:
                    setBackground(Color.GREEN);
                break;
                case 0:
                    setBackground(Color.blue);
                break;
            }
        });

        add(pickColor);
        add(radio1);
        add(radio2);
        add(radio3);
        add(radio4);


    }

    public static void main(String[] args) {
        ColorPanel panel = new ColorPanel();
        JOptionPane.showMessageDialog(null, panel);
    }



}
