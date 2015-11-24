/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab24.resources;

import javax.swing.*;

/**
 * Created by Sebastian Börebäck on 2015-11-23.
 */
public class InOut {

    public static int readInt() {

        return readInt("Mata in ett heltal");

    }

    public static int readInt(String txt) {
        int value = 0;
        boolean inputOK = false;
        try {
            value = Integer.parseInt(JOptionPane.showInputDialog(txt));
            //blir true när det kommer in ett int heltal alltså högre än int min och
            //minde än int max samt är inte "" tomm sträng eller med text
            inputOK = true;
        }
        catch( NumberFormatException ex ) {
            System.out.println(ex.toString());
        }
        //if its false call it again recursive
        if (inputOK == false) {
            return readInt();
        }
        else {
            //if its a number return the value
            return value;
        }
    }

    public static double readDouble(){
        return readDouble("Mata in ett decimaltal");
    }

    public static double readDouble(String txt) {

        System.out.println("calling read double");

        double value = 0;
        boolean inputOK = false;
        try {
            value = Double.parseDouble(JOptionPane.showInputDialog(txt));
            //blir true när det kommer in ett int heltal alltså högre än int min och
            //minde än int max samt är inte "" tomm sträng eller med text
            inputOK = true;
        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println("Number ex> "+ex.toString());
        }
        //if its false call it again recursive
        if (inputOK == false) {
            return readInt();
        }
        else {
            //if its a number return the value
            return value;
        }
    }

}
