/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab24;

import skola.lab24.resources.InOut;

/**
 * Created by Sebastian Börebäck on 2015-11-23.
 */
public class Upg1b {
    public static void main( String[] args ) {
        InOut io = new InOut();
        int nbr = io.readInt();
        System.out.println( "Inmatat tal: " + nbr );
    }
}