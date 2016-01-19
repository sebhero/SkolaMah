/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab7;

import javax.swing.*;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1h {

    public void exercise() {
        String name;
        int nbr1, nbr2, nbr3;
        System.out.println();
        nbr1 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal"));
        nbr2 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal till"));
        nbr3 = Integer.parseInt(JOptionPane.showInputDialog("Ange ett tal till"));

        if (nbr1 > nbr2 && nbr1 > nbr3) {
            System.out.println("nbr1 ar storst "+nbr1);
        }
        else
        if (nbr2 > nbr1 && nbr2 > nbr3) {
            System.out.println("nbr2 ar storst "+nbr2);
        }
        else
            System.out.println("nbr3 ar storst "+nbr3);
    }



    public static void main(String[] args) {
        Upg1h p7g = new Upg1h();
        p7g.exercise();
    }

}
