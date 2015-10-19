/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16.upg16c;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by sebadmin on 2015-10-19.
 */
public class ImageViewer extends JPanel{

    private JLabel lblTitle = new JLabel();
    private JLabel lblImage = new JLabel();

    public ImageViewer() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(640,480));


        this.add(lblTitle,BorderLayout.NORTH);
        this.add(lblImage,BorderLayout.CENTER);



    }

    public void showImage(String filename)
    {
        try {
            System.out.println(filename);
            this.lblImage.setText("");
            URL imagepath = this.getClass().getResource(filename);
            this.lblImage.setIcon(new ImageIcon(imagepath));
            this.lblTitle.setText(filename);
        }
        catch (Exception e)
        {
            System.err.println("Error could dispalay image\npath: "+filename);
            noImage();
        }
    }

    public void noImage()
    {

        this.lblTitle.setText("");
        this.lblImage.setIcon(null);
        this.lblImage.setText("Ingen bild vald");

    }

    public static void main(String args[]) {
        ImageViewer viewer = new ImageViewer();
        viewer.showImage("/skola/lab16/filmlogga.jpg"); // alt. viewer.noImage();
        JOptionPane.showMessageDialog(null, viewer);
    }
}
