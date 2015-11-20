/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab23;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-19.
 */
public class upg3 implements Icon{



    // Instansvariabler som används i programmet
// Metoder som används i programmet
    public void paintIcon(Component c, Graphics g, int x, int y) {
// Graphics2D g2 = (Graphics2D)g; // Uppgift 4, 5 och 5
// Ritkommandon, metodanrop mm här


        g.setColor(new Color(50,30,155));
        g.fillRect(x,y,getIconWidth(),getIconHeight());

        g.setColor(Color.CYAN);
        g.fillRect(x,y,getIconWidth(),getIconHeight()/2);

        g.setColor(Color.YELLOW);
        g.fillOval(150,100,50,50);

        g.setColor(Color.GREEN);
        g.fillOval(250,250,150,20);
        g.fillOval(270,240,120,30);

        g.setColor(new Color(147, 130, 18));
        g.fillRect(300, 250, 7, 15);
        g.fillRect(270, 250, 7, 15);
        g.fillRect(280,250,7,15);

        g.setColor(new Color(11, 119, 9));
        g.fillOval(296, 240, 20, 15);
        g.fillOval(267, 240, 10, 15);
        g.fillOval(275, 240, 15, 15);



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
        IconWindow.showIcon( new upg3() );
    }

}
