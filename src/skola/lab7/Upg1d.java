/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;

import javax.swing.*;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1d {


    public static void main(String[] args) {
        String value = JOptionPane.showInputDialog("Mata in ett heltal");

        if (value.length() <= 5)
            JOptionPane.showMessageDialog(null, value + " ditt namn ar kort och fint");
        else {
            JOptionPane.showMessageDialog(null, value + " ditt namn ar langt och svar stavat");
        }
    }

}

