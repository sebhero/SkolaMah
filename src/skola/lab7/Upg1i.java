/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;

import skola.lab24.Upg1;

import javax.swing.*;
import java.util.GregorianCalendar;

/**
 * Created by seb on 2015-11-24.
 */
public class Upg1i {


    public void leapYear() {
        int year;
        String message = "";
        year = Integer.parseInt( JOptionPane.showInputDialog("Ange nuvarande år") );

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        boolean isLeap = cal.isLeapYear(year);

        if (isLeap) {
            JOptionPane.showMessageDialog( null, "År " + year + " är ett skott ar");
        }
        else {
            JOptionPane.showMessageDialog( null, "År " + year + " är inte ett skott ar");
        }


        // alt.
//        if(year<1582) {
//            JOptionPane.showMessageDialog( null, "År " + year +
//                    " är före den Gregorianska kalendern");
//        } else {
//            if( year % 4 == 0) { // Kan vara skottår
//                if((year % 100 == 0) && (year % 400 != 0)) {
//                    JOptionPane.showMessageDialog( null, "År " + year +
//                            " är inte skottår");
//                } else {
//                    JOptionPane.showMessageDialog( null, "År " + year +
//                            " är skottår");
//                }
//            } else {
//                JOptionPane.showMessageDialog( null, "År " + year +
//                        " är inte skottår");
//            }
//        }
    }

    public static void main(String[] args) {
        Upg1i p7i = new Upg1i();
        p7i.leapYear();
    }


}
