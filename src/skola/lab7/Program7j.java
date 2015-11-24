/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;
import java.awt.*; // Color, Font
import java.util.Calendar;
import javax.swing.ImageIcon;

public class Program7j {

    public void showImage() {
        ImageIcon spring = new ImageIcon("M:/bilder/Spring.jpg");
        ImageIcon summer = new ImageIcon("M:/bilder/Summer.jpg");
        ImageIcon autumn = new ImageIcon("M:/bilder/Autumn.jpg");
        ImageIcon winter = new ImageIcon("M:/bilder/Winter.jpg");
        PaintWindow window;
        Text text=null;
        Calendar cal = Calendar.getInstance();
        ImageIcon image=null;

        int month = 2; // ändra så att månaden hämtas från cal-objektet
        switch (month) {
            case 1: case 2: case 12:
                image = winter;
                break;
            case 3: case 4: case 5:
            	image = spring;
                // Komplettera med kod på Del 1, glöm ej break;
            case 6: case 7: case 8:
            	image = summer;
                // Komplettera med kod på Del 1, glöm ej break;
            case 9: case 10: case 11:
            	image = autumn;
                // Komplettera med kod på Del 1, break; behövs ej
        }
        window = new PaintWindow(image);

        //Komplettera med kod på Del 2
    }

    public static void main(String[] args) {
        Program7j prog = new Program7j();
        prog.showImage();
    }
}
