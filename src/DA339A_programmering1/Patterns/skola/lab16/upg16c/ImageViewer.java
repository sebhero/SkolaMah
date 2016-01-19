/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab16.upg16c;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Sebastian Börebäck on 2015-10-19.
 */

/**
 * A image viewer used to view images
 */
public class ImageViewer extends JPanel{

    private JLabel lblTitle = new JLabel();
    private JLabel lblImage = new JLabel();

    /**
     * Creats and addes the title and image label holder
     */
    public ImageViewer() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(640,480));


        this.add(lblTitle,BorderLayout.NORTH);
        this.add(lblImage,BorderLayout.CENTER);



    }

    /**
     * Shows a image provided the file path
     * @param filepath the filepath
     */
    public void showImage(String filepath)
    {

        try {
            System.out.println(filepath);
            this.lblImage.setText("");
            URL imagepath = this.getClass().getResource(filepath);
            ImageIcon icon;

            //If the image is a bmp it need to use ImageIO,read to read it in
            //because ImageIcon only can load jpg, png files
            if(filepath.contains("bmp"))
            {
                //loades the bmp to a image
                Image image = ImageIO.read(imagepath);
                //creates the image icon
                icon = new ImageIcon(image);

            }
            else
            {
                //create the image icon
                icon = new ImageIcon(imagepath);
            }

            this.lblImage.setIcon(icon);

            //sets the title
            this.lblTitle.setText(filepath);
        }
        catch (Exception e)
        {
            System.err.println("Error could dispalay image\npath: "+filepath);
            noImage();
        }
    }

    /**
     * Remove the image from the view
     */
    public void noImage()
    {

        this.lblTitle.setText("");
        this.lblImage.setIcon(null);
        this.lblImage.setText("Ingen bild vald");

    }

    public static void main(String args[]) {
        ImageViewer viewer = new ImageViewer();
        viewer.showImage("/DA339A_programmering1/Patterns/skola/lab16/filmlogga.jpg"); // alt. viewer.noImage();
        JOptionPane.showMessageDialog(null, viewer);
    }
}
