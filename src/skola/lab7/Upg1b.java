/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;

import javax.swing.*;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1b {

    public static void main(String[] args) {

        int value = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
        if (value > 100) {
            JOptionPane.showMessageDialog(null, "Talet ar storre an 100");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Talet ar hogst 100");
        }
    }
}
