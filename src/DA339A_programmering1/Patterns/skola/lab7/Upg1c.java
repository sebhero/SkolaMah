/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab7;

import javax.swing.*;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1c {

    public static void main(String[] args) {

        int value = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
        if (value > 0 && value <= 17) {
            JOptionPane.showMessageDialog(null, "du ar ett barn");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "du ar vuxen");
        }
    }
}
