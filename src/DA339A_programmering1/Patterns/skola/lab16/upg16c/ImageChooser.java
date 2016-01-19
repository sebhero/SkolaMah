/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab16.upg16c;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Sebastian 2015-10-19.
 */
public class ImageChooser extends JPanel{

    private final JRadioButton rbLondon;
    private final JRadioButton rbMovielogo;
    private final JRadioButton rbLugi;
    private final JRadioButton rbTandem;
    private final JRadioButton rbThisProgram;
    private final JButton btnRemoveImage;
    private Controller controller;

    /**
     * A image chooser. a menu where you can choose a image to display.
     * @param controller the controller for handling the communication between the view and chooser
     */
    public ImageChooser(Controller controller) {

        setLayout(new BorderLayout());
        this.controller = controller;

        /**
         * Create a panel for the radio buttons
         * sets so it can have 5 rows and 1 column
         */
        JPanel pnlRadioButtons = new JPanel(new GridLayout(5, 1));

        btnRemoveImage = new JButton("Ta bort bild");

        rbLondon = new JRadioButton ("London");
        rbMovielogo = new JRadioButton ("FilmLogga");
        rbLugi = new JRadioButton ("Lugi");
        rbTandem = new JRadioButton ("Tandem");
        rbThisProgram = new JRadioButton ("Detta program");

        //add listners
        addListeners();

        //add radiobuttons to panel
        pnlRadioButtons.add(rbLondon);
        pnlRadioButtons.add(rbMovielogo);
        pnlRadioButtons.add(rbLugi);
        pnlRadioButtons.add(rbTandem);
        pnlRadioButtons.add(rbThisProgram);

        //add radiobutton panel and remove button
        add(pnlRadioButtons, BorderLayout.CENTER);
        add(btnRemoveImage, BorderLayout.SOUTH);

    }

    /**
     * Adds listners on the buttons
     */
    private void addListeners() {
        rbLondon.addActionListener(ae -> {
            controller.newImage("/DA339A_programmering1/Patterns/skola/lab16/london06.jpg");
        });
        rbLugi.addActionListener(ae -> {
            controller.newImage("/DA339A_programmering1/Patterns/skola/lab16/lugi.gif");
        });
        rbMovielogo.addActionListener(ae -> {
            controller.newImage("/DA339A_programmering1/Patterns/skola/lab16/filmlogga.jpg");
        });
        rbTandem.addActionListener(ae -> {
            controller.newImage("/DA339A_programmering1/Patterns/skola/lab16/tandem1.jpg");
        });

        rbThisProgram.addActionListener(ae ->{
            controller.newImage("/DA339A_programmering1/Patterns/skola/lab16/program.bmp");
        });

        //remove the current displayed image
        btnRemoveImage.addActionListener(ae -> controller.eraseImage());
    }
}
