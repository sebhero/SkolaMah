/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab24;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-11-23.
 */
public class Upg1 {

    public static void main(String[] args) {
        int value = 0;
        boolean inputOK = false;
        do {
            try {
                value = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
                //blir true när det kommer in ett int heltal alltså högre än int min och
                //minde än int max samt är inte "" tomm sträng eller med text
                inputOK = true;
            }
            catch( NumberFormatException ex ) {
                System.out.println(ex.toString());
            }
        } while( inputOK == false );
        System.out.println("Inmatat tal: " + value);
    }
}
