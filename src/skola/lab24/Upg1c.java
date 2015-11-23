/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab24;

import skola.lab24.resources.InOut;

/**
 * Created by Sebastian Börebäck on 2015-11-23.
 */
public class Upg1c {

    public static void main( String[] args ) {
        InOut io = new InOut();
        int nbr = io.readInt("Mata in ett tal utan decimaler");
        System.out.println("Inmatat tal: " + nbr);
    }
}
