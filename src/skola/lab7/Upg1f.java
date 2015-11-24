/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;

import javax.swing.*;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1f {
    // Exempel på lösning

        public static void main( String[] args ) {
            // deklarera variabler, t.ex. nbr1, nbr2 och biggest
            int biggest;
            int value = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
            int value2 = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal igen"));

            if (value > value2) {
                biggest = value;
            }
            else
            {
                biggest = value2;
            }
            JOptionPane.showMessageDialog(null, "biggest ar "+biggest);
        }


}
