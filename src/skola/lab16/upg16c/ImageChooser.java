/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16.upg16c;

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

    public ImageChooser(Controller controller) {

        setLayout(new BorderLayout());
        this.controller = controller;
        JPanel pnlRadioButtons = new JPanel(new GridLayout(5, 1));

        btnRemoveImage = new JButton("Ta bort bild");

//        btnRemoveImage.addActionListener(ae -> {});
        rbLondon = new JRadioButton ("London");
        rbMovielogo = new JRadioButton ("FilmLogga");
        rbLugi = new JRadioButton ("Lugi");
        rbTandem = new JRadioButton ("Tandem");
        rbThisProgram = new JRadioButton ("Detta program");

        addListeners();

        pnlRadioButtons.add(rbLondon);
        pnlRadioButtons.add(rbMovielogo);
        pnlRadioButtons.add(rbLugi);
        pnlRadioButtons.add(rbTandem);
        pnlRadioButtons.add(rbThisProgram);



        add(pnlRadioButtons, BorderLayout.CENTER);
        add(btnRemoveImage, BorderLayout.SOUTH);







    }

    private void addListeners() {
        rbLondon.addActionListener(ae -> {
            controller.newImage("/skola/lab16/london06.jpg");
        });
        rbLugi.addActionListener(ae -> {
            controller.newImage("/skola/lab16/lugi.gif");
        });
        rbMovielogo.addActionListener(ae -> {
            controller.newImage("/skola/lab16/filmlogga.jpg");
        });
        rbTandem.addActionListener(ar -> {
            controller.newImage("/skola/lab16/tandem1.jpg");
        });

        rbThisProgram.addActionListener(ae ->{
            controller.newImage("/skola/lab16/program.bmp");
        });

        btnRemoveImage.addActionListener(ar -> controller.eraseImage());
    }
}
