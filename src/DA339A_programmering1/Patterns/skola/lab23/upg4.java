/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab23;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2015-11-19.
 */
public class upg4 implements Icon{



    // Instansvariabler som används i programmet
// Metoder som används i programmet
    public void paintIcon(Component c, Graphics g, int x, int y) {
Graphics2D g2 = (Graphics2D)g; // Uppgift 4, 5 och 5
// Ritkommandon, metodanrop mm här

        Random rnd = new Random();

        int antal = rnd.nextInt(20)+1;

        for (int i = 0; i < antal; i++) {
            int red = rnd.nextInt(255)+1;
            int blue = rnd.nextInt(255)+1;
            int green = rnd.nextInt(255)+1;
            int width = rnd.nextInt(20)+4;
            int x1 = rnd.nextInt(this.getIconWidth()-10);
            int x2 = rnd.nextInt(this.getIconWidth()-10);
            int y1 = rnd.nextInt(this.getIconHeight()-10);
            int y2 = rnd.nextInt(this.getIconHeight()-10);

            g2.setPaint(new Color(red,green,blue));
            g2.setStroke(new BasicStroke(width));
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }



    }
    public int getIconWidth() {
//        return AAA; // Ersätt AAA med bildens bredd
        return 600;
    }
    public int getIconHeight() {
        //return AAA; // Ersätt AAA med bildens höjd
        return 400;
    }
    public static void main(String[] args) {
        IconWindow.showIcon( new upg4() );
    }

}
