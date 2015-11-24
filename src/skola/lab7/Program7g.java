/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;
import javax.swing.*;

public class Program7g {
	
    public void exercise() {
        String name;
        int nbr1, nbr2;
        System.out.println();
        name = JOptionPane.showInputDialog("Ange ditt namn");
        nbr1 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal"));
        nbr2 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal till"));

        try {
            System.out.println();
            System.out.println(name + ", så här blir det: ");
            System.out.println("Addition:                 " + nbr1 + "+" + nbr2
                    + "=" + (nbr1 + nbr2));
            System.out.println("Subtraktion:              " + nbr1 + "-" + nbr2
                    + "=" + (nbr1 - nbr2));
            System.out.println("Multiplikation:           " + nbr1 + "*" + nbr2
                    + "=" + nbr1 * nbr2);
            System.out.println("Division:                 " + nbr1 + "/" + nbr2
                    + "=" + (double) nbr1 / nbr2);
            System.out.println("Heltalsdivision:          " + nbr1 + "/" + nbr2
                    + "=" + nbr1 / nbr2);
            System.out.println("Rest vid heltalsdivision: " + nbr1 + "%" + nbr2
                    + "=" + nbr1 % nbr2);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("You cant dived with Zero");
        }
    }

    public static void main(String[] args) {
        Program7g p7g = new Program7g();
        p7g.exercise();
    }
}
